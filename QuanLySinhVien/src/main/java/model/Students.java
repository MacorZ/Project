/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Nationalized;

/**
 *
 * @author acer
 */
@Entity
@Table(name = "Students")

public class Students {
    @Id
    @Column(name = "masv",nullable = false,length = 50)
    @Nationalized
    private String studentID;
     @Column(name = "hoten",nullable = true,length = 255)
    @Nationalized
    private String studentName;
     @Column(name = "email",nullable = true,length = 255)
    @Nationalized
    private String Email;
     @Column(name = "sodt",nullable = true,length = 15)
    @Nationalized
    private String phoneNumber;
     @Column(name = "gioitinh",nullable = true)
    private boolean Sex;
     @Column(name = "diachi",nullable = true,length = 255)
    @Nationalized
    private String Address;
     @Column(name = "hinh",nullable = true,length = 255)
    @Nationalized
    private String IMG;

    public Students(String studentID, String studentName, String Email, String phoneNumber, boolean Sex, String Address, String IMG) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.Email = Email;
        this.phoneNumber = phoneNumber;
        this.Sex = Sex;
        this.Address = Address;
        this.IMG = IMG;
    }

    public Students() {
    }

    public Students(String studentID) {
        this.studentID = studentID;
    }
    
    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isSex() {
        return Sex;
    }

    public void setSex(boolean Sex) {
        this.Sex = Sex;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getIMG() {
        return IMG;
    }

    public void setIMG(String IMG) {
        this.IMG = IMG;
    }
 public String getSexToString() {
        return  this.Sex ? "Nam" : "Nu";
    }
    @Override
    public String toString() {
        return "Student_Information{" + "studentID=" + studentID + ", studentName=" + studentName + ", Email=" + Email + ", phoneNumber=" + phoneNumber + ", Sex=" + Sex + ", Address=" + Address + ", IMG=" + IMG + '}';
    }
    public Object[] getObj(){
        return new Object[]{
          studentID,studentName,Email,phoneNumber,getSexToString(),Address,IMG
        };
    }
}
