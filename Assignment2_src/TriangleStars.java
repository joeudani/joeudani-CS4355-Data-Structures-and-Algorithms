import java.util.Scanner;

public class TriangleStars {

    // Recursive method prints n stars on a line, then recursively prints the remaining stars.
    public static void printStars(int x) {
    	/*
    	 * Base case
    	 * If n is 0 print nothing. There has to be at least one line of stars.
    	 */
        if (x == 0) {
            return;
        }
        // Print a star then recursively print the remaining stars
        System.out.print("*");
        printStars(x - 1);
    }

    // Recursive method to print a reverse triangle of stars
    public static void printTriangle(int x) {
    	/*
    	 * Base case
    	 * If n is 0, do nothing.
    	 */
        if (x == 0) {
            return;
        }
        // Print n stars for the current line.
        printStars(x);
        System.out.println();  // println to moves output to next line.
        // Print the triangle recursively
        printTriangle(x - 1);
    }

    public static void main(String[] args) {
        // Create a Scanner object called in.
        Scanner in = new Scanner(System.in);

        // Prompt user for input
        System.out.println("This program will print a reversed triangle made out of '*'");
        System.out.println("Example for lines = 3");
        System.out.println("***");
        System.out.println("**");
        System.out.println("*");
        System.out.println("Enter the number of lines for the triangle then press enter.");
        int lineNumber = in.nextInt();

        // Display result
        printTriangle(lineNumber);
    }
}