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
 * @author jacksmacbookpro
 */
@Entity
@Table(name = "Users")
public class User {
    @Id
    @Column(name = "username",nullable = false,length = 50)
    @Nationalized
    private String userName;
    @Column(name = "password",nullable = true,length = 50)
    @Nationalized
    private String Password;
    @Column(name = "role",nullable = true,length = 50)
    @Nationalized
    private String Role;

    public User() {
    }

    public User(String userName, String password, String role) {
        this.userName = userName;
        this.Password = password;
        this.Role = role;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        this.Password = password;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        this.Role = role;
    }

    @Override
    public String toString() {
        return "User{" + "userName=" + userName + ", password=" + Password + ", role=" + Role + '}';
    }

}
