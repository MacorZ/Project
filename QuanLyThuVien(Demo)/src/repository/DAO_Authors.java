/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.ArrayList;
import java.util.List;
import model.Authors;
import java.sql.*;
import jdbc.ConnectDB;

/**
 *
 * @author acer
 */
public class DAO_Authors implements DAO_interface<Authors>,AutoCloseable {

    public static DAO_Authors callClass() {
        return new DAO_Authors();
    }

    @Override
    public Authors selectObj(Authors t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Authors> selectAll() {
        List<Authors> list = new ArrayList<>();
        String sql = "SELECT* FROM Authors";
        try ( Connection c = ConnectDB.onData();  
              PreparedStatement ps = c.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString("au_name");
                String address = rs.getString("au_address");
                Authors at = new Authors(id, name, address);
                list.add(at);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public String getID(String name) {
        String id = "";
        try {
            Connection c = ConnectDB.onData();
            String sql = "SELECT au_id FROM Authors WHERE au_name = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getString("au_id");

            }
            ConnectDB.offData(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;
    }

    @Override
    public void close() throws Exception {
         
    }

}
