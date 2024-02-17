package com.dealership.DAO;

import com.dealership.models.*;
import com.dealership.utils.*;

import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class ModelDAO extends CommonDAO<Model>{
    
    public ModelDAO(){
        super(Model.class);
    }

    public Model findByName(String name){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        try {
            Model m = session
                        .createQuery("from Model where name = :name", Model.class)
                        .setParameter("name", name)
                        .getSingleResult();
            t.commit();
            return m;
        } catch (jakarta.persistence.NoResultException e){
            System.out.println("Model with name " + name + " not found");
            t.rollback();
            return null;
        }
    }

    public List<Model> findAll(){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        List<Model> m = session.createQuery("from Model", Model.class).getResultList();
        t.commit();
        return m;
    }

    public void save(Model model){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        session.persist(model);
        t.commit();
        session.close();
    }

}
