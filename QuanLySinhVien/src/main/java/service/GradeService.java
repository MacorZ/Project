/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.ArrayList;
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
public class GradeService implements ServiceInterface<Grade> {

    private static final GradeRepo repo = new GradeRepo();
    private static final StudentRepo repost = new StudentRepo();
    @Override
    public List<Grade> selectAll() {
       List<Grade> list = repo.selectAll();
       list.sort((o1, o2) -> {
           if(o1.getMedium_Score() > o2.getMedium_Score()) return -1;
           if(o1.getMedium_Score() < o2.getMedium_Score()) return 1;
           return 0;
       });
       List<Grade> list1 = new ArrayList<>();
       int i = 0; 
       while (i < list.size()) {            
            list1.add(list.get(i));
            i++;
            if(i == 3) break;
        }
       return list1;
    }

    @Override
    public Grade selectOne(Grade t) {
        return repo.selectOne(t);
    }

    @Override
    public String add(Grade t) {
        String check = check(t);
        if(!check.equals("")) return check;
        if(repost.selectOne(t.getStudents()) == null) return "Không tồn tại sinh viên";
        if(selectOne(t)!= null) return "Sinh viên đã tồn tại trên bảng điểm";
        return repo.add(t)?"":"Thêm điểm thất bại";
    }

    @Override
    public String update(Grade t) {
        return repo.update(t)?"":"Cập nhật thất bại";
    }

    @Override
    public String delete(Grade t) {
        return repo.delete(t)?"":"Xóa thất bại";
    }

    @Override
    public String check(Grade t) {
            String check = UtilClass.checkID(t.getStudents().getStudentID());
            if(!check.equals("")) return check;
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
    public String Sreach(String ma){
        if("".equals(ma)){
            return "Mã tìm trống";
        }
        Students s = new Students();
        s.setStudentID(ma);
        StudentService serviceSt = new StudentService();
        if(serviceSt.selectOne(s) == null){
            return "Không tồn tại sinh viên";
        }
        Grade g = new Grade();
        g.setStudents(s);
        Grade g1 = selectOne(g);
        if(g1 == null){
            return "Không tồn tại trên bảng điểm";
        }
        return "";
    }
}
