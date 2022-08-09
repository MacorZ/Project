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
@Table(name = "Ban")
public class Ban {

    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name = "Id", nullable = false)
    private String id;
    @Column(name = "Ma", nullable = true)
    private String maBan;
    @Column(name = "Ten", nullable = true)
    private String tenBan;
    @Nationalized
    @Column(name = "NgaySinh", nullable = true)
    private Date ngaySinh;
    @Column(name = "SoThich", nullable = true)
    @Nationalized
    private String soThich;
    @Column(name = "TrangThai", nullable = true)
    private int conLienLac;

    public Ban(String id, String maBan, String tenBan, Date ngaySinh, String soThich, int conLienLac) {
        this.id = id;
        this.maBan = maBan;
        this.tenBan = tenBan;
        this.ngaySinh = ngaySinh;
        this.soThich = soThich;
        this.conLienLac = conLienLac;
    }

    public Ban(String maBan, String tenBan, Date ngaySinh, String soThich, int conLienLac) {
        this.maBan = maBan;
        this.tenBan = tenBan;
        this.ngaySinh = ngaySinh;
        this.soThich = soThich;
        this.conLienLac = conLienLac;
    }

    public Ban() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaBan() {
        return maBan;
    }

    public void setMaBan(String maBan) {
        this.maBan = maBan;
    }

    public String getTenBan() {
        return tenBan;
    }

    public void setTenBan(String tenBan) {
        this.tenBan = tenBan;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getSoThich() {
        return soThich;
    }

    public void setSoThich(String soThich) {
        this.soThich = soThich;
    }

    public int getConLienLac() {
        return conLienLac;
    }

    public void setConLienLac(int conLienLac) {
        this.conLienLac = conLienLac;
    }

    public String getll() {
        return this.conLienLac == 0 ? "Còn lien lạc" : "Không còn";
    }

    @Override
    public String toString() {
        return "Ban{" + "id=" + id + ", maBan=" + maBan + ", tenBan=" + tenBan + ", ngaySinh=" + ngaySinh + ", soThich=" + soThich + ", conLienLac=" + conLienLac + '}';
    }
    public String getDateToString(){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(this.ngaySinh);
    }
    public Object[] getobj(){
        return new Object[]{
            this.maBan,this.tenBan,this.getDateToString(),this.soThich,this.getll()
        };
    }
}
