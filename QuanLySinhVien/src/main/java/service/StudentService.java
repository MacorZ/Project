/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import model.Grade;
import model.Students;
import reposirory.GradeRepo;
import reposirory.StudentRepo;
import utility.UtilClass;

/**
 *
 * @author acer
 */
public class StudentService implements ServiceInterface<Students> {

    private static final StudentRepo repo = new StudentRepo();
    private static final GradeRepo repoGr = new GradeRepo();
    @Override
    public List<Students> selectAll() {
        return repo.selectAll();
    }

    @Override
    public Students selectOne(Students t) {
        return repo.selectOne(t);
    }

    @Override
    public String add(Students t) {
        String check = check(t);
        if (!check.equals("")) {
            return check;
        }
        if (selectOne(t) != null) {
            return "Sinh viên đã tồn tại";
        }
        return repo.add(t) ? "" : "Thêm thất bại";
    }

    @Override
    public String update(Students t) {
        String check = check(t);
        if (!check.equals("")) {
            return check;
        }
        return repo.update(t) ? "" : "Cập nhật thất bại";
    }

    @Override
    public String delete(Students t) {
        Grade grade = repoGr.selectOne(new Grade(t));
        if(grade!= null){
            repoGr.delete(grade);
        }
        return repo.delete(t) ? "" : "Xóa thất bại";
    }

    @Override
    public String check(Students t) {
        String check = UtilClass.checkID(t.getStudentID());
        if (!check.equals("")) {
            return check;
        }
        check = UtilClass.checkName(t.getStudentName());
        if (!check.equals("")) {
            return check;
        }
        check = UtilClass.checkEmail(t.getEmail());
        if (!check.equals("")) {
            return check;
        }
        check = UtilClass.checkPhone(t.getPhoneNumber());
        if (!check.equals("")) {
            return check;
        }
        if ("".equals(t.getAddress())) {
            return "Địa chỉ trống";
        }
        if ("".equals(t.getIMG())) {
            return "Ảnh trống";
        }
        return "";
    }

}
