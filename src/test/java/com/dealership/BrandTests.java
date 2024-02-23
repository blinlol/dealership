package com.dealership;

import com.dealership.models.*;
import com.dealership.services.*;

import org.junit.jupiter.api.*;
import java.util.List;


public class BrandTests {
    @Test
    public void testBrand(){
        Brand b = new Brand("Test");
        Assertions.assertEquals(b.getName(), "Test" );
    }

    @Test
    public void testFindByName(){
        BrandService brandService = new BrandService();
        Brand b = brandService.findByName("Porsche");
        Assertions.assertEquals(b.getName(), "Porsche");
        Assertions.assertEquals(b.getId(), 3);
    }

    @Test
    public void testFindById(){
        BrandService brandService = new BrandService();
        Brand b = brandService.findById(3);
        Assertions.assertEquals(b.getName(), "Porsche");
        Assertions.assertEquals(b.getId(), 3);
    }

    @Test
    public void testFindAll(){
        BrandService brandService = new BrandService();
        List<Brand> brands = brandService.findAll();
        Assertions.assertEquals(brandService.findAll().size(), 4);
        Assertions.assertEquals(brands.get(0).getName(), "Lada");
        Assertions.assertEquals(brands.get(1).getName(), "Toyota");
        Assertions.assertEquals(brands.get(2).getName(), "Porsche");
        Assertions.assertEquals(brands.get(3).getName(), "ГАЗ");
    }

    @Test
    public void testBrandService(){
        BrandService brandService = new BrandService();
        Brand b;
        if (brandService.findByName("Test") != null){
            b = brandService.findByName("Test");
            brandService.delete(b);
        }

        Brand brand = new Brand("Test");
        
        brandService.save(brand);
        Brand brand1 = brandService.findById(brand.getId());
        Assertions.assertEquals(brand, brand1, "findById method failed");

        brand = brandService.findByName("Test");
        brand.setName("New name");
        brandService.update(brand);
        brand1 = brandService.findById(brand.getId());
        Assertions.assertEquals("New name", brand1.getName(), "setName method failed");
        Assertions.assertEquals("New name", brand.getName(), "setName method failed");

        brandService.delete(brand);
        brand1 = brandService.findById(brand.getId());
        Assertions.assertNull(brand1, "delete method failed");
    }

    @Test
    public void testBrandDeleteById(){
        BrandService brandService = new BrandService();
        Brand b;
        if (brandService.findByName("Test") != null){
            b = brandService.findByName("Test");
            brandService.delete(b);
        }

        Brand brand = new Brand("Test");
        brandService.save(brand);
        brandService.deleteById(brand.getId());
        brand = brandService.findById(brand.getId());
        Assertions.assertNull(brand, "deleteById method failed");
    }
}
