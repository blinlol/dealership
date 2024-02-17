package com.dealership.DAO;

import com.dealership.models.*;
import com.dealership.utils.*;

import org.hibernate.Session;
import org.hibernate.Transaction;

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
}
