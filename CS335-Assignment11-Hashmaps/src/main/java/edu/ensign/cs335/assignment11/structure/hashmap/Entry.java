package edu.ensign.cs335.assignment11.structure.hashmap;

/**
 * CS 335 - Assignment #11
 * Represents an entry into the HashMapBucket.
 * @param <K>
 * @param <V>
 */
public class Entry<K, V> {

    private final K key;
    private final V value;

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return this.key;
    }

    public V getValue() {
        return this.value;
    }
}