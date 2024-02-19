package com.dealership.utils;

import com.dealership.models.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateSessionFactoryUtil {
    private static SessionFactory sessionFactory;

    private HibernateSessionFactoryUtil(){}

    public static SessionFactory getSessionFactory(){
        if (sessionFactory == null) {
            final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().build();
            try {
                sessionFactory = new MetadataSources(registry)
                                    .addAnnotatedClasses(Brand.class, 
                                                                             Model.class,
                                                                             Configuration.class)
                                    .buildMetadata()
                                    .buildSessionFactory();
            }
            catch (Exception e) {
                StandardServiceRegistryBuilder.destroy(registry);
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
