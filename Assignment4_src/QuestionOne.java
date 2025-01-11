/*
 * This program implements a recursive binary search to locate a target in a sorted array.
 * The segment of the array left over from each recursive call is displayed.
 */
public class QuestionOne {
    public static int binarySearch(int[] x, int target, int min, int max) {
        // Print the current array segment
        System.out.print("Current array: ");
        for (int i=min;i<=max;i++) {
            System.out.print(x[i] + " ");
        }
        System.out.println();

        /* 
         * The base case is that the target not found. 
         * If the minimum value has exceeded the max value, we have checked every value in the array for the target.
         */
        if (min > max) {
            System.out.println("Target value: "+target+" not found.");
            return -1;
        } else {
            int mid = (min + max) / 2;  // locate middle value 
            if (x[mid] < target) {
                return binarySearch(x, target, mid + 1, max);
                /* 
                 * if x[mid] is less than the target, throw away all values to the of left and including x[mid].
                 *  Make mid + 1 the new minimum.
                 */
            } else if (x[mid] > target) {
                return binarySearch(x, target, min, mid - 1);
                /* 
                 * if x[mid] is greater than the target, throw away all values to the of right and including x[mid].
                 *  Make mid - 1 the new maximum.
                 */
            } else {
                System.out.println("Element "+target+" found at index " + mid+".");
                return mid;
            }
        }
    }
    public static void main(String[] args) {
        int[] sorted = {1, 2, 4, 5, 7, 10, 12, 15, 21, 30, 50, 160, 200, 451};
        int target = 21;
        int min = 0;
        int max = sorted.length - 1;
        binarySearch(sorted, target, min, max);
    }
}