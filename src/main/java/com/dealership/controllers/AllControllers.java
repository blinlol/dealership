package com.dealership.controllers;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dealership.models.Brand;
import com.dealership.models.Request;
import com.dealership.models.RequestStatus;
import com.dealership.models.Configuration;
import com.dealership.services.*;

import org.hibernate.engine.jdbc.env.internal.LobCreationLogging_.logger;
import org.springframework.stereotype.Controller;

@Controller
public class AllControllers {
    @GetMapping(value = {"/", "/index"})
    public String index(Model model){
        return "index";
    }

    @GetMapping(value = {"/models"})
    public String models(Model model){
        ModelService ms = new ModelService();
        model.addAttribute("modelService", ms);
        model.addAttribute("models", ms.findAll());
        return "models";
    }

    @GetMapping(value = {"/configurations"})
    public String configurations(Model model){
        ConfigurationService cs = new ConfigurationService();
        model.addAttribute("configurationService", cs);
        model.addAttribute("configurations", cs.findAll());
        return "configurations";
    }

    @GetMapping(value = {"/model"})
    public String model(@RequestParam("modelId") int id, Model model){
        ModelService ms = new ModelService();
        com.dealership.models.Model m = ms.findById(id);
        model.addAttribute("model", m);
        model.addAttribute("configurations", m.getConfigurations());
        return "model";
    }

    @GetMapping(value = {"/brand"})
    public String brand(@RequestParam("brandId") int id, Model model){
        BrandService bs = new BrandService();
        Brand b = bs.findById(id);
        model.addAttribute("brand", b);
        return "brand";
    }

    @GetMapping(value = {"/createOrder"})
    public String createOrder(@RequestParam("configurationId") int id, Model model){
        Configuration c = new ConfigurationService().findById(id);
        model.addAttribute("configuration", c);
        return "createOrder";
    }

    @PostMapping(value = {"/saveOrder"})
    public String saveOrder(
        @RequestParam(name = "name") String name,
        @RequestParam(name = "email") String email,
        @RequestParam(name = "phone") String phone,
        @RequestParam(name = "configurationId") String configurationId,
        Model model
    ){
        Configuration c = new ConfigurationService().findById(Integer.parseInt(configurationId));
        Request r = new Request(
            c,
            1,
            name,
            phone,
            email,
            RequestStatus.created
        );

        new RequestService().save(r);
        return "successOrder";
    }
}