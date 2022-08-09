/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import model.Ban;
import repository.Banrepository;

/**
 *
 * @author acer
 */
public class Banservice implements Seviceinterface<Ban>{
        private static final Banrepository repo = new Banrepository();
        
    @Override
    public List<Ban> getAll() {
            return repo.getAll();
    }

    @Override
    public Ban getOne(Ban t) {
            return repo.getOne(t);
    }

    @Override
    public String add(Ban t) {
    String check = check(t);
    if(!check.equals("")){
        return check;
    }
    if(getOne(t)!= null){
        return "Ban đã tồn tại";
    }
    return repo.add(t)?"":"Thêm thất bại";
    }

    @Override
    public String update(Ban t) {
         String check = check(t);
    if(!check.equals("")){
        return check;
    }
    return repo.update(t)?"":"Sửa thất bại";
    }

    @Override
    public String delete(Ban t) {
       return repo.delete(t)?"":"Xóa thất bại";
    }

    @Override
    public String check(Ban t) {
            if("".equals(t.getMaBan())) return "Mã bạn trống";
            if("".equals(t.getTenBan())) return "Tên bạn trống";
            if("".equals(t.getSoThich())) return "Sở thích trống";
            if(t.getNgaySinh() == null) return "Ngày sinh trống";
            return "";
    }
    
}
