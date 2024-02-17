package com.dealership.services;

import com.dealership.models.*;
import com.dealership.DAO.BrandDAO;


// main use dao throw service
public class BrandService {
    private BrandDAO brandDao = new BrandDAO();

    public BrandService(){}

    public Brand findById(int id){
        return brandDao.findById(id);
    }
}
