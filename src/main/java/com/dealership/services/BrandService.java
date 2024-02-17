package com.dealership.services;

import com.dealership.models.*;
import com.dealership.DAO.BrandDAO;

import java.util.List;

// main use dao throw service
public class BrandService {
    private BrandDAO brandDao = new BrandDAO();

    public BrandService(){}

    public Brand findById(int id){
        return brandDao.findById(id);
    }

    public Brand findByName(String name){
        return brandDao.findByName(name);
    }

    public List<Brand> findAll(){
        return brandDao.findAll();
    }

    public void save(Brand brand){
        brandDao.save(brand);
    }

    // public void saveCollection(List<Brand> brands){
    //     brandDao.saveCollection(brands);
    // }

    public void update(Brand brand){
        brandDao.update(brand);
    }   

    public void delete(Brand brand){
        brandDao.delete(brand);
    }

    public void deleteById(int id){
        brandDao.deleteById(id);
    }
}
