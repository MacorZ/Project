/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.List;
import model.Publichers;
import java.sql.*;
import java.util.ArrayList;
import jdbc.ConnectDB;

/**
 *
 * @author acer
 */
public class DAO_Publisher implements DAO_interface<Publichers> {

    public static DAO_Publisher callClass() {
        return new DAO_Publisher();
    }

    @Override
    public Publichers selectObj(Publichers t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Publichers> selectAll() {
        List<Publichers> list = new ArrayList<>();
        try {
            Connection c = ConnectDB.onData();
            String sql = "SELECT* FROM Publishers";
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString("pub_id");
                String name = rs.getString("pub_name");
                String address = rs.getString("pub_address");
                Publichers pc = new Publichers(id, name, address);
                list.add(pc);
            }
            ConnectDB.offData(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public String getID(String name) {
        String id = "";
        try {
            Connection c = ConnectDB.onData();
            String sql = "SELECT pub_id FROM Publishers WHERE pub_name = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getString("pub_id");

            }
            ConnectDB.offData(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;
    }
}
