package edu.ensign.cs335.assignment9.structure.stack;

/**
 * The interface for defining a StackOnLinkedList implementation.
 * @param <T>
 *
 * NOTE: Please do not modify this interface.
 */
public interface StackOnLinkedList<T> {

    /**
     * Pushes an item onto the top of the stack.
     * @param t The argument to push onto the stack.
     */
    void push(T t);

    /**
     * Removes the object at the top of this stack and returns that object.
     * @return T as the value to return.
     */
    T pop();

    /**
     * Looks at the object at the top of this stack without removing it from the stack.
     * @return T
     */
    T peek();

    /**
     * Returns the size of the stack.
     * @return An integer representing the stack size.
     */
    int getSize();

    /**
     * Checks if the stack is empty or if it contains values.
     * @return True if empty. Else false
     */
    boolean isEmpty();

    /**
     * Displays the values in the stack.
     */
    String toString();
}