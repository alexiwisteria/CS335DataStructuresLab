package edu.ensign.cs335.assignment3.arrays;

import java.util.Date;

/**
 * Assignment #3: Array iterator assignment
 * Course: cs335
 * This interface declares the functionality to implement in the ArrayIteratorImpl class.
 * Main points to understand:
 *  - Understand that array sizes are static making their use somewhat limited.
 *  - Begin learning about generics in Java.
 *  - Begin to understand that performance will vary with each run and will differ between computers.
 *  - Begin to watch JDK JavaDocs: https://docs.oracle.com/en/java/javase/21/docs/api/index.html
 */
public interface ArrayIterator<T> {

    /**
     * This class receives an array of type T and iterates over it displaying the values contained in it.  The twist with
     * this is that the method will capture the starting time right before it starts iterating over the array and
     * the time it completes iterating over the array.  It will then calculate the difference between the times in
     * nanoseconds and return the nanosecond duration of the time it took to iterate over the array.
     */
    Long iterateOverArray();

    /**
     * Returns the starting time of the iteration over the array.
     * @return java.util.Date representing the start time of the iteration.
     */
    Date getStartTime();

    /**
     * Returns the ending time of the iteration over the array.
     * @return java.util.Date representing the end time of the iteration.
     */
    Date getEndTime();
}