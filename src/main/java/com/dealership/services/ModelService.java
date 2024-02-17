package com.dealership.services;

import com.dealership.services.CommonService;
import com.dealership.models.*;
import com.dealership.DAO.*;

public class ModelService extends CommonService<Model, ModelDAO>{
    
    public ModelService(){
        super(new ModelDAO());
    }

    public Model findByName(String name){
        return dao.findByName(name);
    }
}
