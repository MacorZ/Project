/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import model.Authors;
import model.Books;
import model.Publichers;
import repository.DAO_Authors;
import repository.DAO_Books;
import repository.DAO_Publisher;
import view.View_detail;
import view.View_home;

/**
 *
 * @author acer
 */
public class Controller_Detail {

    private view.View_detail view;

    public Controller_Detail(View_detail view) {
        this.view = view;
    }

    public void showForm() {
        Books bk = view.getBk();
        view.jTextField_id.setText(bk.getBook_ID());
        view.jTextField_name.setText(bk.getTitle());
        view.jComboBox_pub.setSelectedItem(bk.getPublishers());
        view.jComboBox_au.setSelectedItem(bk.getAuthors());
        view.jTextArea_note.setText(bk.getNotes());
    }

    public void AddCombobox() {
        List<Authors> list_au = DAO_Authors.callClass().selectAll();
        List<Publichers> list_pub = DAO_Publisher.callClass().selectAll();
        DefaultComboBoxModel model_au = (DefaultComboBoxModel) view.jComboBox_au.getModel();
        DefaultComboBoxModel model_pub = (DefaultComboBoxModel) view.jComboBox_pub.getModel();
        model_au.removeAllElements();
        model_pub.removeAllElements();
        list_au.forEach((t) -> {
            model_au.addElement(t.getAu_Name());
        });
        list_pub.forEach((t) -> {
            model_pub.addElement(t.getPub_Name());
        });

    }
    public void close(){
        view.dispose();
        View_home view_h = new View_home(view.us);
        view_h.setVisible(true);
        view_h.setLocationRelativeTo(null);
        view_h.jComboBox1.setSelectedItem("All");
        view_h.controller.Sreach();
        
    }
    public void reset() {
        view.jTextField_id.setText("");
        view.jTextField_name.setText("");
        view.jTextArea_note.setText("");
        view.jComboBox_au.setSelectedIndex(-1);
        view.jComboBox_pub.setSelectedIndex(-1);
    }

    public Books check() {
        String id = view.jTextField_id.getText().trim();
        String name = view.jTextField_name.getText().trim();
        String note = view.jTextArea_note.getText().trim();

        String usn = view.getBk().getUserName();
        if (id == null || id.equals("")) {
            JOptionPane.showMessageDialog(view, "Không để trống ID");
            return null;
        }
        if (name == null || name.equals("")) {
            JOptionPane.showMessageDialog(view, "Không để trống Title");
            return null;
        }
        if (view.jComboBox_pub.getSelectedIndex() < 0) {
            JOptionPane.showMessageDialog(view, "Chưa chọn nhà xuất bản");
            return null;
        }
        if (view.jComboBox_au.getSelectedIndex() < 0) {
            JOptionPane.showMessageDialog(view, "Chưa chọn tác giả");
            return null;
        }
        String Author = view.jComboBox_au.getSelectedItem().toString();
        String Publisher = view.jComboBox_pub.getSelectedItem().toString();
        if (note == null || note.equals("")) {
            JOptionPane.showMessageDialog(view, "Không để trống Note");
            return null;
        }
        String regex = "[a-zA-Z]{2}[0-9]{4}";
        if (!id.matches(regex)) {
            JOptionPane.showMessageDialog(view, "ID không hợp lệ");
            return null;
        }
        Books bk = new Books(id, name, Publisher, Author, note, usn);
        return bk;
    }

    public void Update() {
        Books bk = check();
        if (bk == null) {
            return;
        }
        if (DAO_Books.callClass().checkUpdate(view.getBk().getBook_ID(), bk.getBook_ID()) == false) {
            JOptionPane.showMessageDialog(view, "ID trùng với ID khác");
            return;
        }
        DAO_Books.callClass().update(bk, view.getBk().getBook_ID());
        JOptionPane.showMessageDialog(view, "Cập nhật thành công");
        close();
    }

    public void Delete() {
        DAO_Books.callClass().delete(view.getBk().getBook_ID());
        JOptionPane.showMessageDialog(view, "Xóa thành công");
        close();
    }
}
