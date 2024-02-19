package com.dealership.DAO;

import com.dealership.models.*;
import com.dealership.utils.*;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class ConfigurationDAO extends CommonDAO<Configuration>{
    
    public ConfigurationDAO(){
        super(Configuration.class);
    }

    public Configuration findByName(String name){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        try {
            Configuration c = session
                            .createQuery("from Configuration where name = :name", Configuration.class)
                            .setParameter("name", name)
                            .getSingleResult();
            t.commit();
            return c;
        } catch (jakarta.persistence.NoResultException e){
            System.out.println("Configuration with name " + name + " not found");
            t.rollback();
            return null;
        }
    }
}
