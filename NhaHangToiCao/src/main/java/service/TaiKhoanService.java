/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import model.TaiKhoan;
import repository.TaiKhoanRepository;

/**
 *
 * @author acer
 */
public class TaiKhoanService implements ServiceInterface<TaiKhoan> {

    private static TaiKhoanRepository repo = new TaiKhoanRepository();
    public static TaiKhoanService callClass(){
        return new TaiKhoanService();
    }
    @Override
    public List<TaiKhoan> getAll() {
        return repo.selectAll();
    }

    @Override
    public List<TaiKhoan> getBy(TaiKhoan t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public TaiKhoan getOne(TaiKhoan t) {
        return repo.selectOne(t);
    }

    @Override
    public String add(TaiKhoan t) {
        String check = check(t);
        if (!check.equals("")) {
            return check;
        }
        if(getOne(t) != null){
            return "Tai khoan da ton tai";
        }
        if (repo.add(t)) {
            return "";
        }
        return "Thêm thất bại";
    }

    @Override
    public String update(TaiKhoan t) {
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
    public String delete(TaiKhoan t) {
        String check = check(t);
        if (!check.equals("")) {
            return check;
        }
        if (repo.delete(t)) {
            return "";
        }
        return "Xóa thất bại";
    }

    public String check(TaiKhoan t) {
        if(t.getTenTaiKhoan().isEmpty()){
            return "Khong de trong tai khoan";
        }
        if(t.getMatKhau().isEmpty()){
            return "Khong de trong mat khau";
        }
        if(t.getTenNV().isEmpty()){
            return "Khong de trong ten nhan vien";
        }
        return "";
    }
    public String Sreach(TaiKhoan t){
         if(t.getTenTaiKhoan().equals("admin") && t.getMatKhau().equals("admin")){
            return "ql";
        }
        TaiKhoan t1 = getOne(t);
        if(t1 == null){
            return " Tài khoản không tồn tại";
        }
        if(!t1.getMatKhau().equals(t.getMatKhau())){
            return "Mật khẩu không đúng";
        }
       
        return "nv";
    }
    
}
