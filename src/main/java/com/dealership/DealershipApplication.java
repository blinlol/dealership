package com.dealership;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dealership.models.Brand;
import com.dealership.utils.HibernateSessionFactoryUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import static java.lang.System.out;

import java.time.Instant;

@SpringBootApplication
public class DealershipApplication {
    public static void main(String[] args) {
        SpringApplication.run(DealershipApplication.class, args);
    
        System.out.println("SessionFactory: " + HibernateSessionFactoryUtil.getSessionFactory());
       
    }

}
