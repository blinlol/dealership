package com.dealership.services;

import com.dealership.models.*;
import com.dealership.services.CommonService;
import com.dealership.DAO.BrandDAO;

import java.util.List;

// main use dao throw service
public class BrandService extends CommonService<Brand, BrandDAO>{
    public BrandService(){
        super(new BrandDAO());
    }

    public Brand findByName(String name){
        return dao.findByName(name);
    }
}
