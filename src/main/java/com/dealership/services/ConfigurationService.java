package com.dealership.services;

import com.dealership.DAO.*;
import com.dealership.models.*;

public class ConfigurationService extends CommonService<Configuration, ConfigurationDAO> {
    public ConfigurationService(){
        super(new ConfigurationDAO());
    }

    public Configuration findByName(String name){
        return dao.findByName(name);
    }
}
