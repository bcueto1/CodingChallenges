/**
 * Brian Michael Cueto
 * TripleLift Coding Challenge
 * Question 1: TripleLift
 * Program that prints numbers 1 to N, on a new line,
 * but prints separate outputs for multiple of 3 and/or 7.
 */

/**
 * Program that prints "Triple" for a multiple of 3, "Lift" for a multiple
 * of 7, and "TripleLift" for a multiple of both.  This is based on a given
 * integer and prints all integers from 1 to that integer, keeping into
 * account the rules above.
 *
 */
public class TripleLift {

	/** Constructor. */
	public TripleLift() {};
	
	/**
	 * Handles the printing of the numbers based on
	 * if the integer is divisible by 3 or 7 or another number
	 * @param number The inputed number.
	 */
	public static String printNumbers(int number) {
		String temp = "";
		for (int i = 1; i <= number; i++) {
            if ((i % 3 == 0) && (i % 7 == 0)) {
                temp += "TripleLift" + "\n";
            } else if (i % 3 == 0) {
            	temp += "Triple" + "\n";
            } else if (i % 7 == 0) {
            	temp += "Lift" + "\n";
            } else {
            	temp += i + "\n";
            }
        }
		return temp;
	}
	
	/**
	 * Main function for the program.
	 * @param args Command line arguments.
	 */
    public static void main(String[] args) {
    	int myNumber = 0;
    	if (args.length != 1) {
    	    System.err.println("Not correct number of input!");
    	    System.exit(0);
    	}
        try {
        	myNumber = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.err.println("Not a valid input!");
            System.exit(0);
        }
        System.out.println(printNumbers(myNumber));
	}
}
