/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.List;
import model.TaiKhoan;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.hibernateUtil;

/**
 *
 * @author acer
 */
public class TaiKhoanRepository implements RepositoryIntefface<TaiKhoan> {

    @Override
    public List<TaiKhoan> selectAll() {
        try ( Session session = hibernateUtil.getFACTORY().openSession();) {
            return session.createCriteria(TaiKhoan.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public TaiKhoan selectOne(TaiKhoan tk) {
        try ( Session session = hibernateUtil.getFACTORY().openSession();) {
            return session.get(TaiKhoan.class, tk.getTenTaiKhoan());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean add(TaiKhoan t) {
        Transaction transaction = null;
        try ( Session session = hibernateUtil.getFACTORY().openSession();) {
            transaction = session.beginTransaction();
            session.save(t);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean update(TaiKhoan t) {
        Transaction transaction = null;
        try ( Session session = hibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.update(t);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(TaiKhoan t) {
        Transaction transaction = null;
        try ( Session session = hibernateUtil.getFACTORY().openSession();) {
            transaction = session.beginTransaction();
            session.delete(t);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        TaiKhoanRepository khoanRepository = new TaiKhoanRepository();
        khoanRepository.delete(new TaiKhoan("toan1240","abcxđáyz","Trung toàndsdasd"));
        System.out.println(khoanRepository.selectAll());    
    }
 
}
