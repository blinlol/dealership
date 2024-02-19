package com.dealership.services;

import com.dealership.DAO.*;
import com.dealership.models.*;

public class RequestService extends CommonService<Request, RequestDAO> {
    public RequestService(){
        super(new RequestDAO());
    }
}
