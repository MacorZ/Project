/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbc;

import java.sql.*;

/**
 *
 * @author acer
 */
public class ConnectDB {

    public static Connection onData() {
        Connection c = null;
        try {
            String sql = "jdbc:sqlserver://localhost:1433;databaseName=BookDBI;user = sa;password = sa;encrypt=true;trustServerCertificate=true;";
            c = DriverManager.getConnection(sql);
            if (c != null) {
                System.out.println("Thành công!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return c;
    }

    public static void offData(Connection c) {
        if (c != null) {
            try {
                c.close();
                System.out.println("Ngắt thành công!!!");
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }
    public static void main(String[] args) throws SQLException {
        Connection con = null;
        try ( Connection c = onData()) {
            con = c;
            if(con != null){
                System.out.println("Thành công hihi");
            }
        } catch (Exception e) {
            e.printStackTrace();
            
        }
        System.out.println(con);
        con.close();
        System.out.println(con);
    }
}
