/**
 * Brian Michael Cueto
 * TripleLiftianNumbers Test Cases
 */

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/** Test class for TripleLiftianNumbers using jUnit. */
public class TripleLiftianNumbersTest {

	/** The test object. */
	private static TripleLiftianNumbers myTest;
	
	/** Setup the test. */
	@Before
	public void setupTest() {
		myTest = new TripleLiftianNumbers();
	}
	
	/** Test to make sure T0 equals 6. */
	@Test
	public void testZero() {
		assertEquals("6", myTest.TripleLiftianNumber(0));
	}
	
	/** Test to make sure T1 equals 7. */
	@Test
	public void testOne() {
		assertEquals("7", myTest.TripleLiftianNumber(1));
	}
	
	/** Test to make sure T2 equals 2. */
	@Test
	public void testTwo() {
		assertEquals("2", myTest.TripleLiftianNumber(2));
	}
	
	/** Test to make sure 3 is working. */
	@Test
	public void testThree() {
		assertEquals("-9", myTest.TripleLiftianNumber(3));
	}
	
	/** Test to make sure 4 is working. */
	@Test
	public void testFour() {
		assertEquals("-25", myTest.TripleLiftianNumber(4));
	}
	
	/** Test to make sure 25 is working. */
	@Test
	public void testTwentyFive() {
		assertEquals("-2575238999", myTest.TripleLiftianNumber(25));
	}

}
