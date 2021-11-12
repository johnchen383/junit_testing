package test;

import static org.junit.Assert.*;
import org.junit.*;

import org.junit.runners.Suite;
import org.junit.runner.RunWith;

@RunWith(Suite.class)
@Suite.SuiteClasses({Tests.Positives.class, Tests.Negatives.class})
public class Tests {
	public static class Positives {
		@BeforeClass
		public static void init() {
			System.out.println("@BeforeClass called");
		}
		
		@AfterClass
		public static void close() {
			System.out.println("@AfterClass called");
		}
		
		@Before
	    public void setUp() {
			System.out.println("@Before called");
	    }
		
		@After
		public void tearDown() {
			System.out.println("@After called");
		}
		
		@Test
		public void testBothPositive() {
			System.out.println("Starting Test +ve");
			assertEquals(6, IUT.multiply(2, 3));
			System.out.println("Completed Test +ve");
		}
		
		@Test
		public void testSquare() {
			System.out.println("Starting Test +ve num 2");
			assertEquals(4, IUT.multiply(2, 2));
			System.out.println("Completed Test +ve num 2");
		}
		
		@Ignore
		@Test
		public void ignoredTest() {
			//doesn't matter the order of the annotations @Ignore could come after @Test
			System.out.println("Ignored so not executed :(((");
		}
	}
	
	public static class Negatives {
		@Test
		public void testBothPositive() {
			System.out.println("Starting Test -ve");
			assertEquals(9, IUT.multiply(-3, -3));
			System.out.println("Completed Test -ve");
		}
		
		@Test(timeout = 10)
		public void infinite() {
			while (true);
		}
		
		@Test(expected = IndexOutOfBoundsException.class)
		public void exceptionThrow() {
			throw new IndexOutOfBoundsException();
		}
	}
	
}

