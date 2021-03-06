/**
 * Brian Michael Cueto
 * TripleLift Coding Challenge
 * Question 2: TripleLiftianNumbers
 * Program based on the 2nd question for the coding challenge.
 */

/**
 * Program to determine the solution to TripleLiftianNumbers
 * as defined by the recurrence relation for problem 2.
 */
public class TripleLiftianNumbers {

    /** Original value for T0. */
	private long t0 = 6;
	/** Original value for T1. */
	private long t1 = 7;
	/** Original value for T2. */
	private long t2 = 2;
	
	/** Constructor. */
	public TripleLiftianNumbers() {}
	
	/**
	 * Helper method to solve the recursion relation
	 * and get unknown values using recursion.
	 *
	 * @param myNumber The number to be inputed.
	 * @return The answer to the recursion.
	 */
    private long getNumber(long myNumber) {
        long temp = 0;
    	if (myNumber != 3) {
    	    temp = this.getNumber(myNumber - 1);
    	    this.t0 = t1;
        	this.t1 = this.t2;
        	this.t2 = temp;
    	}
    	return (4 * t2) - (5 * t1) + (3 * t0);
    }

    /**
     * The TripleLiftian number method to return a String
     * based on the given input.  If the number is 0, 1, or 2,
     * the helper method is skipped as output is given.
     *
     * @param myNumber The given number.
     * @return The answer to the relation in String.
     */
    public String TripleLiftianNumber(long myNumber) {
    	if (myNumber == 0) {
    		return Long.toString(6);
    	} else if (myNumber == 1) {
    		return Long.toString(7);
    	} else if (myNumber == 2) {
    		return Long.toString(2);
    	}
        return Long.toString(this.getNumber(myNumber));
    }
}
