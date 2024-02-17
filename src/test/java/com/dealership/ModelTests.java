package com.dealership;

import com.dealership.models.*;
import com.dealership.services.*;

import java.util.List;
import org.junit.jupiter.api.*;

public class ModelTests {
    private static Brand brand;
    @BeforeAll
    public static void setUp(){
        brand = new Brand("test brand");
        BrandService brandService = new BrandService();
        brandService.save(brand);
    }

    @AfterAll
    public static void tearDown(){
        BrandService brandService = new BrandService();
        brandService.delete(brand);
    }

    @Test
    public void testModel(){
        Model m = new Model("Test", brand);
        Assertions.assertEquals(m.getName(), "Test" );
    }

    @Test
    public void testFindById(){
        ModelService modelService = new ModelService();
        BrandService brandService = new BrandService();
        Model m = modelService.findById(1);
        Assertions.assertEquals(m.getName(), "Granta");
        Assertions.assertEquals(m.getId(), 1);
        Assertions.assertEquals(brandService.findById(1), m.getBrand());
    }

    @Test
    public void testFindByName(){
        ModelService modelService = new ModelService();
        Model m = modelService.findByName("Cayman");
        Assertions.assertEquals(m.getName(), "Cayman");
        Assertions.assertEquals(m.getId(), 8);
    }

    @Test
    public void testFindAll(){
        ModelService modelService = new ModelService();
        List<Model> models = modelService.findAll();
        Assertions.assertEquals(modelService.findAll().size(), 12);
        Assertions.assertEquals(models.get(0).getName(), "Granta");
        Assertions.assertEquals(models.get(1).getName(), "Priora");
        Assertions.assertEquals(models.get(11).getName(), "GAZ-3308");
    }

    @Test
    public void testModelService(){
        ModelService modelService = new ModelService();
        Model m;
        if (modelService.findByName("Test") != null){
            m = modelService.findByName("Test");
            modelService.delete(m);
        }

        Model model = new Model("Test", brand);
        
        modelService.save(model);
        Model model1 = modelService.findById(model.getId());
        Assertions.assertEquals(model, model1, "findById method failed");

        model = modelService.findByName("Test");
        model.setName("New name");
        modelService.update(model);
        model1 = modelService.findById(model.getId());
        Assertions.assertEquals("New name", model1.getName(), "setName method failed");
        Assertions.assertEquals("New name", model.getName(), "setName method failed");

        modelService.delete(model);
        model1 = modelService.findById(model.getId());
        Assertions.assertNull(model1, "delete method failed");
    }
}
