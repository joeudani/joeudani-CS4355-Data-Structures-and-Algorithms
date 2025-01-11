/*
 * This program implements the Merge Sort algorithm to sort an array of integers in descending order.
 * Merge Sort splits the array into two halves, recursively sorts them,
 * and then merges the sorted halves back together in the appropriate order.
 * In this case, merge sort has a time complexity of O(n log n).
 */
public class Question4 {

    // Main merge sort function
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            // Recursively sort the first and second halves
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            // Merge the sorted halves
            merge(arr, left, mid, right);
        }
    }

    // Helper method to merge two sorted subarrays
    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Create temporary arrays
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy data into temporary arrays L[] and R[]
        for (int i = 0; i < n1; ++i) L[i] = arr[left + i];
        for (int j = 0; j < n2; ++j) R[j] = arr[mid + 1 + j];

        // Merge the temp arrays back into arr[] in descending order
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] >= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        // Copy remaining elements of L[], if any
        while (i < n1) {
            arr[k++] = L[i++];
        }

        // Copy remaining elements of R[], if any
        while (j < n2) {
            arr[k++] = R[j++];
        }
    }

    // Utility method to print the array
    private static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i == arr.length - 1 ? "" : ", "));
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        // Create an array of 20 random integers between 0 and 99
        int[] randomNumbers = new int[25];
        for (int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] = (int) (Math.random() * 1000);
        }

        // Print the original array
        System.out.print("Original Array: ");
        printArray(randomNumbers);

        // Sort the array using merge sort
        mergeSort(randomNumbers, 0, randomNumbers.length - 1);

        // Print the sorted array
        System.out.print("Sorted Array (Descending): ");
        printArray(randomNumbers);
    }
}