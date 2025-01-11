/*
 * This program uses two binary search functions to find a given target value's starting and ending
 * position in a sorted array of integers.
 */

public class QuestionFour {
	
	/* 
	 * This function fills an array of length two with the positions of the first and last occurrences 
	 * of the target value. If the target is not found, [-1, -1] is returned by default.
	 */
	
    public static int[] findPosition(int[] nums, int target) {
        int[] result = new int[2];
        // Values if target is not found.
        result[0] = -1;
        result[1] = -1;
        result[0] = binaryFirstPosition(nums, target, 0, nums.length - 1);
        result[1] = binaryLastPosition(nums, target, 0, nums.length - 1);
        return result;
    }
    

    // Recursive binary search to find the first occurrence of the target.
    private static int binaryFirstPosition(int[] sortedInts, int target, int min, int max) {
        if (min > max) {
            return -1;
        } else {
            int mid = (min + max) / 2;
            if (sortedInts[mid] < target) {
                return binaryFirstPosition(sortedInts, target, mid + 1, max);
            } else if (sortedInts[mid] > target) {
                return binaryFirstPosition(sortedInts, target, min, mid - 1);
            } else {
                // If mid is the first position or the previous element is not the target, return mid
                if (mid == 0 || sortedInts[mid - 1] != target) {
                    return mid;
                } else {
                    return binaryFirstPosition(sortedInts, target, min, mid - 1);
                }
            }
        }
    }

    // Recursive binary search to find the last occurrence of the target.
    public static int binaryLastPosition(int[] sortedInts, int target, int min, int max) {
        if (min > max) {
            return -1;
        } else {
            int mid = (min + max) / 2;
            if (sortedInts[mid] < target) {
                return binaryLastPosition(sortedInts, target, mid + 1, max);
            } else if (sortedInts[mid] > target) {
                return binaryLastPosition(sortedInts, target, min, mid - 1);
            } else {
                // If mid is the last position or the next element is not the target, return mid
                if (mid == sortedInts.length - 1 || sortedInts[mid + 1] != target) {
                    return mid;
                } else {
                    return binaryLastPosition(sortedInts, target, mid + 1, max);
                }
            }
        }
    }

    public static void main(String[] args) {
    	// Test case 1
        int[] array1 = {4, 5, 5, 7, 7, 8, 8, 9, 10, 15, 17};
        int target1 = 8;
        int[] result1 = findPosition(array1, target1);
        System.out.println("For target "+target1 + ": ["+result1[0] + "," + result1[1]+"]");

        // Test case 2
        int[] array2 = {4, 5, 5, 7, 7, 8, 8, 9, 10, 15, 17};
        int target2 = 6;
        int[] result2 = findPosition(array2, target2);
        System.out.println("For target "+target2 + ": ["+result2[0] + "," + result2[1]+"]");
        
        // Test case 3
        int[] array3 = {4, 5, 5, 7, 7, 8, 8, 9, 10, 15, 17};
        int target3 = 4;
        int[] result3 = findPosition(array3, target3);
        System.out.println("For target "+target3 + ": ["+result3[0] + "," + result3[1]+"]");

        // Test case 4
        int[] array4 = {4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4};
        int target4 = 4;
        int[] result4 = findPosition(array4, target4);
        System.out.println("For target "+target4 + ": ["+result4[0] + "," + result4[1]+"]");
    }
}