/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import model.Users;
import repository.DAO_Users;
import view.View_Users;
import view.View_home;

/**
 *
 * @author acer
 */
public class controller_Users {

    private View_Users view;

    public controller_Users(View_Users view) {
        this.view = view;
    }

    public void login() {
        if (checkUs() == null) {
            return;
        }
        Users us = DAO_Users.callClass().selectObj(checkUs());
        if (us == null) {
            view.jLabel_check.setText("Tài khoản hoặc mật khẩu không đúng");
            return;
        }

        View_home view = new View_home(us);
        view.setVisible(true);
        view.setLocationRelativeTo(null);
    }

    public void reset() {
        view.jLabel_check.setText("");
        view.jTextField1.setText("");
        view.jPasswordField1.setText("");
    }

    public Users checkUs() {
        String userName = view.jTextField1.getText().trim();
        String Password = new String(view.jPasswordField1.getPassword());
        if (userName.equals("") || Password.equals("")) {
            view.jLabel_check.setText("Không để trống tài khoản mật khẩu");
            return null;
        }
        Users us = new Users(userName, "", Password, "");
        view.dispose();
        return us;
    }
}
