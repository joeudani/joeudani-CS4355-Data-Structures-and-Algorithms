import java.util.ArrayList;
import java.util.Collections; // allows us to use .sort method

class Student implements Comparable<Student> {
    // Create instance variable for the Student class.
    String firstName;
    String lastName;
    int grade;

    // Class constructor.
    public Student(String firstName, String lastName, int grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
    }

    // This method converts all the information (including grade which is an int) to a string
    // to display.
    @Override
    public String toString() {
        return this.firstName + " " + this.lastName + " (Grade: " + this.grade + ")";
    }

    // Implement the compareTo method for natural ordering.
    @Override
    public int compareTo(Student other) {
        // Compare last names using the compareTo function.
        // compareTo returns an int value for two strings a and b in lexi-graphical order
        // If string a comes before string b, then -1 is returned.
        // If string b comes before string a, then a 1 is returned.
        // If both strings are the same value 0 is returned.

        // First checks if last names are the same.
        int lastName = this.lastName.compareTo(other.lastName);
        if (lastName != 0) {
            return lastName;
        }
        // If the last names are the same, check the first names.
        int firstName = this.firstName.compareTo(other.firstName);
        if (firstName != 0) {
            return firstName;
        }

        // If both the last name and first name are the same, compare integer grade values.
        return Integer.compare(this.grade, other.grade);
    }
}

public class NameGradeSort {
    public static void main(String[] args) {
        // Create an ArrayList to keep track of each student's info.
        // Each element in the ArrayList is an object.
        ArrayList<Student> studentInfo = new ArrayList<>();

        // Add the given students' first and last names as well as their scores.
        // Use new keyword to create new instances of student objects
        studentInfo.add(new Student("Joe", "Udani", 90));
        studentInfo.add(new Student("Peter", "Richardson", 88));
        studentInfo.add(new Student("Patrick", "Wolfe", 79));
        studentInfo.add(new Student("Patrick", "Smith", 54));
        studentInfo.add(new Student("John", "Appleseed", 100));
        studentInfo.add(new Student("Jack", "Brewer", 60));
        
        // Display the list as is.
        System.out.println("The unsorted list is:");
        for (Student s : studentInfo) {
            System.out.println(s);
        }
        System.out.println();
        System.out.println("---------------");
        System.out.println();
        

        // Sort the list of students
        Collections.sort(studentInfo);

        System.out.println("The sorted list is:");
        // Display the sorted list using enhanced for loop
        System.out.println("Sorted list of students:");
        for (Student s : studentInfo) {
            System.out.println(s);
        }
    }
}