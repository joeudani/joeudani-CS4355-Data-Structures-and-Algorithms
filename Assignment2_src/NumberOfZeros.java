import java.util.Scanner;

/*
 * I needed to enter the number for input as a string.  I tested my version of reading the number in as an int and
 * there were certain cases the program failed.
 * For instance 0000, returns 1 because Java thinks 0000 as int is int 0.
 */


public class NumberOfZeros {
    // Method to count the number of zeros in a string.
    public static int zeros(String inputString) {
        // Base case
        // If the string is empty, return 0.
        if (inputString.isEmpty()) {
            return 0;
        }
        
        /*
         * Recursive case
         * Check if the first character is "0".
         * If it is "0", start at index 0 and add one.  If not do not add 1.
         * Substring(1) of the string will keep taking off the first digit of the inputString until reaching the base case.
         */
        if (inputString.charAt(0) == '0') {
            return 1 + zeros(inputString.substring(1));
        } else {
            return zeros(inputString.substring(1));
        }
    }

    public static void main(String[] args) {
        // Create a Scanner object called in.
        Scanner in = new Scanner(System.in);
        // Prompt user for input.
        System.out.println("This program returns the number of 0's in an integer.");
        System.out.println("Enter an integer and press enter.");
        // Store the input as a string
        String input = in.next();
        // Output display
        if(zeros(input)==0) {
        	System.out.println("There are no zeros in the number "+input+".");
        }else if(zeros(input)==1) {
        	System.out.println("There is "+zeros(input)+" zero in the number "+input+".");
        }else {
        	System.out.println("There are "+zeros(input)+" zeros in the number "+input+".");
        }
  
    }
}