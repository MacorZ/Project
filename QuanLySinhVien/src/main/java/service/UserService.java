/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import model.User;
import reposirory.UserRepo;

/**
 *
 * @author acer
 */
public class UserService implements ServiceInterface<User>{
private static final UserRepo repo = new UserRepo();
    @Override
    public List<User> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public User selectOne(User t) {
        return repo.selectOne(t);
    }

    @Override
    public String add(User t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String update(User t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String delete(User t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String check(User t) {
        if("".equals(t.getUserName())|| "".equals(t.getPassword())) return "Không để trống tài khoản mật khẩu";
        return "";
    }
    public String dangNhap(User t){
        String check = check(t);
        if(!check.equals("")) return check;
        User rs = selectOne(t);
        if( rs == null) return "Tài khoản không tồn tại";
        if(!rs.getPassword().equals(t.getPassword())) return "Mật khẩu không đúng";
        return rs.getRole();   
    }
    
}
