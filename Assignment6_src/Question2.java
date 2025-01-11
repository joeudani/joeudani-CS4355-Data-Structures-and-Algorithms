/*
 * This program allows the user to enter 10 integers that will be enqueued onto a queue (q2).
 * After 10 items are added, queue operations are used to display various aspects of the queue.
 * 
 * Source: I used https://www.geeksforgeeks.org/array-implementation-of-queue-simple/ 
 * as a resource to help construct a Queue data structure using an array in Java.
 */

import java.util.Scanner;

class Queue {
    private int front; // Points to the front of the queue
    private int end;   // Points to the end of the queue
    private int capacity; // Maximum capacity of the queue
    private int[] queue;  // Array to store queue elements

    // Constructor to initialize the queue with a specific capacity
    Queue(int c) {
        front = 0;
        end = -1;
        capacity = c;
        queue = new int[capacity];
    }

    // Adds an element at the end of the queue
    void enqueue(int value) {
        // Check if the queue is full
        if (end == capacity - 1) {
            System.out.println("Queue is already full!");
            return;
        }
        // Insert element at the end
        queue[++end] = value;
    }

    // Removes an element from the front of the queue
    void dequeue() {
        // Check if the queue is empty
        if (front > end) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.println(queue[front] + " dequeued from queue");
        
        // Shift all elements one position left to maintain queue order
        for (int i = 0; i < end; i++) {
            queue[i] = queue[i + 1];
        }
        end--; // Decrement end to reflect the new size of the queue
    }

    // Prints all elements in the queue
    void display() {
        if (front > end) {
            System.out.println("Queue is empty");
            return;
        }
        // Traverse from front to end and print each element
        for (int i = front; i <= end; i++) {
            System.out.print(queue[i] + " <- ");
        }
        System.out.println();
    }

    // Prints the front element of the queue
    void peek() {
        if (front > end) {
            System.out.println("Queue is empty");
        } else {
            System.out.println("Front element is: " + queue[front]);
        }
    }

    // Returns the current number of elements in the queue
    int size() {
        return end - front + 1;
    }

    // Checks if the queue is empty
    boolean isEmpty() {
        return front > end;
    }
}

public class Question2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Queue q2 = new Queue(10); // Create a queue with a maximum size of 10

        // Prompt user for input
        System.out.println("Type an integer then press enter to enqueue (up to 10 integers).");

        // Enqueue 10 elements based on user input
        for (int i = 1; i <= 10; i++) { // Adjusted loop condition for clarity
            System.out.print("Item " + i + ": ");
            int input = in.nextInt();
            q2.enqueue(input);
        }

        // Display the entire queue
        System.out.println("The current queue is: ");
        q2.display();

        // Dequeue the front element and show updated queue information
        System.out.println("Dequeuing the element at the front of the queue.");
        q2.dequeue(); 
        System.out.println("Current size of the queue after dequeue: " + q2.size());
        System.out.print("Element at the front after dequeue: ");
        q2.peek();

        // Check and display if the queue is empty
        System.out.println("Is the queue empty? " + q2.isEmpty());
        
        in.close(); // Close the scanner
    }
}