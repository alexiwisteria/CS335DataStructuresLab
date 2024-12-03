package edu.ensign.cs335.assignment3.arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

/**
 * Unit tests for the ArrayIterator assignment (Assignment #3 for CS 335)
 *
 * NOTE: DO NOT MODIFY ANYTHING WITHIN THIS FILE.
 */
public class ArrayIteratorImplTest extends Assertions {

    private ArrayIterator<Integer> arrayIterator;

    public ArrayIteratorImplTest() {
        this.arrayIterator = new ArrayIteratorImpl<>(this.generateRandomIntegers(122));
    }

    @Test
    public void testConstructorWithIllegalArgument() {
        assertThrows(IllegalArgumentException.class, () -> new ArrayIteratorImpl(null));
    }

    @Test
    public void testIterateOverArray() {
        assertNotNull(this.arrayIterator) ;
        assertTrue(this.arrayIterator.iterateOverArray() > 100);

        assertNotNull(this.arrayIterator.getStartTime());
        assertNotNull(this.arrayIterator.getEndTime());

        assertTrue(this.arrayIterator.getStartTime().getTime() > 0);
        assertTrue(this.arrayIterator.getEndTime().getTime() > 0);
    }

    private Integer[] generateRandomIntegers(int count) {

        Integer[] integers = new Integer[count];
        Random rand = new Random();

        for (int i = 0; i < count; i++) {
            integers[i] = rand.nextInt((1000));
        }

        return integers;
    }
}