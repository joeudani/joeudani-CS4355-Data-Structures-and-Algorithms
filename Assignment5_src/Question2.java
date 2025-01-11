public class Question2 {
    /*
     * This program uses insertion sort to sort a random array of integers.
     * It moves elements greater than the current key to one position ahead
     * and inserts the key in its correct position.  In this case, insertion sort has a time complexity of O(n^2).
     */
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i]; // Current element to be inserted
            int j = i - 1;

            // Shift elements that are greater than key to the right
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key; // Insert current key in the correct position

            // Print sorted and unsorted portions
            System.out.print("Pass " + i + ": ");
            System.out.print("Sorted: [");
            for (int k = 0; k <= i; k++) {
                System.out.print(arr[k] + (k == i ? "" : ", "));
            }
            System.out.print("] | Unsorted: [");
            for (int k = i + 1; k < n; k++) {
                System.out.print(arr[k] + (k == n - 1 ? "" : ", "));
            }
            System.out.println("] | Key " + key + " inserted at index " + (j + 1));
        }
    }
    public static void main(String[] args) {
        int[] randomInsertion = new int[25];

        // Generate random integers between 0 and 999
        for (int i = 0; i < randomInsertion.length; i++) {
            randomInsertion[i] = (int) (Math.random() * 1000);
        }

        // Print the original array
        System.out.print("Original Array: ");
        printArray(randomInsertion);

        // Sort the array using insertion sort
        insertionSort(randomInsertion);
    }

    // Utility method to print an array
    private static void printArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + (i == array.length - 1 ? "" : ", "));
        }
        System.out.println("]");
    }
}