import java.util.ArrayList;
import java.util.Arrays; // allows us to use .asList method
import java.util.Collections;  // allows us to use .sort method

public class ListMerger {
    public static void main(String[] args) {
        // Make two ArrayList data structures of type int
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(12,34,1));
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(12,2,10));
        System.out.println("list1 is "+list1+".");
        System.out.println("list2 is "+list2+".");

        // Add list2 to list1
        list1.addAll(list2);
        System.out.println("The two lists merged and unsorted is "+list1+".");

        // Sort the merged list
        Collections.sort(list1);

        // Display the sorted list
        System.out.println("After sorting, the merged list is " + list1+".");
    }
}