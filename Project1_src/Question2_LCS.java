import java.util.Scanner;

public class Question2_LCS {

    // Function to find the Longest Common Subsequence of two strings using recursion 
    public static int lcs(String string1, String string2, int str1len, int str2len, StringBuilder lcsBuilder) {
        // The base case happens when we reach the end of one of the strings.  If either string is empty, the LCS is 0
        if (str1len == 0 || str2len == 0) {
            return 0; // Return 0 as LCS if one string is empty
        }

        // If the last characters of both strings match, append the character and return 1 + the recursive call
        if (string1.charAt(str1len - 1) == string2.charAt(str2len - 1)) {
            lcsBuilder.append(string1.charAt(str1len - 1)); // Append 
            return 1 + lcs(string1, string2, str1len - 1, str2len - 1, lcsBuilder); // Move up in recursion
        } else {
            // If the last characters do not match, two options arise.
            // We make two StringBuilders for each case.
            StringBuilder lcs1 = new StringBuilder(lcsBuilder);
            StringBuilder lcs2 = new StringBuilder(lcsBuilder);

            /* Recursive calls ignoring one character at a time.
             * If we have ACDF and AHJD, D and D are checked for option 1
             * If we have ACDF and AHJD, F and D are checked for option 2
             */
            
            int option1 = lcs(string1, string2, str1len - 1, str2len, lcs1); // Ignore last character of string1
            int option2 = lcs(string1, string2, str1len, str2len - 1, lcs2); // Ignore last character of string2

            // Select the path that has the longer value, and update the lcsBuilder
            if (option1 > option2) {
                lcsBuilder.setLength(0); 
                lcsBuilder.append(lcs1);
                return option1; // if returns option1           
                } else {
                lcsBuilder.setLength(0);
                lcsBuilder.append(lcs2); 
                return option2;  // else returns option2      
            }
        }
    }

    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner in = new Scanner(System.in);

        
        boolean continueProgram = true; // tells the while loop to keep going or exit based on user input

        while (continueProgram) { // Loop until the user chooses to exit
            // Prompt the user for two strings
            System.out.println("Enter two strings to find their Longest Common Subsequence.");
            System.out.print("First string followed by enter: ");
            String firstString = in.nextLine(); // Read the first string
            System.out.print("Second string followed by enter: ");
            String secondString = in.nextLine(); // Read the second string

            // Get the lengths of the input strings for arguments in the function call
            int str1Length = firstString.length();
            int str2Length = secondString.length();

            // Create a StringBuilder to store the LCS characters
            StringBuilder lcsBuilder = new StringBuilder();

            // Call the LCS function to find the length of the LCS
            int lcsLength = lcs(firstString, secondString, str1Length, str2Length, lcsBuilder);

            // Display the length as well as the string or character of the LCS
            System.out.println("The length of the LCS: " + lcsLength);
            // Reverse string for display.  Recursion built the string from last index to 0 index
            System.out.println("LCS: " + lcsBuilder.reverse().toString()); 
            // Ask the user if they want to compute an additional LCS.
            System.out.println("Would you like to compute another LCS? (1 for Yes, 0 for No): ");
            int userChoice = in.nextInt(); // Read the user's choice
            in.nextLine(); // Consume the leftover newline

            // If the user enters 0, exit the loop
            if (userChoice == 0) {
                continueProgram = false; // Set the flag to false to exit the loop
            }
        }

        // Close the scanner
        in.close();
    }
}