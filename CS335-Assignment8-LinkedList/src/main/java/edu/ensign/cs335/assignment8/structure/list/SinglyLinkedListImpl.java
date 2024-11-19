package edu.ensign.cs335.assignment8.structure.list;

/**
 * A singly linked list implementation providing operations to
 * manage and manipulate the list.
 *
 * <p>A singly linked list is a linear data structure where each element or node contains a reference
 * to the next element in the sequence. It allows for dynamic resizing, making it ideal for situations
 * where data size may change frequently. However, unlike arrays, linked lists do not provide
 * direct access to elements by index and may require traversing nodes for certain operations.
 *
 * @param <T> The type of elements held in this list.
 */
public class SinglyLinkedListImpl<T> implements SinglyLinkedList<T> {


    private Node<T> head; // The first node in the list
    private Node<T> tail; // The last node in the list
    private int isSize = 0; // Tracks the total number of elements in the list
    private int isCount = 0; // Tracks the count of non-null elements in the list

    /**
     * Returns the total number of elements in the list.
     *
     * @return the number of elements in the list.
     */
    @Override
    public int getIsSize() {
        isSize = 0; // Initialize size counter to zero
        Node<T> currentNode = head; // Start from the head of the list

        // Step through each item in the list until you reach one that is null.
        while (currentNode != null) {
            isSize++; // Increases the size counter for each node
            currentNode = currentNode.getNext(); // Move to the next node
        }
        return isSize; // Return the computed size once it reaches the end of the list
    }

    /**
     * Returns the total number of non-null elements in the list.
     *
     * @return the number of non-null elements.
     */
    @Override
    public int getIsCount() {
        isCount = 0; // Initialize count to zero
        Node<T> currentNode = head; // Start from the head of the list

        // Step through each item in the list until you reach one that is null.
        while (currentNode != null) {
            // Only increment if the node contains non-null data
            if (currentNode.getData() != null) {
                isCount++;
            }
            currentNode = currentNode.getNext(); // Move to the next node
        }
        return isCount; // Return the count of non-null elements
    }


    /**
     * Checks if the linked list is empty.
     *
     * @return boolean type. true if the list is empty; false otherwise.
     */
    @Override
    public boolean isEmpty() {
        // If head is null, list has no elements and is considered empty
        return head == null;
    }

    /**
     * Inserts a new element at the end of the list.
     *
     * @param data the data to be added.
     */
    @Override
    public void insertTail(T data) {
        Node<T> newNode = new Node<>(data); // Create a new node with given data

        // If the list is currently empty
        if (head == null) {
            head = newNode; // Set head to new node
            tail = newNode; // Set tail to new node
        } else {
            tail.setNext(newNode); // Link current tail to the new node
            tail = newNode; // Update tail to the new node
        }
        isSize++; // Increase the size of the list
        if (data != null) {
            isCount++; // Increase the count if data is non-null
        }
    }

    /**
     * Inserts a new element at a specified position in the list.
     *
     * @param data  the data to be inserted.
     * @param position the position where the new element should be inserted.
     * @throws IllegalStateException if the position is negative or invalid.
     */
    @Override
    public void insertNth(T data, int position) {
        if (position < 0) {
            throw new IllegalStateException("Invalid position for insertion."); // Negative position is invalid
        }

        Node<T> newNode = new Node<>(data); // Create a new node with the provided data

        // If inserting at the head (position 0)
        if (position == 0) {
            newNode.setNext(head); // Link the new node to the current head
            head = newNode; // Update head to the new node
            if (tail == null) {
                tail = newNode; // If list was empty, set tail to new node
            }
            isSize++;
            isCount++;
            return; // Exit after insertion
        }

        // Special case: list is empty but position > 0
        if (head == null) {
            head = new Node<>(null); // Create a dummy head node
            isSize = 1;
        }

        Node<T> currentNode = head; // Start from the head

        // Move to the node immediately before the target position.
        for (int i = 1; i < position; i++) {
            if (currentNode.getNext() == null) {
                currentNode.setNext(new Node<>(null)); // Add a placeholder node if list is short
                isSize++;
            }
            currentNode = currentNode.getNext();
        }

        newNode.setNext(currentNode.getNext()); // Insert the new node by updating the links between nodes.
        currentNode.setNext(newNode);

        // Update tail if new node is the last node
        if (newNode.getNext() == null) {
            tail = newNode;
        }

        isSize++;
        isCount++;
    }

    /**
     * Inserts a new element at the head of the list.
     *
     * @param data the data to be added.
     */
    @Override
    public void insertHead(T data) {
        Node<T> newNode = new Node<>(data); // Create a new node
        newNode.setNext(head); // new node to current head
        head = newNode; // Update head to the new node

        if (tail == null) {
            tail = newNode; // If list was empty, update tail to new node
        }
        isSize++;
        if (data != null) {
            isCount++;
        }
    }

