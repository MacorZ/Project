/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.List;
import javax.persistence.Query;
import model.DonHang;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.hibernateUtil;

/**
 *
 * @author acer
 */
public class DonHangRepository implements RepositoryIntefface<DonHang> {

    @Override
    public List<DonHang> selectAll() {
        try ( Session session = hibernateUtil.getFACTORY().openSession();) {
            return session.createCriteria(DonHang.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public DonHang selectOne(DonHang dh) {
        try ( Session session = hibernateUtil.getFACTORY().openSession();) {
            return session.get(DonHang.class, dh.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean add(DonHang t) {
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
    public boolean update(DonHang t) {
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
    public boolean delete(DonHang t) {
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

    public List<DonHang> selectAllByMon(String s) {
        try ( Session session = hibernateUtil.getFACTORY().openSession();) {
            String hql = "From DonHang as d Where d.tenMonAn = :mon";
            Query query = session.createQuery(hql, DonHang.class);
            query.setParameter("mon", s);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public int selectSumBy(String mon) {
        try ( Session session = hibernateUtil.getFACTORY().openSession();) {
            String hql = "SELECT sum( p.thanhTien) FROM DonHang p WHERE p.tenMonAn = :mon";
            Query query = session.createQuery(hql);
            query.setParameter("mon", mon);
            int tong = Integer.parseInt(query.getSingleResult().toString());
            return tong;
        } catch (Exception e) {
            e.printStackTrace();
             return 0;
        }
        
    }
    public int selectSumAll() {
        try ( Session session = hibernateUtil.getFACTORY().openSession();) {
            String hql = "SELECT sum( p.thanhTien) FROM DonHang p";
            Query query = session.createQuery(hql);
            int tong = Integer.parseInt(query.getSingleResult().toString());
            return tong;
        } catch (Exception e) {
            e.printStackTrace();
             return 0;
        }
        
    }
    public static void main(String[] args) {
        DonHangRepository donHangRepository = new DonHangRepository();
        System.out.println(donHangRepository.selectAll());
        System.out.println(donHangRepository.selectSumBy("a"));
    }
}
