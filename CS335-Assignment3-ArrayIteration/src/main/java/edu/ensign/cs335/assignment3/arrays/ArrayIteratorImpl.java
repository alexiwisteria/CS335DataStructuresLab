package edu.ensign.cs335.assignment3.arrays;

import java.time.Instant;
import java.util.Date;
import java.time.Duration;

/**
 * Implementation class for the ArrayIterator interface.
 *
 * This class provides an implementation for the methods required by the
 * ArrayIterator interface, including iterating over an array and tracking
 * the start and end time of the iteration process.
 *
 * @param <T> the type of elements held in this ArrayIterator.
 */
public class ArrayIteratorImpl<T> implements ArrayIterator<T> {

    private T[] array;
    private Date startTime;
    private Date endTime;
    private Long durationNanos;

    /**
     * Constructor for the ArrayIteratorImpl.
     * Initializes the array to iterate over.
     *
     * @param array the array to iterate over.
     * @throws IllegalArgumentException if the provided array is null.
     */
    public ArrayIteratorImpl(T[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array is null");
        }
        this.array = array;
    }

    /**
     * Iterates over the array, prints the elements, and calculates
     * the duration of the iteration process in nanoseconds.
     *
     * This method prints the start time, each element in the array, and the
     * end time of the iteration. It introduces a delay to simulate work
     * and ensure that a measurable duration is captured.
     *
     * @return the duration of the iteration in nanoseconds.
     */
    public Long iterateOverArray() {
        // Capture start time in both Date and nanoseconds
        startTime = new Date();
        long startTimeNano = System.nanoTime();

        // Print start time
        System.out.println("Start Date/Time: " + startTime.toString());

        System.out.println("Elements in the array: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(" -> ");
            }
        }

        System.out.println();

        // Capture end time in both Date and nanoseconds
        endTime = new Date();
        long endTimeNano = System.nanoTime();

        // Calculate the duration in nanoseconds
        durationNanos = endTimeNano - startTimeNano;

        // Print the end time and the duration 
        System.out.println("End Date/Time: " + endTime.toString());
        System.out.println("Duration in nanoseconds: " + durationNanos);

        // Return the precise duration for any other use
        return durationNanos;
    }

    /**
     * Gets the start time of the iteration process.
     *
     * @return the start time of the iteration, or null if iteration has not started.
     */
    @Override
    public Date getStartTime() {
        return startTime;
    }

    /**
     * Gets the end time of the iteration process.
     *
     * @return the end time of the iteration, or null if iteration has not completed.
     */
    @Override
    public Date getEndTime() {
        return endTime;
    }

}
