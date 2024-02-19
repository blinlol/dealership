package com.dealership;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.*;

@SpringBootTest
class DealershipApplicationTests {

	@Test
	void contextLoads() {
		System.out.println(Instant.now());
	}

}
