import java.util.Scanner;
public class LLMethodsDriverCode {
    public static void main(String[] args) {
        // Create new Scanner and LinkedIntList object
        Scanner in = new Scanner(System.in);
        LinkedIntList myLinkedList = new LinkedIntList();
        int value;
        int index;
        int userInput;

        // Add elements to Linked List using add function.
        System.out.println("Enter numbers to be put into the linked list (5 max).");

        for(int i=1;i<=5;i++){
            myLinkedList.add(userInput=in.nextInt());
        }

        // Print the Linked List
        System.out.print("The current size of myLinkedList is: ");
        myLinkedList.print();
        System.out.println();

        // Size method
        System.out.print("The size of myLinkedList is: ");
        System.out.println(myLinkedList.size());

        // Get method
        System.out.println("Type an index to retrieve its data.");
        System.out.println("Index:");
        userInput=in.nextInt();
        System.out.print("Element at index "+userInput+" is ");
        System.out.println(myLinkedList.get(userInput));

        // indexOf method
        System.out.println("Type in one of the numbers you entered to retrieve its index:");
        userInput=in.nextInt();
        System.out.print("Index of "+userInput+" is ");
        System.out.println(myLinkedList.indexOf(userInput));
        // Add at index method
        System.out.println("Enter a value to be put into to the list, followed by the index you want it placed.");
        System.out.print("Value: ");
        value=in.nextInt();
        System.out.print("Index: ");
        index=in.nextInt();
        myLinkedList.add(value,index);
        System.out.println("After adding "+value+" at index "+index+" the list is: ");
        myLinkedList.print();
        System.out.println();

        // Remove at index method
        System.out.println("Enter an index to remove the value there:");
        System.out.print("Index: ");
        index=in.nextInt();
        myLinkedList.remove_at_index(index);
        System.out.print("After removing the element at index "+index+" the list is ");
        myLinkedList.print();
        System.out.println();

        // Set method
        System.out.println("Enter a data value and index to set that index to that value: ");
        System.out.print("Index:");
        index=in.nextInt();
        System.out.print("Value:");
        value=in.nextInt();
        myLinkedList.set(value, index);
        System.out.print("After setting element at index "+index+" to "+value+" the list is:");
        myLinkedList.print();
        System.out.println();

        // Min method
        System.out.print("The minimum value in the list is: ");
        System.out.println(myLinkedList.min());

        // Swap method
        int index1;
        int index2;
        System.out.println("Enter two indices in the list to swap the data at those positions.");
        System.out.print("Index 1:");
        index1=in.nextInt();
        System.out.print("Index 2:");
        index2=in.nextInt();
        myLinkedList.swap(index1, index2);
        System.out.print("The current list after the swap is ");
        myLinkedList.print();
        System.out.println();

        // lastIndexOf method
        System.out.println("Enter a value and I will return the index of the last place it occurs.");
        System.out.println("I will return -1 if your value is not in the list.");
        System.out.print("Value:");
        value=in.nextInt();
        int lastIndexOf = myLinkedList.lastIndexOf(value);
        System.out.println(lastIndexOf);

        // removeALL method
        System.out.println("Enter a value to remove all instances of that value from the list.");
        System.out.print("Value:");
        value=in.nextInt();
        myLinkedList.removeAll(value);
        System.out.print("The list after removing all "+value+" is ");
        myLinkedList.print();
        System.out.println();

        System.out.println("PROGRAM FINISHED.");



    }
}