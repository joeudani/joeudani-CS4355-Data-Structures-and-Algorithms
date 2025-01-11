/*
 * This program evaluates a post-fix expression entered by the user and solves it using the stack data structure
 * The main structure of the logic of this program is:
 * Input a post-fx expression
 * Check to see if the first character is a number, if it is push it on the stack
 * Check to see if the current character is an operator, if it is pop two values off the stack and apply the operator to them.
 * Continue until the stack is empty.
 */
import java.util.Stack;
import java.util.Scanner;

public class Question4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); // Create Scanner object
        System.out.println("Enter a postfix expression then press enter:");
        String input = in.next();

        try {
            int result = evaluatePostfix(input); // Evaluate the post-fix expression
            System.out.println("Evaluation Result: " + result); // Display the result
        } catch (Exception e) {
            System.out.println("Error in evaluating expression: " + e.getMessage());
        }
        in.close(); // Close the scanner
    }

    // Method to evaluate a post-fix expression
    public static int evaluatePostfix(String expression) {
        Stack<Integer> stack = new Stack<>(); // Stack to hold operands

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            // If character is a digit, push it to the stack as an integer
            if (Character.isDigit(ch)) {
                stack.push(ch - '0'); // Convert char digit to int and push it onto the stack
            }
            // If character is an operator, pop two values and apply the operator
            else if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^') {
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Invalid postfix expression.");
                }
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int result;

                // Apply the operator to the two operands
                switch (ch) {
                    case '+':
                        result = operand1 + operand2;
                        break;
                    case '-':
                        result = operand1 - operand2;
                        break;
                    case '*':
                        result = operand1 * operand2;
                        break;
                    case '/':
                        if (operand2 == 0) {
                            throw new ArithmeticException("Division by zero."); // Exception to avoid division by 0 errors
                        }
                        result = operand1 / operand2;
                        break;
                    case '^':
                        result = (int) Math.pow(operand1, operand2); // Exponentiation operator is used, then casted to int
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid character in postfix expression: " + ch);
                }
                stack.push(result); // Push the result back onto the stack
            } else {
                throw new IllegalArgumentException("Invalid character in postfix expression: " + ch);
            }
        }

        // The stack should now contain exactly one element, the final result
        if (stack.size() != 1) {
            throw new IllegalArgumentException("Invalid postfix expression.");
        }

        return stack.pop(); 
        // Return the evaluation's result
    }
}