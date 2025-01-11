import java.util.ArrayList;
import java.util.Arrays;

public class UpperCaseConverter {
    public static void main(String[] args){
        // define an array list
        ArrayList<String> states = new ArrayList<>(Arrays.asList("Indiana","Illinois","Ohio","Wisconsin"));
        System.out.println("The original array contains the strings "+states+".");

        // call the method toUpperCase using states as the argument
        toUpperCase(states);

    }
    // This method uses a for each loop to fill a new array called upperArray with
    // strings in states converted to upper case.
    public static void toUpperCase(ArrayList<String> inputArray){
        // new array to hold upper case strings.
        ArrayList<String> upperArray = new ArrayList<>();

        for(String s:inputArray){
            // loops through each string in inputArray.  It uses the function .toUpperCase() to
            // convert the strings to upper case and fill upperArray with the updated values.
            upperArray.add(s.toUpperCase());
        }
        System.out.print("The strings converted to upper case are "+upperArray+".");
    }
}
