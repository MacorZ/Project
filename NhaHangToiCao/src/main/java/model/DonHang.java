/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author acer
 */
@Entity
@Table(name = "donhang")
public class DonHang implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "madonhang")
    private int id;
    @Column(name = "tenkhachhang")
    private String tenKhachHang;
    @Column(name = "tenMonAn")
    private String tenMonAn;
    @Column(name = "donGia")
    private int donGia;
    @Column(name = "soDonHang")
    private int soDonHang;
    @Column(name = "thanhTien")
    private int thanhTien;

    public DonHang(int id, String tenKhachHang, String tenMonAn, int donGia, int soDonHang, int thanhTien) {
        this.id = id;
        this.tenKhachHang = tenKhachHang;
        this.tenMonAn = tenMonAn;
        this.donGia = donGia;
        this.soDonHang = soDonHang;
        this.thanhTien = thanhTien;
    }

    public DonHang(String tenKhachHang,String tenMonAn, int donGia, int soDonHang, int thanhTien) {
        this.tenKhachHang = tenKhachHang;
        this.tenMonAn = tenMonAn;
        this.donGia = donGia;
        this.soDonHang = soDonHang;
        this.thanhTien = thanhTien;
    }

    public DonHang() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getTenMonAn() {
        return tenMonAn;
    }

    public void setTenMonAn(String tenMonAn) {
        this.tenMonAn = tenMonAn;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public int getSoDonHang() {
        return soDonHang;
    }

    public void setSoDonHang(int soDonHang) {
        this.soDonHang = soDonHang;
    }

    public int getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(int thanhTien) {
        this.thanhTien = thanhTien;
    }



    @Override
    public String toString() {
        return "DonHang{" + "id=" + id + ", tenKhachHang=" + tenKhachHang + ", sdt=" + ", tenMonAn=" + tenMonAn + ", donGia=" + donGia + ", soDonHang=" + soDonHang + ", thanhTien=" + thanhTien + '}';
    }

   

}
