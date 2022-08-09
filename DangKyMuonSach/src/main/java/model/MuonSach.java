/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Nationalized;

/**
 *
 * @author acer
 */
@Entity
@Table(name = "MuonSach")
public class MuonSach {
    @Id
    @Column(name = "id",nullable = false)
    @GenericGenerator(name = "generator",strategy = "guid",parameters = {})
    @GeneratedValue(generator = "generator")
    private String id;
    @Column(name = "mamuon",nullable = true)
    private String maMuon;
    @Column(name = "hoten",nullable = true)
    @Nationalized
    private String hoTen;
    @Column(name = "ngaysinh",nullable = true)
    private Date ngaySinh;
    @Column(name = "gioitinh",nullable = true)
    private boolean gioiTinh;
    @Column(name = "tensach",nullable = true)
    @Nationalized
    private String tenSach;

    public MuonSach() {
    }

    public MuonSach(String id, String maMuon, String hoTen, Date ngaySinh, boolean gioiTinh, String tenSach) {
        this.id = id;
        this.maMuon = maMuon;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.tenSach = tenSach;
    }

    public MuonSach(String maMuon, String hoTen, Date ngaySinh, boolean gioiTinh, String tenSach) {
        this.maMuon = maMuon;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.tenSach = tenSach;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaMuon() {
        return maMuon;
    }

    public void setMaMuon(String maMuon) {
        this.maMuon = maMuon;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    @Override
    public String toString() {
        return "MuonSach{" + "id=" + id + ", maMuon=" + maMuon + ", hoTen=" + hoTen + ", ngaySinh=" + ngaySinh + ", gioiTinh=" + gioiTinh + ", tenSach=" + tenSach + '}';
    }
    public String getGT(){
        return this.gioiTinh?"Nam":"Nữ";
    }
    public String getNS(){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(ngaySinh);
    }
    public Object[] getObj(){
        return new Object[]{
            this.maMuon,this.hoTen,this.getNS(),this.getGT(),this.tenSach
        };
    }
}
