/**
 * Brian Michael Cueto
 * Permutted Substrings Test Cases
 */
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.io.IOException;
import org.junit.Before;
import org.junit.Test;

/** PermuttedSubstrings Test cases with jUnit. */
public class PermuttedSubstringsTest {
	
	/** Initialize the test object. */
	private static PermuttedSubstrings test;
	
	/** Set up the test object. */
	@Before
	public void setupTest() {
		test = new PermuttedSubstrings();
	}
	
	/** Handle a shorter string being longer than the big string. */
	@Test (expected = IOException.class)
	public void testShortLongerThanBig() throws IOException {
		String A = "hello";
		test.isPermutedSubstringInParentString(A, "a");
	}
	
	/** Handle when the shorter string is empty. */
	@Test (expected = IOException.class)
	public void testShortStringNoLength() throws IOException {
		test.isPermutedSubstringInParentString("", "alsdjf");
	}
	
	/** Handle when the longer string is empty. */
	@Test (expected = IOException.class)
	public void testLongStringNoLength() throws IOException {
		test.isPermutedSubstringInParentString("adsf", "");
	}

	/** Handle the tests given on the coding challenge sheet. */
	@Test
	public void testBasicTests() throws IOException {
		assertTrue(test.isPermutedSubstringInParentString("abc", "jaksjcbaksjd"));
		assertFalse(test.isPermutedSubstringInParentString("abc", "jaksjcbdaksjd"));
		assertFalse(test.isPermutedSubstringInParentString("aba", "jabkajaakb"));
	}
	
	/** Handles with a single word. */
	@Test
	public void testWithWord() throws IOException {
		String A = "hello";
		assertTrue(test.isPermutedSubstringInParentString(A, "wabdelolhfa"));
		assertFalse(test.isPermutedSubstringInParentString(A, "afjkdsfjaadkjfa"));
	}
	
	/** Handles when shorter string is only one letter. */
	@Test
	public void testWithOneLetter() throws IOException {
		String A = "z";
		assertTrue(test.isPermutedSubstringInParentString(A, "yxbaslzdkfja"));
		assertFalse(test.isPermutedSubstringInParentString(A, "abcdefgh"));
	}
	
	/** Handles when the shorter string is long. */
	@Test
	public void testWithLongString() throws IOException {
		String A = "abcqiwerjtl";
		assertTrue(test.isPermutedSubstringInParentString(A, "ajdsbadwiqabcjtlersadfj"));
		assertFalse(test.isPermutedSubstringInParentString(A, "akjfasdffjkjdfiwefj"));
	}

}
