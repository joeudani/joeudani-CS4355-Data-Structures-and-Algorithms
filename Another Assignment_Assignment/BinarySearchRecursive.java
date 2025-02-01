public class BinarySearchRecursive {
    public static int binarySearchSquares(int[] a, int target, int min, int max) {

        if (min > max) {
            return -1;
        } else {
            int mid = (min + max) / 2;
            if (a[mid] < target) {
                return binarySearchSquares(a, target, mid + 1, max);
            } else if (a[mid] > target) {
                return binarySearchSquares(a, target, min, mid - 1);
            } else {
                return mid;
            }
        }
    }

    public static void main(String[] args) {
        int[] natural = {1,2,3,4,5,6,7,8,9};
        int target = 3;
        int min = 0;
        int max = natural.length -1;

        binarySearchSquares(natural,target,min,max);

    }
}