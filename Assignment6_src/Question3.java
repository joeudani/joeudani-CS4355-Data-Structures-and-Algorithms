/*
 * This program replaces all occurrences of the integer 9 with 8 in both a Queue and a Stack.
 * The two main functions replaceNinesInQueue and replaceNinesInStack are implemented in the main method,
 * showing the original and modified stack and queue.
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Question3 {

    // Method to replace all occurrences of 9 with 8 in a Queue data structure
    public static Queue<Integer> replaceNinesInQueue(Queue<Integer> queue) {
        Queue<Integer> tempQueue = new LinkedList<>(); // Temporary queue to store modified elements

        // Replace 9s with 8s and add them to tempQueue
        while (!queue.isEmpty()) {
            int value = queue.remove();
            tempQueue.add(value == 9 ? 8 : value); // Add 8 if value is 9, otherwise add original value
        }

        // Restore modified elements back to the original queue
        while (!tempQueue.isEmpty()) {
            queue.add(tempQueue.remove());
        }

        return queue; // Return the modified queue
    }

    // Method to replace all occurrences of 9 with 8 in a Stack data structure 
    public static Stack<Integer> replaceNinesInStack(Stack<Integer> stack) {
        Stack<Integer> tempStack = new Stack<>(); // Temporary stack to store modified elements

        // Replace 9s with 8s and add them to tempStack
        while (!stack.isEmpty()) {
            int value = stack.pop();
            tempStack.push(value == 9 ? 8 : value); // Push 8 if value is 9, otherwise push original value
        }

        // Restore modified elements back to the original stack in correct order
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }

        return stack; // Return the modified stack
    }

    // Method to display elements of a Queue
    public static void displayQueue(Queue<Integer> queue) {
        System.out.print("Queue: ");
        for (int val : queue) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    // Method to display elements of a Stack
    public static void displayStack(Stack<Integer> stack) {
        System.out.print("Stack: ");
        for (int val : stack) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Fill a queue with integers, some of them being 9's.
        Queue<Integer> queue = new LinkedList<>();
        queue.add(9);
        queue.add(8);
        queue.add(8);
        queue.add(4);
        queue.add(9);
        queue.add(8);
        queue.add(9);
        queue.add(1);
        queue.add(9);

        System.out.print("Original queue: ");
        displayQueue(queue);
        replaceNinesInQueue(queue);
        System.out.print("Modified queue with removed nines: ");
        displayQueue(queue);

        // Fill a stack with integers, some of them being 9's.
        Stack<Integer> stack = new Stack<>();
        stack.push(9);
        stack.push(8);
        stack.push(8);
        stack.push(4);
        stack.push(9);
        stack.push(8);
        stack.push(2);
        stack.push(1);
        stack.push(9);

        System.out.print("Original stack: ");
        displayStack(stack);
        replaceNinesInStack(stack);
        System.out.print("Modified stack with removed nines: ");
        displayStack(stack);
    }
}