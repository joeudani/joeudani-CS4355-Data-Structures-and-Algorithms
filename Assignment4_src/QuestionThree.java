/*
 * This program finds a target value in an array which is sorted in descending order, without sorted to ascending order first.
 * The main change to the binary search algorithm are the two comparisons.
 * Instead of the regular binary search, if arr[mid] > target we search the right half (mid + 1 to max).
 * Instead of the regular binary search, if arr[mid] < target we search the left half (min to mid - 1).
 */

public class QuestionThree {

    public static int binarySearch(int[] arr, int target, int min, int max) {
        // Base case is target not found.
        if (min > max) {
            System.out.println("Target value: " + target + " not found.");
            return -1;
        } else {
            int mid = (min + max) / 2;  // Locate middle value
            // Adjusted comparisons to work for an array sorted in descending order.
            if (arr[mid] > target) {
                return binarySearch(arr, target, mid + 1, max); // Target in the right half
            } else if (arr[mid] < target) {
                return binarySearch(arr, target, min, mid - 1); // Target in the left half
            } else {
            	// Display result of which index the target was found at.
                System.out.println("Element " + target + " found at index " + mid + ".");
                return mid;
            }
        }
    }

    public static void main(String[] args) {
        int[] array1 = {50, 31, 24, 20, 18, 15, 12, 10, 9, 7, 5, 4, 3, 1};
        // Test target1
        int target1 = 24;
        binarySearch(array1, target1, 0, array1.length - 1);
     // Test target2
        int target2 = 7;
        binarySearch(array1, target2, 0, array1.length - 1);
    }
}