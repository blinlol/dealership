package com.dealership.DAO;

import com.dealership.models.*;
import com.dealership.utils.*;

import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

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

    public List<Configuration> findWithFilter(String fieldName, int lo, int hi){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().getCurrentSession();
        String query = "from Configuration as c where c.specification." + fieldName + " between :lo and :hi";
        Transaction t = session.beginTransaction();
        List<Configuration> listConfig = session
                                .createQuery(query, Configuration.class)
                                .setParameter("lo", lo)
                                .setParameter("hi", hi)
                                .getResultList();
        t.commit();
        return listConfig;
    }

    public List<Configuration> findWithFilter(String fieldName, String value){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().getCurrentSession();
        String query = "from Configuration as c where c.specification." + fieldName + " = :value";
        Transaction t = session.beginTransaction();
        List<Configuration> listConfig = session
                                .createQuery(query, Configuration.class)
                                .setParameter("value", value)
                                .getResultList();
        t.commit();
        return listConfig;
    }
}
