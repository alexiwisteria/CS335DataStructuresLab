package edu.ensign.cs335.assignment9.structure.stack;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Implementation of a Stack using a LinkedList as the underlying data structure.
 * This class provides stack operations such as push, pop, peek, and size retrieval.
 *
 * @param <T> the type of elements held in this stack
 */
public class StackOnLinkedListImpl<T> implements StackOnLinkedList<T> {

    /**
     * List to hold the stack elements.
     */
    private List<T> stackList;

    /**
     * Tracks the current size of the stack.
     */
    private int isSize;

    /**
     * Constructs an empty stack.
     */
    public StackOnLinkedListImpl() {
        stackList = new LinkedList<>();
    }

    /**
     * Pushes an element onto the top of the stack.
     *
     * @param o the element to be pushed
     */
    @Override
    public void push(T o) {
        stackList.add(o);
        isSize++;
    }

    /**
     * Removes and returns the element at the top of the stack.
     *
     * @return the element at the top of the stack
     * @throws IndexOutOfBoundsException if the stack is empty
     */
    @Override
    public T pop() {
        if (isSize == 0) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        T lastElement = stackList.get(isSize - 1);
        stackList.remove(isSize - 1);
        isSize--;
        return lastElement;
    }

    /**
     * Retrieves, but does not remove, the element at the top of the stack.
     *
     * @return the element at the top of the stack
     * @throws NoSuchElementException if the stack is empty
     */
    @Override
    public T peek() {
        if (stackList.isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return stackList.get(isSize - 1);
    }

    /**
     * Returns the number of elements in the stack.
     *
     * @return the size of the stack
     */
    @Override
    public int getSize() {
        return isSize;
    }

    /**
     * Checks if the stack is empty.
     *
     * @return {@code true} if the stack is empty; {@code false} otherwise
     */
    @Override
    public boolean isEmpty() {
        return stackList.isEmpty();
    }

    /**
     * Returns a string representation of the stack, showing elements in LIFO order.
     *
     * @return a string representation of the stack, or a message if the stack is empty
     */
    @Override
    public String toString() {
        if (stackList.isEmpty()) {
            return "StackOnLinkedList is empty.";
        }
        StringBuilder stackString = new StringBuilder();
        for (int i = isSize - 1; i >= 0; i--) {
            if (stackString.length() > 0) {
                stackString.append(" --> ");
            }
            stackString.append(stackList.get(i));
        }
        return stackString.toString();
    }
}
