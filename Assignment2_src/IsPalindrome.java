import java.util.Scanner;

public class IsPalindrome {
    public static boolean isPalindrome(String inputString) {
        /* Base case
         *If the string has 0 or 1 character, it's a palindrome.
         */
        if (inputString.length() <= 1) {
            return true;
        }
        /* Recursive case
         * Check if the first and last characters are the same.
         * Also check the substring in between.
         */
        if (inputString.charAt(0) != inputString.charAt(inputString.length() - 1)) {
            return false;
        }

        // Check the substring in between by taking the substring one less each time.
        return isPalindrome(inputString.substring(1, inputString.length() - 1));
    }

    public static void main(String[] args) {
        // Create a Scanner object called in.
        Scanner in = new Scanner(System.in);
        
        // Prompt the user to enter a string
        System.out.println("This program checks if a word is a palindrome.");
        System.out.print("Enter a word then press enter.");
        String word = in.nextLine();
 
       // Display result of the isPalindrome function.
        boolean result = isPalindrome(word);
        if(result==true) {
        	System.out.println(word+" is a palindrome.");
        }else {
        	System.out.println(word+" is not a palindrome.");	
        }
    }
}