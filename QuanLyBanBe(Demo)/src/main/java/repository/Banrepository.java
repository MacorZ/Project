/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.List;
import model.Ban;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utinity.hibernateUtil;

/**
 *
 * @author acer
 */
public class Banrepository implements Repointerface<Ban> {

    @Override
    public List<Ban> getAll() {
        try ( Session ss = hibernateUtil.getFACTORY().openSession();) {
            return ss.createCriteria(Ban.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Ban getOne(Ban t) {
       
        try ( Session ss = hibernateUtil.getFACTORY().openSession();) {
             String hql = "From Ban b where b.maBan = :ma";
            Query query = ss.createQuery(hql,Ban.class);
            query.setParameter("ma",t.getMaBan());
            return (Ban) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean add(Ban t) {
        Transaction transaction = null;
        try(Session ss = hibernateUtil.getFACTORY().openSession();) {
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
    public boolean update(Ban t) {
 Transaction transaction = null;
        try(Session ss = hibernateUtil.getFACTORY().openSession();) {
            transaction = ss.beginTransaction();
            ss.update(t);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }    }

    @Override
    public boolean delete(Ban t) {
 Transaction transaction = null;
        try(Session ss = hibernateUtil.getFACTORY().openSession();) {
            transaction = ss.beginTransaction();
            String hql = "delete from Ban b where b.maBan= :ma ";
            Query query = ss.createQuery(hql);
            query.setParameter("ma",t.getMaBan());
            query.executeUpdate();
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }    }

}
