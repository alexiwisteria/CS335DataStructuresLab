package edu.ensign.cs335.assignment10.structure.queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Assignment #10 Unit Tests
 * NOTE: Please do not modify this file.
 */
public class QueueOnLinkedListTest extends Assertions {

    private QueueOnLinkedList<String> stringQueue;

    @BeforeEach
    public void setup() {
        this.stringQueue = new QueueOnLinkedListImpl<>();
    }

    @Test
    public void testEnqueue() {
        assertTrue(this.stringQueue.isEmpty());
        this.stringQueue.enqueue("Hello");
        this.stringQueue.enqueue("CS335");
        this.stringQueue.enqueue("World");
        assertEquals(3, this.stringQueue.getSize());

        assertEquals("Hello", this.stringQueue.peekFront());
        assertEquals("World", this.stringQueue.peekLast());
        assertFalse(this.stringQueue.isEmpty());

        this.stringQueue.enqueue(null);
    }

    @Test
    public void testDequeue() {
        this.stringQueue.enqueue("George");
        this.stringQueue.enqueue("Ringo");
        this.stringQueue.enqueue("Paul");
        this.stringQueue.enqueue("John");

        assertEquals(4, this.stringQueue.getSize());
        assertEquals("George", this.stringQueue.dequeue());
        assertEquals(3, this.stringQueue.getSize());
        assertEquals("Ringo", this.stringQueue.dequeue());
        assertEquals(2, this.stringQueue.getSize());
        assertEquals("Paul", this.stringQueue.dequeue());
        assertEquals(1, this.stringQueue.getSize());
        assertEquals("John", this.stringQueue.dequeue());
        assertEquals(0, this.stringQueue.getSize());
        assertTrue(this.stringQueue.isEmpty());

        assertThrows(IllegalStateException.class, () -> this.stringQueue.dequeue());
    }

    @Test
    public void testClear() {
        assertTrue(this.stringQueue.isEmpty());
        this.stringQueue.enqueue("Parker");
        this.stringQueue.enqueue("Lincoln");
        this.stringQueue.enqueue("Rachel");
        assertFalse(this.stringQueue.isEmpty());

        this.stringQueue.clear();
        assertTrue(this.stringQueue.isEmpty());
    }

    @Test
    public void testPeek() {
        this.stringQueue.enqueue("Only");

        assertEquals(this.stringQueue.peekLast(), this.stringQueue.peekFront());

        this.stringQueue.clear();

        assertThrows(IllegalStateException.class, () -> this.stringQueue.peekLast());
        assertThrows(IllegalStateException.class, () -> this.stringQueue.peekFront());
    }

    @Test
    public void testToString() {
        this.stringQueue.enqueue("One");
        this.stringQueue.enqueue("Two");
        this.stringQueue.enqueue("Three");
        this.stringQueue.enqueue("Four");
        this.stringQueue.enqueue("Five");

        this.stringQueue.dequeue();

        System.out.println(this.stringQueue.toString());
        assertEquals("Two --> Three --> Four --> Five", this.stringQueue.toString());
    }
}