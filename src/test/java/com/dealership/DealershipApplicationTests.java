package com.dealership;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

abstract class Tmp<T> {
	public void out(){
		System.out.println("Tmp.out :" + this.getClass().getTypeName());
	}
}

final class Tmp1 extends Tmp<String> {
}

@SpringBootTest
class DealershipApplicationTests {

	@Test
	void contextLoads() {
		Tmp1 t = new Tmp1();
		t.out();
	}

}
