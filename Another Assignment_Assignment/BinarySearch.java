public class BinarySearch {

    public static int binarySearch(int[] a, int target) {
        int min = 0;
        int max = a.length - 1;

        while (min <= max) {
            // Calculate mid using (min + max) / 2
            int mid = (min + max) / 2;

            if (a[mid] == target) {
                return mid; // Target found, return its index
            } else if (a[mid] < target) {
                min = mid + 1; // Target is in the right half
            } else {
                max = mid - 1; // Target is in the left half
            }
        }

        return -1; // Target not found, return -1
    }

    public static void main(String[] args) {
        // Example array, must be sorted for binary search
        int[] array = {1, 3, 5, 7, 9, 11, 13, 15};
        int target = 7; // Target element to search

        // Perform binary search
        int result = binarySearch(array, target);

        // Output the result
        if (result != -1) {
            System.out.println("Target found at index: " + result);
        } else {
            System.out.println("Target not found.");
        }
    }
}