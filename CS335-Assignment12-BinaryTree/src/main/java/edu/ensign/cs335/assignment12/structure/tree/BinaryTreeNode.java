package edu.ensign.cs335.assignment12.structure.tree;

/**
 * Class: CS335
 * Assignment 12 - BinaryTree
 * Implementation of a node to be used in the BinaryTreeOnLinkedList assignment.
 * @param <T>
 */
public class BinaryTreeNode<T extends Comparable<T>> {
    private T data;

    private BinaryTreeNode<T> left, right;

    /**
     * Constructor that requires a data element <T> to store in a Binary Tree.
     * @param data
     */
    public BinaryTreeNode(T data) {
        this.data = data;

        this.left = this.right = null;
    }

    /**
     *
     * @return
     */
    public T getData() {
        return this.data;
    }

    /**
     *
     * @param left
     */
    public void setLeft(BinaryTreeNode<T> left) {
        this.left = left;
    }

    /**
     *
     * @param right
     */
    public void setRight(BinaryTreeNode<T> right) {
        this.right = right;
    }

    /**
     *
     * @return
     */
    public BinaryTreeNode<T> getLeft() {
        return this.left;
    }

    /**
     *
     * @return
     */
    public BinaryTreeNode<T> getRight() {
        return this.right;
    }

    /**
     *
     * @param data
     */
    public void setData(T data) {
        this.data = data;
    }
}