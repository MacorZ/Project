/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.ArrayList;
import java.util.List;
import model.Books;
import java.sql.*;
import jdbc.ConnectDB;

/**
 *
 * @author acer
 */
public class DAO_Books implements DAO_interface<Books> {

    public static DAO_Books callClass() {
        return new DAO_Books();
    }

    @Override
    public Books selectObj(Books t) {
        Books bk = new Books();
        try {
            Connection c = ConnectDB.onData();
            String sql = "SELECT* FROM Authors JOIN Books ON Books.au_id = Authors.au_id\n"
                    + "JOIN Publishers ON Books.pub_id = Publishers.pub_id WHERE book_id = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, t.getBook_ID());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString("book_id");
                String title = rs.getString("title");
                String pub = rs.getString("pub_name");
                String au = rs.getString("au_name");
                String notes = rs.getString("notes");
                String usn = rs.getString("username");
                bk = new Books(id, title, pub, au, notes, usn);
            }
            ConnectDB.offData(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bk;
    }

    @Override
    public List<Books> selectAll() {
        List<Books> list = selectByAll("All");
        return list;
    }

    public List<Books> selectByBookID(String s, String us) {
        String sql = "SELECT* FROM Authors JOIN Books ON Books.au_id = Authors.au_id\n"
                + "JOIN Publishers ON Books.pub_id = Publishers.pub_id\n"
                + "WHERE book_id LIKE '%" + s + "%' AND username = '" + us + "'";
        List<Books> list = selectBy(sql);
        return list;
    }

    public List<Books> selectByBoolTitle(String s, String us) {
        String sql = "SELECT* FROM Authors JOIN Books ON Books.au_id = Authors.au_id\n"
                + "JOIN Publishers ON Books.pub_id = Publishers.pub_id\n"
                + "WHERE pub_name LIKE '%" + s + "%' AND username = '" + us + "'";
        List<Books> list = selectBy(sql);
        return list;
    }

    public List<Books> selectByAuthorName(String s, String us) {
        String sql = "SELECT* FROM Authors JOIN Books ON Books.au_id = Authors.au_id\n"
                + "JOIN Publishers ON Books.pub_id = Publishers.pub_id\n"
                + "WHERE au_name LIKE '%" + s + "%' AND username = '" + us + "'";
        List<Books> list = selectBy(sql);
        return list;
    }

    public List<Books> selectByAll(String us) {
        String sql = "SELECT* FROM Authors JOIN Books ON Books.au_id = Authors.au_id\n"
                + "JOIN Publishers ON Books.pub_id = Publishers.pub_id\n"
                + "WHERE username = '" + us + "'";
        List<Books> list = selectBy(sql);
        return list;
    }

    public List<Books> selectBy(String sql) {

        List<Books> list = new ArrayList<>();
        try {
            Connection c = ConnectDB.onData();
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString("book_id");
                String title = rs.getString("title");
                String pub = rs.getString("pub_name");
                String au = rs.getString("au_name");
                String notes = rs.getString("notes");
                String usn = rs.getString("username");
                Books bk = new Books(id, title, pub, au, notes, usn);
                list.add(bk);
            }

            ConnectDB.offData(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void insert(Books bk) {
        try {
            Connection c = ConnectDB.onData();
            String sql = "INSERT INTO Books(book_id,title,pub_id,au_id,notes,username) VALUES(?,?,?,?,?,?)";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, bk.getBook_ID());
            ps.setString(2, bk.getTitle());
            ps.setString(3, DAO_Publisher.callClass().getID(bk.getPublishers()));
            ps.setString(4, DAO_Authors.callClass().getID(bk.getAuthors()));
            ps.setString(5, bk.getNotes());
            ps.setString(6, bk.getUserName());
            int rs = ps.executeUpdate();
            System.out.println("Thành công: " + rs);
            ConnectDB.offData(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Books bk, String id) {
        try {
            Connection c = ConnectDB.onData();
            String sql = "UPDATE Books SET book_id = ?,title = ?,pub_id = ?,au_id = ?,notes = ? WHERE  book_id = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, bk.getBook_ID());
            ps.setString(2, bk.getTitle());
            ps.setString(3, DAO_Publisher.callClass().getID(bk.getPublishers()));
            ps.setString(4, DAO_Authors.callClass().getID(bk.getAuthors()));
            ps.setString(5, bk.getNotes());
            ps.setString(6, id);
            int rs = ps.executeUpdate();
            System.out.println("Thành công: " + rs);
            ConnectDB.offData(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(String id) {
        try {
            Connection c = ConnectDB.onData();
            String sql = "DELETE Books WHERE book_id = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, id);
            int rs = ps.executeUpdate();
            System.out.println("Thành công: " + rs);
            ConnectDB.offData(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean checkUpdate(String id_be, String id_at) {

        try {
            Connection c = ConnectDB.onData();
            String sql = "SELECT book_id FROM Books WHERE  book_id != ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, id_be);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString("book_id");
                if (id_at.equals(id)) {
                    return false;
                }
            }
            ConnectDB.offData(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
}
