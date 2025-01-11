class ListNode {
    // List node class holds the data of a node with a reference to the next node in the list

    int data;
    ListNode next;

    // Constructor 1 creates a node with data, and no next node.
    public ListNode(int data) {
        this.data = data;
        this.next = null;
    }

    // Constructor 2 creates a node with data, and a reference to the next node in the list
    public ListNode(int data, ListNode next) {
        this.data = data;
        this.next = next;
    }
}

class LinkedIntList {
    private ListNode front; // first value in the list

    public void add(int value) {
        // First check if list is empty
        if (front == null) {
            // Add to the empty list
            front = new ListNode(value);
        } else {
            /*
             *  If list is not empty add to the end of an existing list
             * Start at the front of the list and loop util the last node
             */
            ListNode current = front;
            while (current.next != null) {
                current = current.next;
            }
            // After traversing the entire list add a new node at the end
            current.next = new ListNode(value);
        }
    }

    public void remove(int value) {
        // Method removes the first occurrence of given calue from list
        // If the list is empty, do nothing
        if (front == null) return;
        // Check if the first node holds value to be removed
        if(front.data == value) {
            // Remove first node by pointing to the next node
            front = front.next;
            return;
        }
        // Go through list to find the remove value starting from the first node
        ListNode current = front;
        ListNode prev = front;

        // Loop until the end of the list
        while (current != null) {
            // Check if the current node holds value to be removed
            if (current.data == value) {
                // If the node contains the value, remove the curren node
                current = current.next; // Move current node to next in list
                prev.next = current; // Update the previous node's next reference value
                return;
            }
            //  Move both previous and current points one node forward in the list
            prev = current;
            current = current.next;
        }
    }

    // Returns the size of the linked list
    public int size() {
        int count = 0;
        // From the first node traverse the list, counting each node
        ListNode current = front;
        while (current != null) {
            count++;
            current = current.next; // Moves current to the next node
        }
        return count;
    }

    // Returns the integer at the given index in the linked list
    public int get(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        ListNode current = front;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    // Method to find the index of the first occurrence of a given value in the linked list
    public int indexOf(int value) {
        int index = 0;
        ListNode current = front;

        // Start at the front of the list and traverse the list until the end
        while (current != null) {
            // Check if the current node matches the target value, return if found
            if (current.data == value) {
                return index;
            }
            // Move to the next index in list
            index++;
            // Move on to next node
            current = current.next;
        }
        // If value is not in the list, return -1
        return -1;
    }

    // Inserts the given value at the given index
    public void add(int value, int index) {
        // Check if the index is in the range of the list
        if (index < 0 || index > size()) {
            System.out.println("Index is out of bounds of the current list.");
        }

        // If adding at the front, update the front to the new node
        if (index == 0) {
            // Creates a new node pointing to the current front
            front = new ListNode(value, front);
        } else {
            ListNode current = front;
            // Starting from the front of the list, traverse until the node before the target index
            for (int i = 0; i < index - 1; i++) {
                // Moves current to the next node
                current = current.next;
            }
            // Insert the new node at the target index
            current.next = new ListNode(value, current.next); // New node points to the current next node
        }
    }

    // Removes the element at the given index
    public void remove_at_index(int index) {
        // Check if the index is in the range of the list
        if (index < 0 || index >= size()) {
            System.out.println("Index is out of bounds of the current list");
        }
        // If removing front of the list, update the front to the next node
        if (index == 0) {
            // Update front
            front = front.next;
        } else {
            ListNode current = front;
            // Start from the front of the list and traverse to the node before the target index
            for (int i = 0; i < index - 1; i++) {
                // Move to the next node
                current = current.next;
            }
            // Remove the node at the target index by changing reference
            current.next = current.next.next;
        }
    }

    // Sets the list element at the given index to have the given value
    public void set(int value, int index) {
        // Check if the index is in the range of the list
        if (index < 0 || index >= size()) {
            System.out.println("Index is out of bounds of the current list");
        }
        ListNode current = front;
        // Start from the front of the list and traverse to the node of the given index
        for (int i = 0; i < index; i++) {
            // Moves current to next node
            current = current.next;
        }
        // Set the data of the current node to the value entered
        current.data = value;
    }

    // Returns the minimum value of the elements present in the list
    public int min() {
        // Check if the list is empty
        if (front == null) {
            System.out.println("List is empty");
        }
        // Initialize minValue with data from font
        int minValue = front.data;
        ListNode current = front.next;
        // Starting from the second node, traverse through the list to find the minimum value
        while (current != null) {
            // Check if current node's data is less than minValue
            if (current.data < minValue) {
                // Update minValue if a smaller value is found in the list
                minValue = current.data;
            }
            // Moves current to next node
            current = current.next;
        }
        // Return min
        return minValue;
    }

    // Swaps the values present at the provided indices in the list
    public void swap(int index1, int index2) {
        // Check if the indices are in the range of the list
        if (index1 < 0 || index1 >= size() || index2 < 0 || index2 >= size()) {
            System.out.println("Index is out of bounds of the current list");
        }

        // If indices are the same return since no swap would occur
        if (index1 == index2) return;
        // Start from the front to find the node at index1 and index 2
        ListNode node1 = front;
        ListNode node2 = front;

        // Traverse the list to reach the node at index1
        for (int i = 0; i < index1; i++) {
            node1 = node1.next;
        }
        // Traverse the list to reach the node at index2
        for (int i = 0; i < index2; i++) {
            node2 = node2.next;
        }
        // Swap the data between node1 and node2 using a temporary value
        int temp = node1.data;
        node1.data = node2.data;
        node2.data = temp;
    }

    // Returns the index of the last occurrence of the given value or -1 if not found
    public int lastIndexOf(int value) {
        int index = 0;
        // Until a match keep lastIndex set to -1.
        int lastIndex = -1;
        // Starting from the front of the  list traverse the list to find the last occurrence of the given value
        ListNode current = front;
        while (current != null) {
            // If current node's data matches the target value, set lastIndex to the current index
            if (current.data == value) {
                lastIndex = index;
            }
            index++;
            // Go to the next node
            current = current.next;
        }
        // Return the lastIndex if found, if not return -1
        return lastIndex;
    }

    // Removes all occurrences of the given value from the list
    public void removeAll(int value) {
        while (front != null && front.data == value) {
            // Update front to the next node if the front node has the target value
            front = front.next;
        }
        // Starting from the front of the list traverse to remove all occurrences of the value
        ListNode current = front;
        while (current != null && current.next != null) {
            // If the next node contains the target value remove the next node
            if (current.next.data == value) {
                current.next = current.next.next;
            } else {
                // Moves current to next node
                current = current.next;
            }
        }
    }
    // Prints the list
    public void print() {
        ListNode current = front;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}