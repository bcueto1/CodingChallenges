/**
 * Brian Michael Cueto
 * TripleLift Coding Challenge
 * Question 3: Permutations of a substring in a parent string.
 * Program dealing with problem 3 of the coding challenge.
 * ***** ASSUMED THAT ONLY ALPHABETICAL, LOWERCASE CHARACTERS WERE USED ****
 */

import java.io.IOException;
import java.util.HashMap;

/**
 * Program to see if given a substring A and a parent string B, where
 * A.length < B.length, determine if there exists some substring of B
 * which is a permutation of A.
 * 
 * I assumed that the string would only consist of lower case letters,
 * but the program can easily be modified to handle different ASCII
 * characters if needed. 
 * 
 * More explanation is included at each method, and the overall complexity
 * should be O(N), where N is the length of the larger string.
 */
public class PermuttedSubstrings {
	
	/** HashMap that contains the alphabet associated with a different prime. */
	private HashMap<Character, Integer> charPrimeMap =
			new HashMap<Character, Integer>();
	
	/**
	 * Constructor and initializes the charPrimeMap.
	 * I assumed this test would only be looking for alphabetical letters,
	 * but this could easily be changed if other string characters are needed.
	 * Since there are 26 letters, I paired each to the first 26 prime numbers.
	 *
	 * I inserted each character to each prime number using a hashmap, so lookup
	 * would only be O(1) each time.  Each total time to create this would be
	 * O(26), but if we want more than just lower case letters and use all ASCII
	 * characters, then it would be O(226), which should be advantageous if
	 * strings get much larger.
	 */
	public PermuttedSubstrings() {
		char[] alphabetArray = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		int[] primesArray = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41,
				43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
		for (int i = 0; i < 26; i++) {
		    charPrimeMap.put(alphabetArray[i], primesArray[i]);
		}
	}
	
	/**
	 * Gets a unique multiple of the primes associated with each letter.
	 * This works because of the fundamental theorem of arithmetic.
	 * Every use of this should take O(m) time, where m is the length
	 * of the given string.  Long is used because these multiples can be
	 * pretty huge depending on the string.
	 *
	 * @param myString The string inputed.
	 * @return A multiple based on primes based on the letters.
	 */
	private long getMultiple(String myString) {
		char[] temp = myString.toLowerCase().toCharArray();
		long multiple = 1;
		for (char letter: temp) {
			multiple *= this.charPrimeMap.get(letter);
		}
		return multiple;
	}

	/**
	 * Main method to determine if a permuted string is located within
	 * the parent string.  More explanation is described for each part of
	 * the method, but the overall method will take O(N) time, where N
	 * is the length of B.  The logic behind this is that the original
	 * construction of the prime multiples would take O(M) time, where
	 * M is the length of A.  The for loop that iterates through B
	 * will take overall O(N-M) time, so the overall is O(N - M + M),
	 * which is O(N).
	 *
	 * @param A The little string.
	 * @param B The parent string.
	 * @return True if the permutation is present, false if otherwise.
	 * @throws IOException if A is longer/equal than B or if both strings are empty.
	 */
	public boolean isPermutedSubstringInParentString(String A, String B)
			throws IOException {
		// Handles different edge cases.
		if (A.length() >= B.length()) {
			throw new IOException();
		}
		if (A.length() == 0 || B.length() == 0) {
			throw new IOException();
		}

		// Gets a value taken from the prime values of each character of A.
		// This is based on the charPrimeMap we use.  This takes O(m) time
		// overall, where m is the length of A.  We do the same for the first
		// window of B, and since this is based on the length of A, it also takes
		// O(m) time overall.  We can just say these two operations is just O(m).
		// Long was used to handle high values for prime multiples.
		long smallString = this.getMultiple(A);
		long bigString = this.getMultiple(B.substring(0, A.length()));

		// We iterate through ever substring of B of length A.  We first check
		// if the two multiples match and if they do, we return true.  If not,
		// We get the first character of the current window, get the prime associated
		// with it, and divide the bigString value by it.  Then we multiply the bigString value
		// by the next character prime in the overall string.  By this, we do not have to
		// recalculate the bigString multiple for every window, for that would keep taking
		// O(A.length()).  Instead, we shift and multiple and divide new characters.
		// This will overall then take O(n - m), where n is the length of B and m is the
		// length of A.  Every time we have to divide or multiply a new character, it is O(1)
		// due to the use of a character-prime hashmap.
		for (int i = 0; i < B.length() - A.length(); i++) {
			if (bigString == smallString) {
				return true;
			}
			int leftTemp = this.charPrimeMap.get(B.charAt(i));
			int rightTemp = this.charPrimeMap.get(B.charAt(i + A.length()));
			bigString = bigString / leftTemp;
			bigString = bigString * rightTemp;
		}
		return false;
	}
}
