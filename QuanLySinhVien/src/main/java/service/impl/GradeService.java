/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.Grade;
import model.Students;
import reposirory.impl.GradeRepo;
import reposirory.impl.StudentRepo;
import utility.UtilClass;
import service.ICommon;

/**
 *
 * @author acer
 */
public class GradeService implements ICommon<Grade> {

    private static final GradeRepo repo = new GradeRepo();
    private static final StudentRepo repost = new StudentRepo();

    @Override
    public List<Grade> selectAll() {
        return repo.selectAll();
    }

    @Override
    public Grade selectOne(Grade t) {
        return repo.selectOne(t);
    }

    @Override
    public String add(Grade t) {
        String check = check(t);
        if (!check.equals("")) {
            return check;
        }
        if (repost.selectOne(t.getStudents()) == null) {
            return "Không tồn tại sinh viên";
        }
        if (selectOne(t) != null) {
            return "Sinh viên đã tồn tại trên bảng điểm";
        }
        return repo.add(t) ? "" : "Thêm điểm thất bại";
    }

    @Override
    public String update(Grade t) {
        return repo.update(t) ? "" : "Cập nhật thất bại";
    }

    @Override
    public String delete(Grade t) {
        return repo.delete(t) ? "" : "Xóa thất bại";
    }

    @Override
    public String check(Grade t) {
        String check = UtilClass.checkID(t.getStudents().getStudentID());
        if (!check.equals("")) {
            return check;
        }
        return "";
    }

    public String checkSo(String ta, String th, String gdtc) {
        try {
            int dta = Integer.parseInt(ta);
            int dth = Integer.parseInt(th);
            int dgdtc = Integer.parseInt(gdtc);
            if (!checkDiem(dta) || !checkDiem(dth) || !checkDiem(dgdtc)) {
                return "Điểm chỉ trong khoảng 0-> 10";
            }
        } catch (Exception e) {
            return "Điểm không hợp lệ";
        }
        return "";
    }

    public boolean checkDiem(int d) {
        if (d >= 0 && d <= 10) {
            return true;
        }
        return false;
    }

    public String Sreach(String ma) {
        if ("".equals(ma)) {
            return "Mã tìm trống";
        }
        Students s = new Students();
        s.setStudentID(ma);
        StudentService serviceSt = new StudentService();
        if (serviceSt.selectOne(s) == null) {
            return "Không tồn tại sinh viên";
        }
        Grade g = new Grade();
        g.setStudents(s);
        Grade g1 = selectOne(g);
        if (g1 == null) {
            return "Không tồn tại trên bảng điểm";
        }
        return "";
    }
}
