package com.dealership;

import org.junit.jupiter.api.*;
import java.util.List;

import com.dealership.models.*;
import com.dealership.services.*;

public class ConfigurationTests {
    private static ConfigurationService cs;
    private static BrandService bs;
    private static ModelService ms;
    private static Brand b;
    private static Model m;

    @BeforeAll
    public static void setUp(){
        bs = new BrandService();
        ms = new ModelService();
        cs = new ConfigurationService();

        b = new Brand("Test brand");
        bs.save(b);
        m = new Model("Test model", b);
        ms.save(m);
    }

    @AfterAll
    public static void tearDown(){
        ms.delete(m);
        bs.delete(b);
    }

    @Test
    public void testFind(){
        Configuration c = cs.findById(1);
        Assertions.assertEquals(c.getId(), 1);
        Assertions.assertEquals(c.getSpecification().getHp(), 99);
        Assertions.assertEquals(ms.findById(3), c.getModel());
        Assertions.assertEquals(1600000, c.getPrice());
    }

    @Test
    public void testConfigurationService(){
        if (cs.findByName("test") != null){
            cs.delete(cs.findByName("test"));
        }

        Configuration c = new Configuration(m, "test", false, 1, 10, 
                new Specification(99, 1600000, "black"));
        cs.save(c);
        Configuration c1 = cs.findById(c.getId());
        Assertions.assertEquals(c1, c);

        cs.delete(c);
        c1 = cs.findById(c.getId());
        Assertions.assertNull(c1);
    }

    @Test
    public void testFilter(){
        List<Configuration> lc = cs.findWithFilter("hp", 99, 100);
        Configuration c = cs.findById(1);

        Assertions.assertEquals(2, lc.size());
        Assertions.assertTrue(lc.contains(c));

        lc = cs.findWithFilter("color", "black");
        Assertions.assertEquals(1, lc.size());
        c = cs.findById(4);
        Assertions.assertEquals(c, lc.get(0));

        lc = cs.findWithFilter("fool", 1000, 10000);
        Assertions.assertNull(lc);

        lc = cs.findWithFilter("fool", "qwe");
        Assertions.assertNull(lc);
    }
}
