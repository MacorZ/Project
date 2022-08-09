/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Books;
import repository.DAO_Books;
import view.View_Add;
import view.View_detail;
import view.View_home;

/**
 *
 * @author acer
 */
public class Controller_Home {
  private View_home view; 

    public Controller_Home(View_home view) {
        this.view = view;
    }
 public void Sreach(){
    view.list.clear();
    String By = view.jComboBox1.getSelectedItem().toString();
    String keyWord = view.jTextField_sreach.getText();
    
    if(By.equals("Book ID")){
        if(keyWord.equals("")|| keyWord == null){
            JOptionPane.showMessageDialog(view,"Vui lòng không để trống ");
            return;
        }
        view.list = DAO_Books.callClass().selectByBookID(keyWord,view.us.getUserName());
    }
    if(By.equals("Book Title")){
        if(keyWord.equals("")|| keyWord == null){
            JOptionPane.showMessageDialog(view,"Vui lòng không để trống ");
            return;
        }
        view.list = DAO_Books.callClass().selectByBoolTitle(keyWord,view.us.getUserName());
    }
    if(By.equals("Author Name")){
        if(keyWord.equals("")|| keyWord == null){
            JOptionPane.showMessageDialog(view,"Vui lòng không để trống ");
            return;
        }
        view.list = DAO_Books.callClass().selectByAuthorName(keyWord,view.us.getUserName());
    }
    if(By.equals("All")){
        view.list = DAO_Books.callClass().selectByAll(view.us.getUserName());
    }
     selectAll(view.list);
 }
 public void selectAll(List<Books> list){
     view.model.setRowCount(0);
     list.forEach((t) -> {
         view.model.addRow(new Object[]{
             t.getBook_ID(),t.getTitle(),t.getPublishers(),t.getAuthors(),t.getNotes()
         });
     });
 }
 public void Add(){
     View_Add view_add = new View_Add(view.us);
     view_add.setVisible(true);
     view_add.setLocationRelativeTo(null);
     
 }
 public void showForm_Detail(){
   int index  = view.jTable1.getSelectedRow();
  String id = view.model.getValueAt(index,0).toString();
  String name = view.model.getValueAt(index,1).toString();
  String pub = view.model.getValueAt(index,2).toString();
  String au = view.model.getValueAt(index,3).toString();
  String note = view.model.getValueAt(index,4).toString();
  String usn = view.us.getUserName();
     Books bk = new Books(id,name, pub, au, note,usn);
     View_detail view = new View_detail(bk,this.view.us);
     view.setVisible(true);
     view.setLocationRelativeTo(null);
     
 }
}
