package org.tektutor;

import static org.junit.Assert.*;
import org.junit.Test;

public class AppTest {

	@Test
	public void testCase1() {
		App obj = new App();
		String expectedOutput = "Hello Maven!";
		String actualOutput = obj.sayHello();

		assertEquals ( expectedOutput, actualOutput );
	}
}
