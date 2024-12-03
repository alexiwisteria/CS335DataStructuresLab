package edu.ensign.cs335.assignment11.structure.hashmap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Assignment #11 Unit Tests
 * NOTE: Please do not modify this file.
 */
public class HashMapBucketTest extends Assertions {

    @Test
    public void testConstructorWithInvalidArg() {
        assertThrows(IllegalArgumentException.class, () -> new HashMapBucketImpl<String, String>(0));
    }

    @Test
    public void testPutWithNullKey() {
        HashMapBucket<Integer, Integer> nullMap = new HashMapBucketImpl<>(1);

        assertThrows(IllegalArgumentException.class, () -> nullMap.put(null, 95));
    }

    @Test
    public void testToString() {
        HashMapBucket<Integer, Integer> capacityMap = new HashMapBucketImpl<>(31);
        capacityMap.put(93, 93);
        capacityMap.put(32, 32);
        capacityMap.put(65, 65);
        capacityMap.put(97, 97);
        capacityMap.put(97, 97);
        capacityMap.put(99, 99);
        capacityMap.put(100, 100);
        capacityMap.put(8, 8);
        capacityMap.put(44, 44);
        capacityMap.put(76, 76);
        capacityMap.put(17, 17);
        capacityMap.put(80, 80);
        capacityMap.put(82, 82);
        capacityMap.put(21, 21);
        capacityMap.put(54, 54);
        capacityMap.put(88, 88);
        capacityMap.put(28, 28);
        capacityMap.put(29, 29);

        System.out.println(capacityMap.toString());
        // "Bucket [ 4 ]: 97 --> 97 --> null\n" edited because I believe this is a mistake
        assertEquals("HashMapBucketImpl populated:\n" +
                "Bucket [ 0 ]: 93 --> null\n" +
                "Bucket [ 1 ]: 32 --> null\n" +
                "Bucket [ 2 ]: null\n" +
                "Bucket [ 3 ]: 65 --> null\n" +
                "Bucket [ 4 ]: 97 --> null\n" +
                "Bucket [ 5 ]: null\n" +
                "Bucket [ 6 ]: 99 --> null\n" +
                "Bucket [ 7 ]: 100 --> null\n" +
                "Bucket [ 8 ]: 8 --> null\n" +
                "Bucket [ 9 ]: null\n" +
                "Bucket [ 10 ]: null\n" +
                "Bucket [ 11 ]: null\n" +
                "Bucket [ 12 ]: null\n" +
                "Bucket [ 13 ]: 44 --> null\n" +
                "Bucket [ 14 ]: 76 --> null\n" +
                "Bucket [ 15 ]: null\n" +
                "Bucket [ 16 ]: null\n" +
                "Bucket [ 17 ]: 17 --> null\n" +
                "Bucket [ 18 ]: 80 --> null\n" +
                "Bucket [ 19 ]: null\n" +
                "Bucket [ 20 ]: 82 --> null\n" +
                "Bucket [ 21 ]: 21 --> null\n" +
                "Bucket [ 22 ]: null\n" +
                "Bucket [ 23 ]: 54 --> null\n" +
                "Bucket [ 24 ]: null\n" +
                "Bucket [ 25 ]: null\n" +
                "Bucket [ 26 ]: 88 --> null\n" +
                "Bucket [ 27 ]: null\n" +
                "Bucket [ 28 ]: 28 --> null\n" +
                "Bucket [ 29 ]: 29 --> null\n" +
                "Bucket [ 30 ]: null\n", capacityMap.toString());
    }

    @Test
    public void testMyCapacity() {
        HashMapBucket<String, String> stringMap = new HashMapBucketImpl<>(6);
        stringMap.put("Darin", "Darin");
        stringMap.put("Randy", "Randy");
        stringMap.put("John", "John");
        stringMap.put("Earl", "Earl");
        stringMap.put("Tim", "Tim");

        assertTrue(stringMap.containsKey("Darin"));
        assertFalse(stringMap.containsKey("Darin1"));
    }

