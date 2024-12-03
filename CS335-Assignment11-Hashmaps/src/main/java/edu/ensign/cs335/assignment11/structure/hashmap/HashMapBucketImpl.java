package edu.ensign.cs335.assignment11.structure.hashmap;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A custom HashMap implementation using a bucket-based design.
 *
 * - The data is stored in buckets, which are essentially containers for key-value pairs.
 * - Provides common operations such as adding, removing, retrieving, and checking for keys/values.
 *
 * This implementation was inspired by the following open-source projects:
 * - rjsah308's implementation of HashMapBucketImpl:
 *   https://github.com/rjsah308/DataStructure/blob/44258c4471a9ccd63d5f3693cce6c5f65f4f1039/HashMapBucket/HashMapBucket/HashMapBucketImpl.java
 * - j-sivertson's implementation of HashMapBucketImpl:
 *   https://github.com/j-sivertson/Data-Structures-and-Algorithms/blob/6caf474810e695e6a3bcb4259a26479785abc5b7/Hashmap/src/main/java/edu/ensign/cs335/assignment11/structure/hashmap/HashMapBucketImpl.java
 *
 * @param <K> The type of keys maintained by this map.
 * @param <V> The type of mapped values.
 */
public class HashMapBucketImpl<K, V> implements HashMapBucket<K, V> {

    // List of buckets to store key-value pairs.
    private final List<Bucket<K, V>> bucketList;

    // Total number of buckets (capacity of the HashMap).
    private final int capacity;

    /**
     * Constructs a new HashMapBucketImpl with the specified capacity.
     *
     * - Creates an empty list of buckets of the given size.
     * - Each bucket is initialized as an empty container for key-value pairs.
     *
     * @param capacity the number of buckets to create in the HashMap.
     * @throws IllegalArgumentException if the capacity is <= 0.
     */
    public HashMapBucketImpl(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than 0");
        }
        this.capacity = capacity;

        // Create the bucket list with the specified capacity
        this.bucketList = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            // Initialize each bucket as an empty bucket
            this.bucketList.add(new Bucket<>());
        }
    }

    /**
     * Adds a key-value pair to the map. If the key already exists, its value is updated.
     *
     * @param key   the key to associate the value with.
     * @param value the value to store.
     * @throws IllegalArgumentException if the key is null.
     */
    @Override
    public void put(K key, V value) {
        validateKey(key); // Ensure the key is valid (not null).

        // Calculate which bucket this key belongs to
        int index = getBucketIndex(key);

        // Fetch the bucket where the key-value pair should be stored
        Bucket<K, V> bucket = bucketList.get(index);

        // Check if the key already exists in the bucket
        for (int i = 0; i < bucket.getEntries().size(); i++) {
            Entry<K, V> entry = bucket.getEntries().get(i);
            if (entry.getKey().equals(key)) {
                // Key exists: update its value
                bucket.getEntries().set(i, new Entry<>(key, value));
                return; // Exit early since the value is updated
            }
        }

        // Key does not exist: add a new key-value pair
        bucket.getEntries().add(new Entry<>(key, value));
    }

    /**
     * Removes a key-value pair from the map based on the given key.
     *
     * @param key the key to remove.
     * @throws IllegalArgumentException if the key is null.
     * @throws IllegalStateException    if the key does not exist in the map.
     */
    @Override
    public void remove(K key) {
        validateKey(key); // Ensure the key is not null.

        // Find the bucket where the key should be
        int index = getBucketIndex(key);
        Bucket<K, V> bucket = bucketList.get(index);

        // Remove the entry for the key if it exists
        boolean removed = bucket.getEntries().removeIf(entry -> entry.getKey().equals(key));

        // If no entry was removed, the key does not exist
        if (!removed) {
            throw new IllegalStateException("No entry found for the given key");
        }
    }

    /**
     * Retrieves the value associated with a given key.
     *
     * @param key the key to look up.
     * @return the value associated with the key.
     * @throws IllegalArgumentException if the key is null.
     * @throws IllegalStateException    if the key is not found.
     */
    @Override
    public V get(K key) {
        validateKey(key); // Ensure the key is valid.

        // Find the bucket that may contain the key
        int index = getBucketIndex(key);
        Bucket<K, V> bucket = bucketList.get(index);

        // Search for the key in the bucket
        return bucket.getEntries().stream()
                .filter(entry -> entry.getKey().equals(key))
                .findFirst() // Get the first matching entry
                .orElseThrow(() -> new IllegalStateException("No entry found for the given key"))
                .getValue(); // Return the value from the entry
    }

    /**
     * Checks if the map contains a specific key.
     *
     * @param key the key to check for.
     * @return true if the key exists, false otherwise.
     * @throws IllegalArgumentException if the key is null.
     */
    @Override
    public boolean containsKey(K key) {
        validateKey(key); // Ensure the key is valid.

        // Find the bucket that may contain the key
        int index = getBucketIndex(key);
        return bucketList.get(index).getEntries().stream()
                .anyMatch(entry -> entry.getKey().equals(key)); // Check for key existence
    }

    /**
     * Checks if the map contains one or more entries with the specified value.
     *
     * @param value the value to check for.
     * @return true if the value exists, false otherwise.
     */
    @Override
    public boolean containsValue(V value) {
        // Check all buckets for an entry with the given value
        return bucketList.stream()
                .flatMap(bucket -> bucket.getEntries().stream()) // Access all entries in all buckets
                .anyMatch(entry -> Objects.equals(entry.getValue(), value));
    }

    /**
     * Clears the entire map, removing all key-value pairs.
     */
    @Override
    public void clear() {
        // Clear each bucket in the map
        bucketList.forEach(bucket -> bucket.getEntries().clear());
    }

    /**
     * Generates a string representation of the HashMap, displaying its key-value pairs organized by buckets.
     * Each bucket is listed with its index, followed by the keys it contains. Keys are displayed in the order
     * they were added, with each key followed by " --> ". Empty buckets are represented by "null".
     *
     * This format provides a clear visualization of how keys are distributed across buckets
     * and helps in understanding the internal structure of the HashMap.
     *
     * @return a string representation of the HashMap, grouped by buckets.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("HashMapBucketImpl populated:\n");
        for (int i = 0; i < bucketList.size(); i++) {
            sb.append("Bucket [ ").append(i).append(" ]: ");
            if (bucketList.get(i).getEntries().isEmpty()) {
                sb.append("null");
            } else {
                bucketList.get(i).getEntries().forEach(entry -> {
                    // Append the key for each entry, including duplicates
                    sb.append(entry.getKey()).append(" --> ");
                });
                sb.append("null");
            }
            sb.append("\n");
        }
        return sb.toString();
    }


    /**
     * Computes the bucket index for a given key using the hash code.
     *
     * @param key the key to compute the index for.
     * @return the index of the bucket where the key belongs.
     */
    private int getBucketIndex(K key) {
        // Use the hash code of the key and map it to a valid bucket index
        return Math.abs(key.hashCode() % capacity);
    }

    /**
     * Validates that a key is not null.
     *
     * @param key the key to validate.
     * @throws IllegalArgumentException if the key is null.
     */
    private void validateKey(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
    }
}
