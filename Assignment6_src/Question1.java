/*
 * This program allows the user to enter 10 integers that will be pushed onto a stack (s1).
 * After 10 items are pushed, stack operations are used to display various aspects of the stack.
 */
import java.util.Stack;
import java.util.Scanner;

public class Question1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); // Create Scanner object for user input
        Stack<Integer> s1 = new Stack<>(); // Initialize stack to hold integers

        // Prompt user for input
        System.out.println("Type an integer then press enter to push it onto the stack (total of 10 integers).");
        
        // Loop to collect 10 integers from user and push each onto the stack s1
        for (int i = 1; i <= 10; i++) { 
            System.out.print("Item " + i + ": ");
            int input = in.nextInt(); // Get user input 
            s1.push(input);
        }
        
        // Display the element on top of the stack without removing it
        System.out.print("Peeking and displaying the element on top of the stack: ");
        System.out.println(s1.peek());
        // Pop and display two items off the stack
        System.out.println("Popping and displaying two items off the stack.");
        System.out.println("First popped item: " + s1.pop());
        System.out.println("Second popped item: " + s1.pop());
        // Check if the stack is empty and display the result
        System.out.print("Is the stack empty? ");
        System.out.println(s1.isEmpty());
        // Display the current size of the stack
        System.out.println("The current size of the stack is: " + s1.size());
        
        in.close(); // Close the scanner
    }
}