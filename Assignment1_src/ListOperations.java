import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListOperations {
    public static void main(String[] args) {
        // Declare two ArrayLists of type Integer and fill them with the given values
        List<Integer> mainList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 2, 2));
        List<Integer> mainListTemp = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 2, 2));
        List<Integer> subList = new ArrayList<>((Arrays.asList(2,1)));
        List<Integer> removeList = new ArrayList<>((Arrays.asList(1,2)));
        List<Integer> compareList = new ArrayList<>(Arrays.asList(3, 4, 5));


        // Check if the primary list contains every element in the secondary list and display result
        if(mainList.containsAll(subList)){
            System.out.println("The mainList "+ mainList+", contains the elements from the secondary list "+subList+".");
        }else{
            System.out.println("The primary list "+ mainList+", does not contain the elements from the secondary list: "+subList+".");
        }

        // Remove the values from removeList (1,2) from the main list and display result
        mainList.removeAll(removeList);
        System.out.println("The mainList "+mainListTemp+", after removing the elements [1, 2] is " + mainList+".");

        // Take the values in mainListTemp from indices 3 to 6 and display the result
        System.out.println("The values of mainList "+mainListTemp+", from indices 3 to 6 are "+mainListTemp.subList(3, 6));


        // Using an enhanced for loop to calculate the sum of the list mainList;
        int sum = 0;// starts add zero and incremented
        int indexCounter = 0;
        for (int num : mainListTemp) {
            sum+=num; // the same as sum = sum + num
            indexCounter++; // counts up until we reach the end of the list
            // When indexCounter equals the size of the mainList, print the sum
            if(indexCounter==mainListTemp.size()){
                System.out.println("The sum of all elements in the mainList "+mainListTemp+", equals " + sum+".");
            }
        }

        // Check to see if compareList is equal to mainList and display the result
        if(mainListTemp.equals(compareList)){
            System.out.println("compareList "+compareList+", is equal to mainList");
        }else{
            System.out.println("compareList "+compareList+", is not equal to mainList "+mainListTemp+".");
        }

    }
}
