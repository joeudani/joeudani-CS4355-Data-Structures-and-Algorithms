import java.util.Scanner;
public class SumOfIntegers {

    public static int sumOfDigits(int n){
        // Base case for the sum
        if(n==0){
            return 0;
        }

        // Recursive case
        return (n % 10) + sumOfDigits(n / 10);
        /*
        * The first part of the recursive step (n % 10) will perform the modulus operator
        * and extract the last digit of the number as the remainder.
        * Example 10394 % 10 = 4
        *
        * The second part of the recursive case (n / 10) performs integer division on n.
        * The fractional part of the result will be discarded while the rest of the integer will remain.
        * Example 10394 / 10 = 1039
        */
    }

    public static void main(String[] args){
        // Create a Scanner called in.
        Scanner in = new Scanner(System.in);

        // Ask for user input.
        System.out.println("This program sums each digit in a positive integer");
        System.out.println("Enter a positive integer then press enter.");

        // read in integer through Scanner.
        int input = in.nextInt();
        int sumResult = sumOfDigits(input);
        System.out.println("The sum of the digits in your positive integer is "+sumResult+".");
    }
}
