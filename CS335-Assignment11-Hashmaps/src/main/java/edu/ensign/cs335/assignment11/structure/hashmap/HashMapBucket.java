package edu.ensign.cs335.assignment11.structure.hashmap;

/**
 * CS 335 - Assignment #11 - HashMap
 * The interface for declaring methods for HashMapBucket implementation.
 * @param <K>
 * @param <V>
 * NOTE: There is no reason to modify this interface.
 */
public interface HashMapBucket<K, V> {

    /**
     * Inserts the value at the bucket found at the index calculated by using the hashcode of the key argument.
     * @param key The object representing the key.
     * @param value The object representing the value to store.
     */
    void put(K key, V value);

    /**
     * Returns a visual representation of the contents of the HashMapBucket based on the outline shown in the assignment.
     */
    String toString();

    /**
     * Removes the value at the bucket at the index calculated by using the hashcode of the key.  If the bucket is
     * empty, then an IllegalStateException is thrown.  All values that match the key argument are removed.
     * @param key The key used to find the index of the bucket and the specific element(s) to delete.
     */
    void remove(K key);

    /**
     * Locates the bucket index based on the Key value and then looks up the specific Entry and returns it.  If bucket
     * at the given index based on the key is empty, an IllegalStateException is thrown. If no Entry matches the key,
     * then an IllegalStateException is thrown.
     * @param key The key used to find the index of the element to return
     * @return The value found at the key
     */
    V get(K key);

    /**
     * Removes all Entry instances from the Buckets.
     */
    void clear();

    /**
     * Checks if the Key argument exists in the map.  Returns true if it exists, else false.
     * @param key The key to look for.
     * @return True if the key exists, else false.
     */
    boolean containsKey(K key);

    /**
     * Checks if the Value argument exists in the map.  Returns true if it does, else false.
     * @param value The value to look for.
     * @return True if th evalue exists, else false.
     */
    boolean containsValue(V value);
}