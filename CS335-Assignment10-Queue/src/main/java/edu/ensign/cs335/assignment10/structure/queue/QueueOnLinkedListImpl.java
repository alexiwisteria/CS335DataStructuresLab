package edu.ensign.cs335.assignment10.structure.queue;

import java.util.LinkedList;
import java.util.List;

/**
 * Implementation of the QueueOnLinkedList interface using a {@link LinkedList}.
 * This generic class provides standard queue operations such as enqueue, dequeue,
 * and peek, while maintaining elements in a First-In-First-Out (FIFO) order.
 *
 * @param <T> the type of elements held in this queue
 * @author Alexis Binch
 * @version 1.0
 */
public class QueueOnLinkedListImpl<T> implements QueueOnLinkedList<T> {

    /**
     * The internal list representing the queue structure.
     */
    private final List<T> queueList;

    /**
     * Constructs an empty queue.
     */
    public QueueOnLinkedListImpl() {
        this.queueList = new LinkedList<>();
    }

    /**
     * Checks if the queue is empty.
     *
     * @return true if the queue is empty; false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return queueList.isEmpty();
    }

    /**
     * Returns the size of the queue.
     *
     * @return the number of elements in the queue
     */
    @Override
    public int getSize() {
        return queueList.size();
    }

    /**
     * Clears all elements from the queue.
     */
    @Override
    public void clear() {
        queueList.clear();
    }

    /**
     * Adds an element to the end of the queue.
     *
     * @param o the element to be added
     */
    @Override
    public void enqueue(T o) {
        queueList.add(o);
    }

    /**
     * Removes and returns the element at the front of the queue.
     *
     * @return the element at the front of the queue
     * @throws IllegalStateException if the queue is empty
     */
    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return queueList.remove(0);
    }

    /**
     * Returns the element at the front of the queue without removing it.
     *
     * @return the element at the front of the queue
     * @throws IllegalStateException if the queue is empty
     */
    @Override
    public T peekFront() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return queueList.get(0);
    }

    /**
     * Returns the element at the end of the queue without removing it.
     *
     * @return the element at the end of the queue
     * @throws IllegalStateException if the queue is empty
     */
    @Override
    public T peekLast() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return queueList.get(queueList.size() - 1);
    }

    /**
     * Returns a string representation of the queue, showing all elements in FIFO order.
     *
     * @return a string representation of the queue; "Queue is empty" if the queue has no elements
     */
    @Override
    public String toString() {
        if (queueList.isEmpty()) {
            return "Queue is empty";
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < queueList.size(); i++) {
            result.append(queueList.get(i));
            if (i < queueList.size() - 1) {
                result.append(" --> ");
            }
        }
        return result.toString();
    }
}
