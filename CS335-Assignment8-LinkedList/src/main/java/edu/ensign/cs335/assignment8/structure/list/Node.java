package edu.ensign.cs335.assignment8.structure.list;

/**
 * Node class.  This defines the separate elements linked together in the SinglyLinkedList
 * @param <T>
 */
public class Node<T> {

    private T data;
    private Node<T> next;

    Node(T data) {
        this.data = data;
        this.next = null;
    }

    public T getData() {
        return data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}
