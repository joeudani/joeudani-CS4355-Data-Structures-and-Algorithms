/*
 * This program finds the number of words between two target words in an array.
 * It uses recursive binary search to find the index of each target string, then calculates the number of words between them.
 */
public class QuestionTwo {
    
    // Recursive binary search for finding index of target word
    public static int binarySearch(String[] arr, String target, int min, int max) {
        if (min > max) {
            System.out.println("Target word \"" + target + "\" not found.");
            return -1;
        } else {
            int mid = (min + max) / 2;
            int compare = arr[mid].compareTo(target);

            if (compare < 0) {
                return binarySearch(arr, target, mid + 1, max);
            } else if (compare > 0) {
                return binarySearch(arr, target, min, mid - 1);
            } else {
                return mid; // Target found
            }
        }
    }

    // Method to calculate the number of words between two target words
    public static void wordsDistance(String[] wordArray, String word1, String word2) {
        int index1 = binarySearch(wordArray, word1, 0, wordArray.length - 1);
        int index2 = binarySearch(wordArray, word2, 0, wordArray.length - 1);

        // Check if either of the words was not found in the array
        if (index1 == -1 || index2 == -1) {
            System.out.println("One or both words are not in the given array.");
        } else {
            int spaceBetween = Math.abs(index2 - index1) - 1;  // Calculate distance between indices
            System.out.println("The number of words between " + word1 + " and " + word2 + " is: " + spaceBetween);
        }
    }

    public static void main(String[] args) {
        String[] testArray = {"Biology","CS", "Engineering", "Physics", "Statistics"};
        
        // Test cases
        wordsDistance(testArray, "Biology", "Engineering"); // 1 words in between
        wordsDistance(testArray, "Statistics", "Physics");  // 0 word in between
        wordsDistance(testArray, "Biology", "Physics");     // 2 words in between
    }
}