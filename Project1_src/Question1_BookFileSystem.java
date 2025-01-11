import java.io.*;
import java.util.Comparator;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

/*
 * This program allows users to access a library user interface
 * A user can add a book, borrow a book, return a book.
 * The user can also display books based on alphabetical order or availability.
 */
public class Question1_BookFileSystem {

    /*
     * Create a book object
     * Each book contains fields for title and availability
     * There is a toString() method to print the title and its availability
     */
    static class Book {
        String title;
        String availability;

        public Book(String title, String availability) {
            this.title = title;
            this.availability = availability;
        }

        @Override
        public String toString() {
            return title + ", " + availability;
        }
    }

    // Method to save books back to the file
    public static void saveBooksToFile(ArrayList<Book> books, File file) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        for (Book book : books) {
            writer.write(book.title + "," + book.availability);
            writer.newLine();
        }
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        int userChoice;  // Variable to record user's menu choice
        boolean exitProgram = false;  // Flag to exit the program
        Scanner in = new Scanner(System.in);  // Create Scanner object for user input

        // File containing book data
        File textFile = new File("/Users/joeudani/Desktop/Books.txt");
        ArrayList<Book> booksFromTXT = new ArrayList<>();  // ArrayList to store Book objects

        // Read book data from the file and store them in the ArrayList
        BufferedReader fileReader = new BufferedReader(new FileReader(textFile));
        String line;
        while ((line = fileReader.readLine()) != null) {
            String[] parts = line.split(",");  // Split each line by comma
            if (parts.length == 2) {  // Ensure the line has both a title and availability status
                booksFromTXT.add(new Book(parts[0].trim(), parts[1].trim()));  // Create a new Book object and add it to the list
            } else {
                System.out.println("Error: Skipping malformed line: " + line);
            }
        }
        fileReader.close();  // Close the file reader

        // Main program loop
        while (!exitProgram) {
            // Display the menu to the user
            System.out.println("-----------------------------------------------------------  ");
            System.out.println("| Welcome to the library file system!                     |");
            System.out.println("| 1. Display all books sorted alphabetically              |");
            System.out.println("| 2. Display all books sorted by availability             |");
            System.out.println("| 3. Add a book                                           |");
            System.out.println("| 4. Borrow a book                                        |");
            System.out.println("| 5. Return a book                                        |");
            System.out.println("| 0. Exit the library file system                         |");
            System.out.println("-----------------------------------------------------------  ");
            System.out.printf("Menu Number Response: ");
            userChoice = in.nextInt();  // Get user's choice
            in.nextLine();  // Consume newline character

            switch (userChoice) {
                case 1:
                    // Display books sorted alphabetically by title
                    Collections.sort(booksFromTXT, new Comparator<Book>() {
                        @Override
                        public int compare(Book b1, Book b2) {
                            return b1.title.compareTo(b2.title);
                        }
                    });
                    for (Book book : booksFromTXT) {  // Print each book in the sorted list
                        System.out.println(book);
                    }
                    break;

                case 2:
                    // Display books sorted by availability
                    Collections.sort(booksFromTXT, new Comparator<Book>() {
                        @Override
                        public int compare(Book b1, Book b2) {
                            return b1.availability.compareTo(b2.availability);
                        }
                    });

                    // Separate and print available and unavailable books
                    System.out.println("Available Books:");
                    for (Book book : booksFromTXT) {
                        if (book.availability.equalsIgnoreCase("available")) {
                            System.out.println(book);
                        }
                    }

                    System.out.println("\nBorrowed Books:");
                    for (Book book : booksFromTXT) {
                        if (book.availability.equalsIgnoreCase("borrowed")) {
                            System.out.println(book);
                        }
                    }
                    break;

                case 3:
                    // Add a new book to the system
                    System.out.println("Enter the title of the book you want to add:");
                    String newTitle = in.nextLine();  // Get the title of the new book
                    booksFromTXT.add(new Book(newTitle, "Available"));  // Add book with default status "Available"
                    saveBooksToFile(booksFromTXT, textFile);  // Save the updated list back to the file
                    System.out.println("Book added successfully.");
                    break;

                case 4:
                    // Borrow a book if available
                    System.out.println("Enter the title of the book to borrow:");
                    String borrowTitle = in.nextLine();  // Get the title of the book to borrow
                    boolean foundBorrow = false;  // Flag to check if the book was found
                    for (Book book : booksFromTXT) {
                        if (book.title.equalsIgnoreCase(borrowTitle)) {  // Check if the book exists
                            if (book.availability.equalsIgnoreCase("Available")) {  // Check if the book is available
                                book.availability = "Unavailable";  // Mark the book as borrowed
                                foundBorrow = true;
                                System.out.println("You have successfully borrowed " + book.title);
                            } else {
                                System.out.println("The book is currently unavailable.");
                            }
                            break;
                        }
                    }
                    if (!foundBorrow) {
                        System.out.println("Book not found in the system.");
                    } else {
                        saveBooksToFile(booksFromTXT, textFile);  // Save the updated list back to the file
                    }
                    break;

                case 5:
                    // Return a borrowed book
                    System.out.println("Enter the title of the book to return:");
                    String returnTitle = in.nextLine();  // Get the title of the book to return
                    boolean foundReturn = false;  // Flag to check if the book was found
                    for (Book book : booksFromTXT) {
                        if (book.title.equalsIgnoreCase(returnTitle)) {  // Check if the book exists
                            if (book.availability.equalsIgnoreCase("Unavailable")) {  // Check if the book is borrowed
                                book.availability = "Available";  // Mark the book as available
                                foundReturn = true;
                                System.out.println("You have successfully returned " + book.title);
                            } else {
                                System.out.println("The book is already available.");
                            }
                            break;
                        }
                    }
                    if (!foundReturn) {  // If the book was not found, add it as available
                        System.out.println("Book not found. Adding it as available.");
                        booksFromTXT.add(new Book(returnTitle, "Available"));
                    }
                    saveBooksToFile(booksFromTXT, textFile);  // Save the updated list back to the file
                    break;

                case 0:
                    exitProgram = true;  // Set the value of exitProgram to true to break out of while loop
                    System.out.println("Thank you for using the library file system!");
                    System.out.println("Exiting the library file system.");
                    break;

                default:
                    System.out.println("Invalid choice, please refer to menu for options.");  // Default executes if no value the user inputs is valud.
            }
        }

        in.close();  // Close the Scanner object once user exits.
    }
}