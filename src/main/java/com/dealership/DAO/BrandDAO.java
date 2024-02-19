package com.dealership.DAO;

import com.dealership.models.*;
import com.dealership.utils.*;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class BrandDAO extends CommonDAO<Brand>{
    
    public BrandDAO(){
        super(Brand.class);
    }

    // public Brand findById(int id){
    //     Session session = HibernateSessionFactoryUtil.getSessionFactory().getCurrentSession();
    //     Transaction t = session.beginTransaction();
    //     Brand b = session.get(Brand.class, id);
    //     t.commit();
    //     return b;
    // }

    public Brand findByName(String name){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        try {
            Brand b = session
                        .createQuery("from Brand where name = :name", Brand.class)
                        .setParameter("name", name)
                        .getSingleResult();
            t.commit();
            return b;
        } catch (jakarta.persistence.NoResultException e){
            System.out.println("Brand with name " + name + " not found");
            t.rollback();
            return null;
        }
    }

    // public List<Brand> findAll(){
    //     Session session = HibernateSessionFactoryUtil.getSessionFactory().getCurrentSession();
    //     Transaction t = session.beginTransaction();
    //     List<Brand> b = session.createQuery("from Brand", Brand.class).getResultList();
    //     t.commit();
    //     return b;
    // }

    // public void save(Brand brand){
    //     Session session = HibernateSessionFactoryUtil.getSessionFactory().getCurrentSession();
    //     Transaction tx = session.beginTransaction();
    //     session.persist(brand);
    //     tx.commit();
    //     session.close();
    // }

    // public void saveCollection(List<Brand> brands){
    //     HibernateSessionFactoryUtil.getSessionFactory()
    //         .inTransaction(session -> {
    //             for (Brand brand : brands) {
    //                 session.persist(brand);
    //             }
    //         });
    // }

    // public void update(Brand brand){
    //     HibernateSessionFactoryUtil.getSessionFactory()
    //         .inTransaction(session -> {
    //             session.merge(brand);
    //         });
    // }

    // public void delete(Brand brand){
    //     HibernateSessionFactoryUtil.getSessionFactory()
    //         .inTransaction(session -> {
    //             session.remove(brand);
    //         });
    // }

    // public void deleteById(int id){
    //     HibernateSessionFactoryUtil.getSessionFactory()
    //         .inTransaction(session -> {
    //             session.remove(findById(id));
    //         });
    // }
}
