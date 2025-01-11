import java.util.Scanner;

public class Question4_BinarySearch {
    // Function to find the maximum positive integer n such that n^2 < x.
    public static int findMaximumN(double x) {
        int min = 0;
        int max = (int) Math.floor(Math.sqrt(x));
        int maxInteger = 0;

        while (min <= max) {
            int mid = min + (max - min) / 2;

            // Check if mid^2 is less than x
            if (mid * mid < x) {
                maxInteger = mid;
                min = mid + 1; // Search for a larger value
            } else {
                max = mid - 1; // Search for a smaller value
            }
        }
        return maxInteger; // Return the maximum integer found
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int decision;
        boolean continueProgram = true;

        while (continueProgram) {
            System.out.println("This program finds the maximum positive integer n such that n^2 < x.");
            System.out.print("Enter a positive number, then press enter: ");
            double userInput = in.nextDouble(); // Accept a double input for decimals
            
            // Validate the input
            if (userInput <= 0) {
                System.out.println("Please enter a positive number.");
                continue; // Skip to the next iteration if the input is invalid
            }

            // Calculate and display the result
            System.out.println("The maximum positive integer n such that n^2 < " + userInput + " is: " + findMaximumN(userInput));
            
            // User input determines whether to stay in program or exit
            System.out.print("Do you want to compute another integer n? (1 for Yes, 0 for No)");
            
            // Check for valid integer input
            while (true) {
                if (in.hasNextInt()) {
                    decision = in.nextInt();
                    if (decision == 0 || decision == 1) {
                        break; // Exit the loop if valid input is given
                    } else {
                        System.out.println("Invalid input.");
                    }
                } else {
                    System.out.println("Invalid input.");
                    in.next(); // Clear invalid input
                }
            }

            if (decision == 0) {
                continueProgram = false; // Exit the while loop
            }
        }

        // Close scanner
        in.close();
    }
}