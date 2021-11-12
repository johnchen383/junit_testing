package test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Test Multiply() method as IUT
 */
public class TestMultiply {
	/**
	 * Tests on two positive numbers as input
	 */
	@Test
	public void testTwoPositives() {
		int x = 5;
		int y = 8;
		assertEquals(40, IUT.multiply(x, y));
	}
}
