public class Question1 {
    /*
     * This program uses selection sort to sort a random array of integers in ascending order..
     * In this case, selection sort has a time complexity of O(n^2).
     */
    public static void selectionSort(int[] inputArray) {
        int length = inputArray.length;
        for (int i = 0; i < length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (inputArray[j] < inputArray[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap the found minimum element with the first element
            int temp = inputArray[minIndex];
            inputArray[minIndex] = inputArray[i];
            inputArray[i] = temp;
            // Display the array after each pass
            System.out.print("Pass " + (i + 1) + ": ");
            printArray(inputArray);
        }
    }
    private static void printArray(int[] array) {
        for (int number : array) {
            System.out.print(number + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] randomSelection = new int[25];
        // Fill the array with random integers between 0 and 999
        for (int i = 0; i < randomSelection.length; i++) {
            randomSelection[i] = (int) (Math.random() * 1000);
        }
        // Print the original array first
        System.out.print("Original Array: ");
        printArray(randomSelection);
        // Sort the array using selection sort and print results
        selectionSort(randomSelection);
    }
}