package com.dealership.DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

import com.dealership.models.Brand;
import com.dealership.utils.HibernateSessionFactoryUtil;

public abstract class CommonDAO<T> {
    private Class<T> entityClass;

    public CommonDAO(Class<T> entityClass){
        this.entityClass = entityClass;
    }

    public T findById(int id){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        T b = session.get(entityClass, id);
        t.commit();
        return b;
    }

    public List<T> findAll(){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        List<T> b = session.createQuery("from " + entityClass.getSimpleName(), entityClass).getResultList();
        t.commit();
        return b;
    }

    public void save(T obj){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        session.persist(obj);
        t.commit();
        session.close();
    }

    public void saveCollection(List<T> objs){
        HibernateSessionFactoryUtil.getSessionFactory()
            .inTransaction(session -> {
                for (T obj : objs) {
                    session.persist(obj);
                }
            });
    }

    public void update(T obj){
        HibernateSessionFactoryUtil.getSessionFactory()
            .inTransaction(session -> {
                session.merge(obj);
            });
    }

    public void delete(T obj){
        HibernateSessionFactoryUtil.getSessionFactory()
            .inTransaction(session -> {
                session.remove(obj);
            });
    }

    public void deleteById(int id){
        HibernateSessionFactoryUtil.getSessionFactory()
            .inTransaction(session -> {
                session.remove(findById(id));
            });
    }
}
