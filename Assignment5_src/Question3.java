public class Question3 {
    /*
     * This program uses bubble sort to sort an array of integers.
     * It repeatedly steps through the list, compares adjacent elements,
     * and swaps them if they are in the wrong order.  In this process the largest element "bubbles" up to the top.
     * The process is repeated until no swaps are needed, indicating the array is sorted.
     * In this case, bubble sort has a time complexity is O(n^2).
     */
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            // Compare adjacent elements and swap if needed
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // Print the array after each pass
            System.out.print("Pass " + (i + 1) + ": ");
            printArray(arr);

            // If no swaps occurred in this pass, the array is already sorted
            if (!swapped) {
                break;
            }
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
        int[] randomBubble = new int[25];

        // Generate random integers between 0 and 99
        for (int i = 0; i < randomBubble.length; i++) {
            randomBubble[i] = (int) (Math.random() * 1000);
        }

        // Print the original array
        System.out.print("Original Array: ");
        printArray(randomBubble);

        // Sort the array using bubble sort
        bubbleSort(randomBubble);
    }
}