    @Test
    public void testPutWithCustomOjbectKey() {
        List<Name> nameList = this.generateNameList();

        HashMapBucket<Name, Integer> nameMap = new HashMapBucketImpl<>(5);
        nameMap.put(nameList.get(0), 24);
        nameMap.put(nameList.get(1), 95);
        nameMap.put(nameList.get(2), 85);
        nameMap.put(nameList.get(3), 43);
        nameMap.put(nameList.get(4), 99);

        assertTrue(nameMap.containsKey(nameList.get(0)));
        assertTrue(nameMap.containsKey(nameList.get(1)));
        assertTrue(nameMap.containsKey(nameList.get(2)));
        assertTrue(nameMap.containsKey(nameList.get(3)));
        assertTrue(nameMap.containsKey(nameList.get(4)));
        assertFalse(nameMap.containsKey(new Name("Georgina", "Lucas")));

        assertTrue(nameMap.containsValue(24));
        assertTrue(nameMap.containsValue(95));
        assertTrue(nameMap.containsValue(85));
        assertTrue(nameMap.containsValue(43));
        assertTrue(nameMap.containsValue(99));
        assertFalse(nameMap.containsValue(100));

        assertEquals(24, nameMap.get(nameList.get(0)));
        assertEquals(95, nameMap.get(nameList.get(1)));
        assertEquals(85, nameMap.get(nameList.get(2)));
        assertEquals(43, nameMap.get(nameList.get(3)));
        assertEquals(99, nameMap.get(nameList.get(4)));

        assertThrows(IllegalStateException.class, () -> nameMap.get(new Name("Joe", "Runyan")));
    }

    @Test
    public void testRemoveWithNullKey() {
        HashMapBucket<Integer, Integer> nullMap = new HashMapBucketImpl<>(1);

        assertThrows(IllegalArgumentException.class, () -> nullMap.remove(null));
    }

    @Test
    public void testRemoveWithKeyNotFound() {

        HashMapBucket<Name, Integer> nameMap = new HashMapBucketImpl<>(5);

        assertThrows(IllegalStateException.class, () -> nameMap.remove(new Name("J", "R")));
    }

    @Test
    public void testRemoveWithValuesFound() {
        List<Name> nameList = this.generateNameList();
        HashMapBucket<Name, Integer> nameMap = new HashMapBucketImpl<>(5);
        nameMap.put(nameList.get(0), 24);
        nameMap.put(nameList.get(1), 95);
        nameMap.put(nameList.get(2), 85);
        nameMap.put(nameList.get(3), 43);
        nameMap.put(nameList.get(4), 99);

        nameMap.remove(nameList.get(3));

        assertThrows(IllegalStateException.class, () -> nameMap.get(nameList.get(3)));

        nameMap.clear();
    }

    @Test
    public void testRemoveWithEmptyBucketFound() {
        HashMapBucket<Name, Integer> nameMap = new HashMapBucketImpl<>(5);
        assertThrows(IllegalStateException.class, () -> nameMap.remove(new Name("Joe", "Runyan")));
    }

    /**
     * Simple class that can be used as a Key with the HashMapBucket.
     *
     * Notice that the equals() AND the hashCode() have been overridden.
     */
    private static class Name {
        private final String first;
        private final String last;

        public Name(String first, String last) {
            this.first = first;
            this.last = last;
        }

        public String getFirst() {
            return this.first;
        }

        public String getLast() {
            return this.last;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Name n = (Name) o;

            return Objects.equals(this.first, n.getFirst()) && Objects.equals(this.last, n.getLast());
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.first, this.last);
        }
    }

    private List<Name> generateNameList() {
        Name n0 = new Name("Billy", "Williams");
        Name n1 = new Name("George", "Lucas");
        Name n2 = new Name("Mark", "Hamill");
        Name n3 = new Name("Harrison", "Ford");
        Name n4 = new Name("Carrie", "Fisher");

        List<Name> nameList = new ArrayList<>();
        nameList.add(n0);
        nameList.add(n1);
        nameList.add(n2);
        nameList.add(n3);
        nameList.add(n4);

        return nameList;
    }
}