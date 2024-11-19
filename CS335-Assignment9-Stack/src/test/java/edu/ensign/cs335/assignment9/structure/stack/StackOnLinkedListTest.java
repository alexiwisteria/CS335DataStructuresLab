package edu.ensign.cs335.assignment9.structure.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * CS 335 Assignment #9 (StackOnLinkedList) Unit Tests
 * NOTE: Please do not modify this file.
 */
public class StackOnLinkedListTest extends Assertions {

    private StackOnLinkedList<String> stringStack;

    /**
     * This method is run before each test.
     */
    @BeforeEach
    public void setup() {
        this.stringStack = new StackOnLinkedListImpl<>();
    }

    /**
     * Tests the isEmpty() method
     */
    @Test
    public void testIsEmpty() {
        assertTrue(this.stringStack.isEmpty());

        this.stringStack.push("Hello");

        assertFalse(this.stringStack.isEmpty());
    }

    /**
     * Tests the push() method.
     */
    @Test
    public void testPush() {
        this.stringStack.push("Tiffani");
        this.stringStack.push("Peter");
        this.stringStack.push("Joe");
        this.stringStack.push("Jack");

        assertEquals(4, this.stringStack.getSize());

        assertEquals("Jack", this.stringStack.peek());
    }

    /**
     * Tests the pop() method.
     */
    @Test
    public void testPop() {
        this.stringStack.push("John");
        this.stringStack.push("Joan");
        this.stringStack.push("Matt");
        this.stringStack.push("Trevor");

        assertEquals(4, this.stringStack.getSize());
        assertEquals("Trevor", this.stringStack.pop());
        assertEquals(3, this.stringStack.getSize());
        assertEquals("Matt", this.stringStack.pop());
        assertEquals(2, this.stringStack.getSize());
        assertEquals("Joan", this.stringStack.pop());
        assertEquals(1, this.stringStack.getSize());
        assertEquals("John", this.stringStack.pop());
        assertEquals(0, this.stringStack.getSize());

        assertThrows(IndexOutOfBoundsException.class, () -> this.stringStack.pop());
    }

    /**
     * Tests the peek() method.
     */
    @Test
    public void testPeek() {
        this.stringStack.push("Alpha");
        assertEquals("Alpha", this.stringStack.peek());

        this.stringStack.push("Beta");
        assertEquals("Beta", this.stringStack.peek());

        this.stringStack.push("Gamma");
        this.stringStack.push("Delta");
        assertEquals("Delta", this.stringStack.peek());

        this.stringStack.pop();
        assertEquals("Gamma", this.stringStack.peek());
    }

    /**
     * Tests the toString() method.
     */
    @Test
    public void testToString() {
        this.stringStack.push("One");
        this.stringStack.push("Two");
        this.stringStack.push("Three");
        this.stringStack.push("Four");
        this.stringStack.push("Five");

        this.stringStack.pop();
        this.stringStack.pop();
        this.stringStack.pop();
        this.stringStack.pop();

        this.stringStack.push("Six");

        assertEquals("Six --> One", this.stringStack.toString());

        this.stringStack.pop();
        this.stringStack.pop();

        assertEquals("StackOnLinkedList is empty.", this.stringStack.toString());
    }
}