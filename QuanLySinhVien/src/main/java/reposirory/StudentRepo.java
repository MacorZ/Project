/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reposirory;

import java.util.List;
import model.Students;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utility.HibenateUtil;

/**
 *
 * @author acer
 */
public class StudentRepo implements RepoInterface<Students> {

    @Override
    public List<Students> selectAll() {
        try ( Session ss = HibenateUtil.getFactory().openSession();) {
            return ss.createCriteria(Students.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Students selectOne(Students t) {
        try ( Session ss = HibenateUtil.getFactory().openSession();) {
            return ss.get(Students.class, t.getStudentID());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean add(Students t) {
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
    public boolean update(Students t) {
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
    public boolean delete(Students t) {
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

}
