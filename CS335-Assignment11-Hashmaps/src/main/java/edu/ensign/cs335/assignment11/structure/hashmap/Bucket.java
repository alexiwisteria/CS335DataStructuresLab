package edu.ensign.cs335.assignment11.structure.hashmap;

import java.util.ArrayList;
import java.util.List;

/**
 * CS 335 - Assignment #11
 * Represents an entry into the HashMapBucket.
 * @param <K>
 * @param <V>
 */
public class Bucket<K, V> {

    private List<Entry<K,V>> entries;

    public Bucket() {
        this.entries = new ArrayList<>();
    }

    public List<Entry<K, V>> getEntries() {
        return this.entries;
    }
}