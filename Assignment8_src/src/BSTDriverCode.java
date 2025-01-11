import java.util.Scanner;
public class BSTDriverCode {
    public static void main(String[] args) {
        // Create a Scanner object and an IntSearchTree object
        Scanner in = new Scanner(System.in);
        IntSearchTree binarySearchTree = new IntSearchTree();
        int userResponse; // stores various user responses

        // Start of user interface
        System.out.println("Enter integers to add to the binary search tree. Press enter after" +
                "each entry to add it.  When done, press 0 to stop adding.");
        System.out.println("Only integers will be accepted.");
        int number;
        int counter=1;
        while (true) {
            System.out.print("Int "+counter+":");
            number = in.nextInt();
            if(number == 0) {
                break;
            }else{
                binarySearchTree.add(number);
            }
            counter++;
        }

        // Displaying
        System.out.println("Printing increasing inorder traversal of data entered:");
        binarySearchTree.printInorder();
        System.out.println("Printing descending inorder traversal:");
        binarySearchTree.printDescendingInorder();

        // Are there certain values inside the tree? Is the tree full?
        System.out.println("Enter a number to see if it is contained in your tree?");
        userResponse=in.nextInt();
        if(binarySearchTree.contains(userResponse)){
            System.out.println("The tree contains "+userResponse+".");
        }else{
            System.out.println("The tree does not contain "+userResponse+".");
        }

        if(binarySearchTree.isFull()){
            System.out.println("The tree is full.");
        }else{
            System.out.println("The tree is not full.");
        }

        // Facts about the tree
        System.out.println("The sum of all values in your tree: " + binarySearchTree.sum());
        System.out.println("The number of levels in your tree: " + binarySearchTree.countLevels());
        System.out.println("The number of leave in your trees: " + binarySearchTree.countLeaves());
        System.out.println("Did you put at least 2 numbers in the tree? (1 for yes, 0 for no)");
        userResponse=in.nextInt();
        if(binarySearchTree.size()>1){
            System.out.println("Minimum value: " + binarySearchTree.min());
            System.out.println("Maximum value: " + binarySearchTree.max());
        } else{
            System.out.println("There is no min or max value, as your tree has less than two values.");
        }
        System.out.println("The total size of your tree: " + binarySearchTree.size());
        System.out.println("The number of left nodes in your tree: " + binarySearchTree.countLeftNodes());
        System.out.println("END OF TREE PROGRAM");
    }
}