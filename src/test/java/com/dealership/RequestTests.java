package com.dealership;

import com.dealership.models.*;
import com.dealership.services.*;

import org.junit.jupiter.api.*;
import java.time.*;

public class RequestTests {
    private static BrandService bs;
    private static ModelService ms;
    private static RequestService rs;
    private static ConfigurationService cs;
    private static Brand b;
    private static Model m;
    private static Configuration c;

    @BeforeAll
    public static void setUp(){
        bs = new BrandService();
        ms = new ModelService();
        rs = new RequestService();
        cs = new ConfigurationService();
    }

    @Test
    public void testFindById(){
        Request r = rs.findById(7);
        Assertions.assertEquals(7, r.getId());
        Assertions.assertEquals(cs.findById(2), r.getConfiguration());
        Assertions.assertEquals(1, r.getCount());
        Assertions.assertEquals("Petr", r.getClientName());
        Assertions.assertEquals("3@3.3", r.getClientEmail());
        Assertions.assertEquals("3333333333", r.getClientPhone());
        Assertions.assertEquals(RequestStatus.completed, r.getStatus());
        Assertions.assertEquals(LocalDateTime.of(2024, 02, 17, 9, 24, 13, 813104000), r.getCreationDate());
    }

    @Test
    public void testRequestService(){
        LocalDateTime date = LocalDateTime.of(2024, 02, 17, 9, 24, 13, 813104000);
        Request r = new Request(
            cs.findById(3),
            2, 
            "test name", 
            "test phone", 
            "test email", 
            RequestStatus.cancelled, 
            date);
        rs.save(r);

        int id = r.getId();
        Request r1 = rs.findById(id);
        Assertions.assertEquals(r1, r);

        r1.setCount(100);
        rs.update(r1);
        r = rs.findById(r.getId());
        Assertions.assertEquals(100, r.getCount());
        Assertions.assertEquals(r1, r);

        rs.delete(r);
    }
}
