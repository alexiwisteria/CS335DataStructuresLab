package edu.ensign.cs335.assignment12.structure.tree;

/**
 * Class: CS335
 * Assignment 12 - BinaryTree
 * Generic interface declaring methods to interact with a Binary Tree implementation.
 * @param <T> The type of object to use.
 *
 * NOTE: There shouldn't be any reason to modify this interface.
 */
public interface BinaryTree<T extends Comparable<T>> {

    /**
     * Adds the element to the Binary Tree.
     * @param t The element to add to the tree.
     */
    void add(T t);

    /**
     * Reads the root node of the tree.
     * @return The node <T> at the root position.  If nothing exists, then it returns null.
     */
    T getRoot();

    /**
     * Removes the node containing the values (t).
     * @param t The value of the node to remove.
     * @return True if element is removed, else false.
     */
    boolean delete(T t);

    /**
     * Locates the node containing the value and returns it, but does not remove it.  Will only return the first
     * node found containing the value.
     * @param t The value of the node sought.
     * @return The BinaryTreeNode containing the value.
     */
    T find(T t);

    /**
     * Creates a String that shows the tree values using pre-order traversal.
     */
    String preOrder();

    /**
     * Creates a String that shows the tree values using in-order traversal.
     */
    String inOrder();

    /**
     * Creates a String that shows the tree values using post-order traversal.
     */
    String postOrder();

    /**
     * Generates a tree in a formal, nice output.
     * @return A String in a formal, nice output.
     */
    String toString();
}