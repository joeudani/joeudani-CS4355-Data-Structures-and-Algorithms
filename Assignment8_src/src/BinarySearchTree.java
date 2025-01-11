/*
 *  The class IntTree Node represents a single node in the binary search tree.
 *  A node consists of a piece of data (an integer) with references to the left subtree and right subtree.
 */
class IntTreeNode {
    public int data;            // Data
    public IntTreeNode left;    // Reference to the left subtree
    public IntTreeNode right;   // Reference to the right subtree

    // This constructor creates a leaf node with data passed as an argument
    public IntTreeNode(int data) {
        this(data, null, null);
    }
    // This constructor creates a branch node with data and links to left and right children
    public IntTreeNode(int data, IntTreeNode left, IntTreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
// Represents a binary search tree (BST)
class IntSearchTree {
    private IntTreeNode overallRoot; // Root of the BST

    // Initializes an empty tree
    public IntSearchTree() {
        overallRoot = null;
    }

    // Adds a value to the BST
    public void add(int value) {
        overallRoot = add(overallRoot, value);
    }
    /*
     * Recursive helper to add a value to the appropriate position in the tree.
     * The pseudo algorithms is: if the current node in the tree is null, create a new node.
     * Otherwise, there are two cases:
     * If the value is less than or equal to the root, recursively call the add method on the left subtree.
     * If the value is greater than the root, recursively call the add method on the right subtree.
     */
    private IntTreeNode add(IntTreeNode root, int value) {
        if (root == null) {
            root = new IntTreeNode(value); // Create a new node if the current spot is null
        } else if (value <= root.data) {
            root.left = add(root.left, value); // Go left if value is less than or equal to root
        } else {
            root.right = add(root.right, value); // Go right if value is greater than root
        }
        return root;
    }

    // Prints the tree in "inorder" traversal of tree (left subtree, root, right subtree)
    public void printInorder() {
        System.out.println("Printing in Inorder:");
        printInorder(overallRoot); // calls helper function to print
        System.out.println();
    }

    private void printInorder(IntTreeNode root) {
        if (root != null) {
            printInorder(root.left); // Visit left subtree
            System.out.print(root.data + " "); // Print root
            printInorder(root.right);  // Visit right subtree
        }
    }

    // Checks if the tree contains a specific value
    public boolean contains(int value) {
        return contains(overallRoot, value);
    }

    /*
     * Recursive function goes through tree to find value.  The base case is if the root is null, and the function returns false
     * If it's not null it checks if the data matches the value.  If not recurse left or right depending on teh comparison of the
     * value to data.
     */
    private boolean contains(IntTreeNode root, int value) {
        if (root == null) return false; // Value not found
        if (value == root.data) return true; // Found the value
        // Recur to the left or right subtree based on comparison
        return value < root.data ? contains(root.left, value) : contains(root.right, value);
    }

    // Computes the sum of all values in the tree
    public int sum() {
        return sum(overallRoot);
    }

    // The base case occurs when null subtree has sum 0.  If not sum the root's left data and right data and recurse.
    private int sum(IntTreeNode root) {
        if (root == null) return 0;
        return root.data + sum(root.left) + sum(root.right);
    }

    // Counts the number of levels (or height) in the tree
    public int countLevels() {
        return countLevels(overallRoot);
    }

    // The base occurs when  null subtree has height 0
    private int countLevels(IntTreeNode root) {
        if (root == null) return 0;
        // Height = 1 (current node) + max of left and right subtree heights
        return 1 + Math.max(countLevels(root.left), countLevels(root.right));
    }

    // Counts the number of leaf nodes (nodes with no children)
    public int countLeaves() {
        return countLeaves(overallRoot);
    }

    private int countLeaves(IntTreeNode root) {
        if (root == null) return 0; // Base case: no leaves in null subtree
        if (root.left == null && root.right == null) return 1; // Current node is a leaf
        // Total leaves = leaves in left subtree + leaves in right subtree
        return countLeaves(root.left) + countLeaves(root.right);
    }

    // Finds the smallest value in the tree
    public int min() {
        if (overallRoot == null) throw new IllegalStateException("Tree is empty");
        IntTreeNode current = overallRoot;
        while (current.left != null) current = current.left; // Go left as far as possible
        return current.data;
    }

    // Finds the largest value in the tree
    public int max() {
        if (overallRoot == null) throw new IllegalStateException("Tree is empty");
        IntTreeNode current = overallRoot;
        while (current.right != null) current = current.right; // Go right as far as possible
        return current.data;
    }

    // Counts the total number of nodes in the tree
    public int size() {
        return size(overallRoot);
    }

    private int size(IntTreeNode root) {
        if (root == null) return 0; // Base case: null subtree has size 0
        // Total size = 1 (current node) + size of left + size of right
        return 1 + size(root.left) + size(root.right);
    }

    // Counts the number of nodes that are left children
    public int countLeftNodes() {
        return countLeftNodes(overallRoot);
    }

    private int countLeftNodes(IntTreeNode root) {
        if (root == null) return 0; // Base case: no left nodes in null subtree
        int count = (root.left != null) ? 1 : 0; // Count this node if it has a left child
        // Total left nodes = count at current + left subtree + right subtree
        return count + countLeftNodes(root.left) + countLeftNodes(root.right);
    }

    // Checks if the tree is "full" (every node has 0 or 2 children)
    public boolean isFull() {
        return isFull(overallRoot);
    }

    private boolean isFull(IntTreeNode root) {
        if (root == null) return true; // Null tree is considered full
        if ((root.left == null && root.right != null) || (root.left != null && root.right == null)) return false;
        // Recur for left and right subtrees
        return isFull(root.left) && isFull(root.right);
    }

    // Prints the tree in descending order (right, root, left)
    public void printDescendingInorder() {
        System.out.println("Printing in Descending Inorder:");
        printDescendingInorder(overallRoot);
        System.out.println();
    }

    private void printDescendingInorder(IntTreeNode root) {
        if (root != null) {
            printDescendingInorder(root.right); // Visit right subtree
            System.out.print(root.data + " "); // Print root
            printDescendingInorder(root.left); // Visit left subtree
        }
    }

    // Generates a string representation of the tree structure
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        buildString(overallRoot, "", sb);
        return sb.toString();
    }

    private void buildString(IntTreeNode node, String prefix, StringBuilder sb) {
        if (node == null) {
            sb.append(prefix).append("null\n");
        } else {
            sb.append(prefix).append(node.data).append("\n");
            buildString(node.left, prefix + "L-", sb); // Recur for left subtree
            buildString(node.right, prefix + "R-", sb); // Recur for right subtree
        }
    }
}
