/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reposirory.impl;

import java.util.List;
import model.Grade;
import model.Students;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utility.HibenateUtil;
import reposirory.ICommon;

/**
 *
 * @author acer
 */
public class GradeRepo implements ICommon<Grade> {

    @Override
    public List<Grade> selectAll() {
        try ( Session ss = HibenateUtil.getFactory().openSession();) {
            String hql = "from Grade d order by (d.englishScore + d.itScore + d.peScore) desc ";
            Query query = ss.createQuery(hql,Grade.class);
            return query.setMaxResults(3).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Grade selectOne(Grade t) {
        try ( Session ss = HibenateUtil.getFactory().openSession();) {
            String hql = "from Grade d where d.students.studentID = :id";
            Query query = ss.createQuery(hql);
            query.setParameter("id", t.getStudents().getStudentID());
            return (Grade) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public boolean add(Grade t) {
        Transaction transaction = null;
        try ( Session ss = HibenateUtil.getFactory().openSession();) {
            transaction = ss.beginTransaction();
            ss.save(t);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Grade t) {
        Transaction transaction = null;
        try ( Session ss = HibenateUtil.getFactory().openSession();) {
            transaction = ss.beginTransaction();
            ss.update(t);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(Grade t) {
        Transaction transaction = null;
        try ( Session ss = HibenateUtil.getFactory().openSession();) {
            transaction = ss.beginTransaction();
            ss.delete(t);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
//        GradeRepo gr = new GradeRepo();
//        Students s = new Students();
//        s.setStudentID("sv01");
//        Grade g = new Grade();
//        g.setStudents(s);
//        System.out.println(gr.selectOne(g));
    }
}
