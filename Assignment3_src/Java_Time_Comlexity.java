/*
 * To test each time complexity, I modified the name of what function I was calling in the main method.
 * Example: constantTime(n), logarithmicTime(n), etc..
 * After running each method I recorded the times in a list in Python.
 */
public class Java_Time_Complexity {
    public static void main(String[] args) {
        int i=0;
        long[] constanTimeValues = new long[11];
        for (int n = 0; n <= 1000; n += 100) {
            long startTime = System.nanoTime();
            // Modify the name  of the function for each complexity
            constantTime(n);
            long endTime = System.nanoTime();

            System.out.println("The time taken for this method is: ");
            System.out.println("n = " + n + " Time taken: " + (endTime -
                    startTime) + " ns");
            System.out.println();
            i++;
            }
    }
    public static void constantTime(int n) {
        System.out.print("");
    }

    public static void linearTime(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("");
        }
    }
    public static void quadraticTime(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("");
            }
        }
    }

    public static void cubicTime(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    System.out.println("");
                }
            }
        }
    }

    public static void logarithmicTime(int n) {
        for (int i = 1; i < n; i *= 2) {
            System.out.print("");
        }
    }

    public static void linearithmicTime(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j *= 2) {
                System.out.print("");
            }
        }
    }
}




