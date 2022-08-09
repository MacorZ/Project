/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import model.DonHang;
import repository.DonHangRepository;

/**
 *
 * @author acer
 */
public class DonHangService implements ServiceInterface<DonHang> {

    private static DonHangRepository repo = new DonHangRepository();
    public static DonHangService callClass(){
        return new DonHangService();
    }
    @Override
    public List<DonHang> getAll() {
        return repo.selectAll();
    }

    @Override
    public List<DonHang> getBy(DonHang t) {
        return repo.selectAllByMon(t.getTenMonAn());
    }

    @Override
    public DonHang getOne(DonHang t) {
        return repo.selectOne(t);
    }

    @Override
    public String add(DonHang t) {
        String check = check(t);
        if (!check.equals("")) {
            return check;
        }
        if(getOne(t)!= null){
            return "Don hang da ton tai";
        }
        if (repo.add(t)) {
            return "";
        }
        return "Thêm thất bại";
    }

    @Override
    public String update(DonHang t) {
        String check = check(t);
        if (!check.equals("")) {
            return check;
        }
        if (repo.update(t)) {
            return "";
        }
        return "Cập nhật thất bại";
    }

    @Override
    public String delete(DonHang t) {
        String check = check(t);
        if (!check.equals("")) {
            return check;
        }
        if (repo.delete(t)) {
            return "";
        }
        return "Xóa thất bại";
    }

    private String check(DonHang t) {
            if(t.getTenKhachHang().isEmpty()){
               return "Ten khach hang dang trong"; 
            }
            return"";
    }  
   public int sum(String s){
       if(s.equalsIgnoreCase("Tat ca")){
           return repo.selectSumAll();
       }
      
       return repo.selectSumBy(s);
}
   }
