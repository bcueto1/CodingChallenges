/**
 * Brian Michael Cueto
 * Test cases for TripleLift.
 */
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/** Test cases for TripleLift. */
public class TripleLiftTest {
	
	/** Test multiple of 3. */
	@Test
	public void testMultipleThree() {
		String temp = "1\n"
				+ "2\n"
				+ "Triple\n"
				+ "4\n";
		assertEquals(temp, TripleLift.printNumbers(4));
	}
	
	/** Test multiple of 7. */
	public void testMultipleSeven() {
		String temp = "1\n"
				+ "2\n"
				+ "Triple\n"
				+ "4\n"
				+ "5\n"
				+ "Triple\n"
				+ "Lift\n";
		assertEquals(temp, TripleLift.printNumbers(7));
	}
	
	/** Test multiple of 7 and 3. */
	public void testTwentyOne() {
		String temp = "1\n"
				+ "2\n"
				+ "Triple\n"
				+ "4\n"
				+ "5\n"
				+ "Triple\n"
				+ "Lift\n"
				+ "8\n"
				+ "Triple\n"
				+ "10\n"
				+ "11\n"
				+ "Triple\n"
				+ "13\n"
				+ "Lift\n"
				+ "Triple\n"
				+ "16\n"
				+ "17\n"
				+ "Triple\n"
				+ "19\n"
				+ "20\n"
				+ "TripleLift\n";
		assertEquals(temp, TripleLift.printNumbers(21));
				
	}

}
