<h1>Assignment #12 - Binary Tree</h1>
<h2>Introduction</h2>
This assignment is to implement a Binary Tree data structure that allows for a defined number of buckets where multiple 
values can be entered.

This assignment will utilize the following components:

- Generics
- Linked List
- List interface
- Recursion

<h2>Assignment</h2>

Your assignment will be to implement the following methods for the BinaryTree implementation class:

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

You will need to ensure the unit tests pass (NOTE: Unit tests are already implemented.)

<b>NOTE:</b> You should only have to modify the BinaryTreeImpl.java file.

<h2>Deliverables</h2>
Once you have successfully complete your code (it must both compile and pass the unit tests), run the following:

mvn clean

The <b>goal</b> of this assignment is two-fold:

<b>
Understand how to implement the Binary Tree.<br/>
The shapes for displaying the tree are here:<br/>
"─"<br/>
"┌"<br/>
"┐"<br/>
"─"<br/>
'┴'<br/>
'┘'<br/>
'└'
</b>

Be sure to fill out the below information:

Name: Alexis Binch
<br/>
Class: CS 335


<b>NOTE:</b> Don't forget to include your JavaDocs for the public classes and methods.
<br/>
