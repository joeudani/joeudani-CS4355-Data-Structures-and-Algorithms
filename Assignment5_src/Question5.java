import java.io.*;
import java.util.HashMap;
import java.util.Map;

/*
 * This program implements the merge sort algorithm with a Map data structure to sort words stored
 * as keys based on their frequency in a .txt file.
 * In this case, merge sort has a time complexity of O(n log n).
 */

public class Question5 {
    // Merge Sort for sorting the keys by frequency in ascending order
    private static void mergeSort(String[] keys, Map<String, Integer> frequencyMap) {
        if (keys.length < 2) return;

        int mid = keys.length / 2;
        String[] left = new String[mid];
        String[] right = new String[keys.length - mid];

        System.arraycopy(keys, 0, left, 0, mid);
        System.arraycopy(keys, mid, right, 0, keys.length - mid);

        mergeSort(left, frequencyMap);
        mergeSort(right, frequencyMap);
        merge(keys, left, right, frequencyMap);
    }

    // Merge two sorted arrays based on word frequency in ascending order
    private static void merge(String[] keys, String[] left, String[] right, Map<String, Integer> frequencyMap) {
        int i = 0;
        int j = 0;
        int k = 0;

        // Ascending order: Use <= to prioritize smaller frequencies
        while (i < left.length && j < right.length) {
            if (frequencyMap.get(left[i]) <= frequencyMap.get(right[j])) {
                keys[k++] = left[i++];
            } else {
                keys[k++] = right[j++];
            }
        }
        // Copy any remaining elements from left and right arrays
        while (i < left.length) {
            keys[k++] = left[i++];
        }
        while (j < right.length) {
            keys[k++] = right[j++];
        }
    }

    public static void main(String[] args) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        // File path to where the txt document was stored on my machine
        File textFile = new File("/Users/joeudani/Desktop/Data Structures/Joe_Udani_Assignment5/src/story.txt");

        // Read strings from the file and count occurrences
        try (BufferedReader br = new BufferedReader(new FileReader(textFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\W+"); // Split by non-word characters
                for (String word : words) {
                    if (!word.isEmpty()) { // Skip empty words
                        word = word.toLowerCase(); // Normalize to lowercase
                        frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("There is an error in your input file: " + e.getMessage());
            return;
        }
        // Sort the words by frequency in ascending order
        String[] keys = frequencyMap.keySet().toArray(new String[0]);
        mergeSort(keys, frequencyMap);

        // Print the sorted results
        System.out.println("Word frequencies in ascending order:");
        for (String key : keys) {
            System.out.println(key + ": " + frequencyMap.get(key));
        }
    }
}