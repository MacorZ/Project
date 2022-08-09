/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import model.MuonSach;
import repository.Muonrepo;

/**
 *
 * @author acer
 */
public class Muonservice implements Serviceinterface<MuonSach>{
    private static final Muonrepo repo = new Muonrepo();
    @Override
    public List<MuonSach> getAll() {
        return repo.getAll();
    }

    @Override
    public MuonSach getOne(MuonSach t) {
            return repo.getOne(t);
    }

    @Override
    public String add(MuonSach t) {
        String check = check(t);
        if(!check.equals("")) return check;
        if(getOne(t) != null) return "Phiếu mượn đã tồn tại";
        return repo.add(t)?"":"Thêm thất bại";
    }

    @Override
    public String update(MuonSach t) {
 String check = check(t);
        if(!check.equals("")) return check;
        return repo.update(t)?"":"Cập nhật thất bại";
    }

    @Override
    public String delete(MuonSach t) {
       return repo.delete(t)?"":"Xóa thất bại";
    }

    @Override
    public String check(MuonSach t) {
            if("".equals(t.getMaMuon())) return "Mã muon trống";
            if("".equals(t.getHoTen())) return "Mã muon trống";
            if(t.getNgaySinh() == null) return "Ngày sinh trống";
            if("".equals(t.getTenSach())) return "Mã muon trống";
            return "";
    }
    
}
