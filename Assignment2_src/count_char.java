import java.util.Scanner;
public class count_char {
    public static int countChar(String inputString, char charTarget) {
        // Base case
    	// If the string is empty return 0.
        if (inputString.isEmpty()) {
            return 0;
        }
        // Recursive case
        if (inputString.charAt(0) == charTarget) {
            /*
             *If the first character in inputString matches charTarget, add 1 and call the method for the rest of the string.
             *The .substring(1) takes off the first letter of the string each function call since indexing starts at 0.
             *Example: "word".substring(1) would give ord, and so forth each recursive call.
             */
            return 1 + countChar(inputString.substring(1), charTarget);
        } else {
            /*
             * For the else, call the method again without adding 1 to inputString.
             * Will still take off a letter from the string each time with .substring().
             */
            return countChar(inputString.substring(1), charTarget);
        }
    }

    public static void main(String[] args) {
        // Create a Scanner object called in.
        Scanner in = new Scanner(System.in);
        
        // Prompt the user to enter a string and character.
        System.out.println("This program will count the number of times a letter shows up in a single word.");
        System.out.print("Enter a word then press enter.");
        String word = in.nextLine();
        System.out.print("Enter a character then press enter. ");
        char letter = in.next().charAt(0);

        // Call the countChar method and print the result
        int result = countChar(word, letter);
        if(result==1) {
        	System.out.println("The letter "+letter+" appears "+result+" time in the word "+word+".");
        }else {
        	System.out.println("The letter "+letter+" appears "+result+" times in the word "+word+".");
        }
        
    }
}