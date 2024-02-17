package com.dealership;

import com.dealership.models.*;
import com.dealership.services.*;

import org.junit.jupiter.api.*;
import java.time.Instant;


public class BrandTests {
    @Test
    public void testScenario(){
        BrandService brandService = new BrandService();
        Brand brand = new Brand("TEST");
        brandService.save(brand);
        Brand brand1 = brandService.findById(brand.getId());
        Assertions.assertEquals(brand, brand1);
    }
}
