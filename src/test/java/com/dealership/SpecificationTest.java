package com.dealership;

import org.junit.Test;

import com.dealership.models.*;
import com.dealership.services.*;
import org.junit.jupiter.api.*;

public class SpecificationTest {
    @Test
    public void test(){
        Specification s = new Specification();
        s.setHp(1);
        s.setMileage(100);
        s.setColor("black");

        Assertions.assertEquals(s.getHp(), 1);
        Assertions.assertEquals(s.getMileage(), 100);
        Assertions.assertEquals(s.getColor(), "black");
    }
}
