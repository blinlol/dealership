package com.dealership.services;

import java.util.List;

import com.dealership.DAO.CommonDAO;

public abstract class CommonService<T, DAO extends CommonDAO<T>> {
    protected DAO dao;

    public CommonService(DAO dao){
        this.dao = dao;
    }

    public T findById(int id){
        return dao.findById(id);
    }

    public List<T> findAll(){
        return dao.findAll();
    }

    public void save(T brand){
        dao.save(brand);
    }

    // public void saveCollection(List<Brand> brands){
    //     brandDao.saveCollection(brands);
    // }

    public void update(T brand){
        dao.update(brand);
    }   

    public void delete(T brand){
        dao.delete(brand);
    }

    public void deleteById(int id){
        dao.deleteById(id);
    }
}
