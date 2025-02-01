import java.util.Scanner;

public class BinarySearchSquares {
    // Recursive binary search on the array of squares
    public static int binarySearch(int[] a, int target, int min, int max) {
        if (min > max) {
            return -1;
        } else {
            int mid = (min + max) / 2;  // Keep mid as int, no need for casting to int
            if (a[mid] < target) {
                return binarySearch(a, target, mid + 1, max);
            } else if (a[mid] > target) {
                return binarySearch(a, target, min, mid - 1);
            } else {
                return mid;
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);


        int size = 100000;
        int[] squares = new int[size];

        // Fill the array with squares
        for (int i = 0; i < size; i++) {
            squares[i] = (int)Math.pow(i,2);
        }
        for (int i:squares){
            System.out.print(i+" ");
        }


        System.out.println();
        System.out.println("Type a number to see if it is a perfect square?");
        int target = in.nextInt();

        int min = 0;
        int max = squares.length - 1;

        // Perform binary search
        int resultIndex = binarySearch(squares, target, min, max);
        if (resultIndex == -1) {
            System.out.println("Value not found in the array.");
        } else {
            System.out.println("Value " + target + " is a perfect square.");
            System.out.println("It was found at index " + resultIndex);
        }
    }
}