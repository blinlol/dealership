package com.dealership.services;

import java.util.List;

import com.dealership.DAO.*;
import com.dealership.models.*;

public class ConfigurationService extends CommonService<Configuration, ConfigurationDAO> {
    public ConfigurationService(){
        super(new ConfigurationDAO());
    }

    public Configuration findByName(String name){        
        return dao.findByName(name);
    }

    public List<Configuration> findWithFilter(String fieldName, int lo, int hi){
        if (Specification.getFields().contains(fieldName)){
            return dao.findWithFilter(fieldName, lo, hi);
        }
        return null;
    }

    public List<Configuration> findWithFilter(String fieldName, String value){
        if (Specification.getFields().contains(fieldName)){
            return dao.findWithFilter(fieldName, value);
        }
        return null;
    }
}
