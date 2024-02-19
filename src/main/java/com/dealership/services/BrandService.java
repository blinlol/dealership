package com.dealership.services;

import com.dealership.models.*;
import com.dealership.DAO.BrandDAO;

// main use dao throw service
public class BrandService extends CommonService<Brand, BrandDAO>{
    public BrandService(){
        super(new BrandDAO());
    }

    public Brand findByName(String name){
        return dao.findByName(name);
    }
}