    /**
     * Checks if the list contains a specified element.
     *
     * @param data the element to check for.
     * @return boolean type. true if the element exists in the list; false otherwise.
     */
    @Override
    public boolean contains(T data) {
        Node<T> currentNode = head; // Start from the head

        // Step through each node in the list.
        while (currentNode != null) {
            // Check if current node's data matches the target data
            if (currentNode.getData() != null && currentNode.getData().equals(data)) {
                return true;
            }
            currentNode = currentNode.getNext(); // Move to the next node
        }
        return false; // Return false if not found
    }

    /**
     * Returns the element at the specified index.
     *
     * @param index the index of the element.
     * @return the element at the specified index.
     * @throws IndexOutOfBoundsException if the index is out of range.
     */
    @Override
    public T getNth(int index) {
        if (index < 0 || index >= getIsSize()) {
            throw new IndexOutOfBoundsException("The index is outside the possibilities of the SinglyLinkedList.");
        }

        Node<T> currentNode = head;
        int position = 0;

        // Step through the list until reaching the target index.
        while (currentNode != null) {
            if (position == index) {
                return currentNode.getData(); // Return data when index is reached
            }
            currentNode = currentNode.getNext(); // Move to the next node
            position++;
        }

        return null; // Null if index is invalid
    }

    /**
     * Deletes the last element in the list.
     *
     * @return  boolean type. true if an element was deleted; false if the list was empty.
     */
    @Override
    public boolean deleteTail() {
        if (head == null) {
            return false; // List is empty
        }

        // If there is only one element
        if (head.getNext() == null) {
            if (head.getData() != null) isCount--;
            head = null; // Clear head
            tail = null; // Clear tail
            isSize--;
            return true;
        }

        Node<T> currentNode = head;
        // Step through the list to arrive at the second-to-last node.
        while (currentNode.getNext().getNext() != null) {
            currentNode = currentNode.getNext();
        }

        if (tail.getData() != null) isCount--;
        currentNode.setNext(null); // Remove last node by setting next to null
        tail = currentNode; // Update tail
        isSize--;

        return true;
    }

    /**
     * Deletes the first element in the list.
     *
     * @return boolean type. true if an element was deleted; false if the list was empty.
     * @throws IllegalStateException if the list is empty.
     */
    @Override
    public boolean deleteHead() {
        if (head == null) {
            throw new IllegalStateException("Cannot delete the head node when no head node exists.");
        }

        if (head.getData() != null) isCount--;
        head = head.getNext(); // Move head to next node
        isSize--;

        if (head == null) {
            tail = null; // Update tail if list is now empty
        }
        return true;
    }

    /**
     * Deletes an element at the specified index.
     *
     * @param index the index of the element to be deleted.
     * @return boolean type. true if an element was deleted; false otherwise.
     * @throws IllegalStateException if the index is out of range.
     */
    @Override
    public boolean deleteNth(int index) {
        if (index < 0 || index >= getIsSize()) {
            throw new IllegalStateException("No Node exists at provided index to delete.");
        }

        if (index == 0) {
            return deleteHead(); // Use deleteHead for index 0
        }

        Node<T> currentNode = head;
        int position = 0;

        // Step through the list until you're at the node before the target index.
        while (currentNode != null && position < index - 1) {
            currentNode = currentNode.getNext();
            position++;
        }

        if (currentNode.getNext().getData() != null) isCount--;
        currentNode.setNext(currentNode.getNext().getNext()); // Remove node at index

        if (currentNode.getNext() == null) {
            tail = currentNode; // Update tail if last element was deleted
        }
        isSize--;
        return true;
    }

    /**
     * Returns a string representation of the list.
     *
     * @return a string representation of the list.
     */
    @Override
    public String toString() {
        if (head == null) {
            return "The SinglyLinkedList instance is empty."; // Case for an empty list
        }

        StringBuilder builder = new StringBuilder();
        Node<T> currentNode = head;

        // Step through each element in the list and add it to the builder.
        while (currentNode != null) {
            builder.append(currentNode.getData());
            if (currentNode.getNext() != null) {
                builder.append(" -> ");
            }
            currentNode = currentNode.getNext();
        }

        return builder.toString();
    }

    /**
     * Clears the list, removing all elements.
     */
    @Override
    public void clear() {
        head = null; // Clear head reference
        tail = null; // Clear tail reference
        isSize = 0; // Reset size
        isCount = 0; // Reset count
    }
}
