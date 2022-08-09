/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.List;
import model.MuonSach;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utinity.hibernateUtil;

/**
 *
 * @author acer
 */
public class Muonrepo implements Repointerface<MuonSach> {

    @Override
    public List<MuonSach> getAll() {
        try ( Session ss = hibernateUtil.getFACTORY().openSession();) {
            return ss.createCriteria(MuonSach.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public MuonSach getOne(MuonSach t) {
        try ( Session ss = hibernateUtil.getFACTORY().openSession();) {
            String hql = "from MuonSach m where m.maMuon = :ma";
            Query query = ss.createQuery(hql);
            query.setParameter("ma", t.getMaMuon());
            return (MuonSach) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean add(MuonSach t) {
        Transaction transaction = null;
        try ( Session ss = hibernateUtil.getFACTORY().openSession();) {
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
    public boolean update(MuonSach t) {
        Transaction transaction = null;
        try ( Session ss = hibernateUtil.getFACTORY().openSession();) {
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
    public boolean delete(MuonSach t) {
        Transaction transaction = null;
        try ( Session ss = hibernateUtil.getFACTORY().openSession();) {
            transaction = ss.beginTransaction();
            String hql = "delete from MuonSach m where m.maMuon = :ma";
            Query query = ss.createQuery(hql);
            query.setParameter("ma", t.getMaMuon());
            query.executeUpdate();
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public static void main(String[] args) {
        Muonrepo m = new Muonrepo();
        MuonSach ms = new MuonSach();
        ms.setMaMuon("tt1");
        System.out.println(m.getOne(ms).toString());
    }
}
