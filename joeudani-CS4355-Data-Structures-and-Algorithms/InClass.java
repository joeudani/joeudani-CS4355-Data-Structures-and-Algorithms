import java.util.Scanner;
public class InClass {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in); // create new scanner object
        System.out.println("Enter a string: "); // prompting user
        String userInput=in.next(); // store response
        System.out.println("Here is your string printed vertically:");
        vertical(userInput); // call method

    }

    public static void vertical(String inputString){
        for(int i=0;i<inputString.length();i++){
            System.out.println(inputString.charAt(i));

        }
    }
}
