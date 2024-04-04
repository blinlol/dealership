package com.dealership.controllers;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.stereotype.Controller;

import com.dealership.services.ModelService;

@Controller
public class ModelsController {
    // @GetMapping(value = {"/models"})
    // public String index(Model model){
    //     ModelService ms = new ModelService();
    //     model.addAttribute("modelService", ms);
    //     model.addAttribute("models", ms.findAll());
    //     return "models";
    // }
}
