package edu.ensign.cs335.assignment12.structure.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BinaryTreeTest extends Assertions {

    private BinaryTree<Integer> binaryTree;

    @BeforeEach
    public void setup() {
        this.binaryTree = new BinaryTreeImpl<>();
    }

    @Test
    public void testGetRootWithNullRoot() {
        assertNull(this.binaryTree.getRoot());
    }

    @Test
    public void testGetRoot() {
        this.populateBinaryTree();
        assertEquals(44, this.binaryTree.getRoot());
    }

    @Test
    public void testDeleteElementFromEmptyTree() {
        assertFalse(this.binaryTree.delete(99));
    }

    @Test
    public void testDeleteExistingElement() {
        this.populateBinaryTree();

        assertTrue(this.binaryTree.delete(97));
        assertTrue(this.binaryTree.delete(97));
        assertTrue(this.binaryTree.delete(21));
    }

    @Test
    public void testDeleteNonExistentElement() {
        this.populateBinaryTree();

        assertFalse(this.binaryTree.delete(85));
        assertFalse(this.binaryTree.delete(1));
    }

    @Test
    public void testDeleteRootElement() {
        this.populateBinaryTree();

        assertTrue(this.binaryTree.delete(44));
        assertEquals(54, this.binaryTree.getRoot());
    }

    @Test
    public void testDeleteElementWithTwoChildrenNodes() {
        this.populateBinaryTree();

        assertTrue(this.binaryTree.delete(65));
        assertFalse(this.binaryTree.delete(65));
    }

    @Test
    public void testPreOrderTraversal() {
        assertEquals("", this.binaryTree.preOrder());

        this.populateBinaryTree();
        assertEquals("44 17 8 32 28 21 29 88 65 54 82 76 80 97 93 93 97 99 ", this.binaryTree.preOrder());
        System.out.println("Pre-order Traversal: " + this.binaryTree.preOrder());
    }

    @Test
    public void testInOrderTraversal() {
        assertEquals("", this.binaryTree.inOrder());

        this.populateBinaryTree();
        assertEquals("8 17 21 28 29 32 44 54 65 76 80 82 88 93 93 97 97 99 ", this.binaryTree.inOrder());
        System.out.println("Pre-order Traversal: " + this.binaryTree.inOrder());
    }

    @Test
    public void testPostOrderTraversal() {
        assertEquals("", this.binaryTree.postOrder());

        this.populateBinaryTree();
        assertEquals("8 21 29 28 32 17 54 80 76 82 65 93 93 99 97 97 88 44", this.binaryTree.postOrder());
        System.out.println("Pre-order Traversal: " + this.binaryTree.postOrder());
    }

    @Test
    public void testFindWithNonexistentValue() {
        this.populateBinaryTree();
        assertNull(this.binaryTree.find(4));
        assertEquals(8, this.binaryTree.find(8));
        assertEquals(97, this.binaryTree.find(97));
    }

    @Test
    public void testToString() {
        assertEquals("", this.binaryTree.toString());

        this.populateBinaryTree();
        String result = "                                                                                               44                                                                                               \n" +
                "                                                ┌───────────────────────────────────────────────┴───────────────────────────────────────────────┐                                               \n" +
                "                                               17                                                                                              93                                               \n" +
                "                        ┌───────────────────────┴───────────────────────┐                                               ┌───────────────────────┴───────────────────────┐                       \n" +
                "                        8                                              32                                              65                                              97                       \n" +
                "                                                            ┌───────────┘                                   ┌───────────┴───────────┐                       ┌───────────┴───────────┐           \n" +
                "                                                           28                                              54                      82                      93                      97           \n" +
                "                                                      ┌─────┴─────┐                                                           ┌─────┘                                               └─────┐     \n" +
                "                                                     21          29                                                          76                                                          99     \n" +
                "                                                                                                                              └──┐                                                              \n" +
                "                                                                                                                                80                                                              \n";
        this.binaryTree.delete(88);
        System.out.println("toString(): \n"  + this.binaryTree.toString());
        assertEquals(result, this.binaryTree.toString());
    }

    private void populateBinaryTree() {
        this.binaryTree.add(44);
        this.binaryTree.add(17);
        this.binaryTree.add(88);
        this.binaryTree.add(8);
        this.binaryTree.add(32);
        this.binaryTree.add(65);
        this.binaryTree.add(97);
        this.binaryTree.add(28);
        this.binaryTree.add(21);
        this.binaryTree.add(29);
        this.binaryTree.add(54);
        this.binaryTree.add(82);
        this.binaryTree.add(76);
        this.binaryTree.add(80);
        this.binaryTree.add(97);
        this.binaryTree.add(93);
        this.binaryTree.add(93);
        this.binaryTree.add(99);
    }
}