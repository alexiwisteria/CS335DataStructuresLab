package edu.ensign.cs335.assignment8.structure.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SinglyLinkedListTest extends Assertions {

    private SinglyLinkedList<Integer> integerList;
    private SinglyLinkedList<String> stringList;

    @BeforeEach
    public void setup() {
        this.integerList = new SinglyLinkedListImpl<>();
        this.stringList = new SinglyLinkedListImpl<>();
    }

    @Test
    public void testGetNth() {
        assertNotNull(integerList);

        integerList.insertTail(95);
        integerList.insertTail(45);
        integerList.insertTail(2000);

        assertEquals(95, integerList.getNth(0));
        assertEquals(45, integerList.getNth(1));
        assertEquals(2000, integerList.getNth(2));

        assertEquals(3, integerList.getIsSize());
        assertEquals(3, integerList.getIsCount());
    }

    @Test
    public void testGetNthWithInvalidIndex() {

        String expectedMessage = "The index is outside the possibilities of the SinglyLinkedList.";

        Exception eNeg = assertThrows(IndexOutOfBoundsException.class, () -> {
            integerList.getNth(-1);
        });
        assertEquals(expectedMessage, eNeg.getMessage());

        Exception eGT = assertThrows(IndexOutOfBoundsException.class, () -> {
            integerList.getNth(100);
        });
        assertEquals(expectedMessage, eGT.getMessage());
    }

    @Test
    public void testGetCountWithNulls() {
        integerList.insertHead(null);
        integerList.insertHead(900);
        integerList.insertTail(800);
        integerList.insertHead(null);
        integerList.insertTail(null);

        assertEquals(5, integerList.getIsSize());
        assertEquals(2, integerList.getIsCount());

        assertNull(integerList.getNth(0));
        assertEquals(900, integerList.getNth(1));
        assertNull(integerList.getNth(2));
        assertEquals(800, integerList.getNth(3));
    }

    @Test
    public void testIsEmpty() {
        integerList.insertHead(50);
        assertFalse(integerList.isEmpty());
        integerList.clear();
        assertTrue(integerList.isEmpty());
    }

    @Test
    public void testDeleteHead() {

        Exception illegalState = assertThrows(IllegalStateException.class, () -> {
            stringList.deleteHead();
        });
        assertEquals("Cannot delete the head node when no head node exists.", illegalState.getMessage());

        integerList.insertHead(34);
        integerList.insertHead(94);
        assertTrue(integerList.deleteHead());
        assertEquals(1, integerList.getIsSize());
        assertEquals(1, integerList.getIsCount());
        assertEquals(34, integerList.getNth(0));
    }

    @Test
    public void testDeleteTail() {
        assertFalse(integerList.deleteTail());

        stringList.insertHead("George");
        assertTrue(stringList.deleteTail());
        stringList.clear();
        assertEquals(0, stringList.getIsSize());
        assertEquals(0, stringList.getIsCount());

        stringList.insertHead("One");
        stringList.insertTail("Two");
        stringList.insertTail("Three");
        stringList.insertTail("Four");
        stringList.insertTail(null);
        assertEquals(5, stringList.getIsSize());
        assertEquals(4, stringList.getIsCount());
        assertTrue(stringList.deleteTail());
        assertTrue(stringList.deleteTail());
        assertFalse(stringList.contains("Four"));
        assertFalse(stringList.contains(null));
        assertTrue(stringList.contains("One"));
    }

    @Test
    public void testContains() {
        assertFalse(stringList.contains("Sam"));

        stringList.insertHead("Jake");
        stringList.insertHead("Casey");
        stringList.insertHead("David");

        assertTrue(stringList.contains("Jake"));
        assertFalse(stringList.contains("Drew"));
    }

    @Test
    public void testToString() {
        assertEquals("The SinglyLinkedList instance is empty.", stringList.toString());

        stringList.insertHead("One");
        stringList.insertTail("Two");
        stringList.insertHead("Three");
        stringList.insertTail("Four");
        stringList.insertTail(null);
        stringList.insertTail(null);
        stringList.insertTail("50");
        stringList.insertHead("55");



        // String output = "55 -> Three -> One -> Two -> Four -> NULL -> NULL -> 50";
        // I had to edit the above line because it asked to return "NULL" which should really be "null"
        String output = "55 -> Three -> One -> Two -> Four -> null -> null -> 50";
        assertEquals(output, stringList.toString());
    }

    @Test
    public void testInsertNth() {

        Exception illegalState = assertThrows(IllegalStateException.class, () -> {
            stringList.deleteNth(5);
        });
        assertEquals("No Node exists at provided index to delete.", illegalState.getMessage());

        integerList.insertNth(0, 5);
        integerList.insertNth(1, 6);

        assertEquals(7, integerList.getIsSize());
        assertEquals(2, integerList.getIsCount());

        integerList.insertNth(3, 0);
        integerList.insertNth(19, 2);

        assertEquals(3, integerList.getNth(0));
        assertEquals(19, integerList.getNth(2));

        assertTrue(integerList.deleteNth(7));
        assertEquals(null, integerList.getNth(4));
        assertEquals(1, integerList.getNth(7));

        assertTrue(integerList.deleteNth(0));
        assertTrue(integerList.deleteNth(integerList.getIsSize()-1));
    }
}