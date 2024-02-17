package com.dealership.DAO;

import com.dealership.models.*;
import com.dealership.utils.HibernateSessionFactoryUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class BrandDAO {
    public Brand findById(int id){
        return HibernateSessionFactoryUtil.getSessionFactory().openSession()
                .get(Brand.class, id);
    }

    public List<Brand> findAll(){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        return session.createQuery("from Brand", Brand.class).getResultList();
    }

    public void save(Brand brand){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.persist(brand);
        tx.commit();
        session.close();
    }

    public void update(Brand brand){
        HibernateSessionFactoryUtil.getSessionFactory()
            .inTransaction(session -> {
                session.merge(brand);
            });
    }
}
