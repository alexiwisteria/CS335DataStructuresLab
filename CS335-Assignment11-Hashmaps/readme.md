<h1>Assignment #11 - HashMap with Buckets</h1>
<h2>Introduction</h2>
This assignment is to implement a HashMap that allows for a defined number of buckets where multiple values can be
entered.

This assignment will utilize the following components:

- Generics
- LinkedList class
- List interface

<h2>Assignment</h2>

Your assignment will be to implement the following methods for the HashMapBucket implementation class:

    void put(K key, V value)

    void remove(K key)

    V get(K key)

    void clear()

    boolean containsKey(K key)

    boolean containsValue(V value)

    String toString()

You will need to ensure the unit tests pass (NOTE: Unit tests are already implemented.)

<b>NOTE:</b> You should only have to modify the HashMapBucketImpl.java file.

<h2>Deliverables</h2>
Once you have successfully complete your code (it must both compile and pass the unit tests), run the following:

mvn clean

and upload your file to Canvas.

The <b>goal</b> of this assignment is two-fold:

<b>
1 - Understand how to implement the HashMap with buckets.<br/>
2 - Understand the idea that any class can be used as a Key in a HashMap. 
</b>

The algorithm for calculating the index of the position is as follows:

<b>Math.abs(key.hashCode()) % this.bucketList.size()</b>

<b>NOTE:</b> Don't forget to include your JavaDocs for the public classes and methods.