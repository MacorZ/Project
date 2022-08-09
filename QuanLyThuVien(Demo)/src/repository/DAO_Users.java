/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.List;
import model.Users;
import java.sql.*;
import jdbc.ConnectDB;

/**
 *
 * @author acer
 */
public class DAO_Users implements DAO_interface<Users> {

    public static DAO_Users callClass() {
        return new DAO_Users();
    }

    @Override
    public Users selectObj(Users t) {
        Users us = new Users();
        try {
            Connection c = ConnectDB.onData();
            String sql = "SELECT* FROM Users WHERE UserName = ? AND Password = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, t.getUserName());
            ps.setString(2, t.getPassword());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String userName = rs.getString("UserName");
                String Password = rs.getString("Password");
                String displayName = rs.getString("DisplayName");
                String Description = rs.getString("Description");
                us = new Users(userName, displayName, Password, Description);
            }

            ConnectDB.offData(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (us.getUserName() == null) {
            return null;
        }
        return us;
    }

    @Override
    public List<Users> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static void main(String[] args) {
        Users c = callClass().selectObj(new Users("sea", "Super Administrator", "sa", "Highest role in the system"));
        System.out.println(c);
    }
}
