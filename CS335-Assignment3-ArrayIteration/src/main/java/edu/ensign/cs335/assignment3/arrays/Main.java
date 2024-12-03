package edu.ensign.cs335.assignment3.arrays;

/**
 * Main class to demonstrate how to iterate over different types of arrays using ArrayIteratorImpl.
 * This class includes examples with String, Integer, Double, and Person arrays.
 */
public class Main {
    /**
     * The main method where the program execution starts.
     * It creates arrays of different types (String, Integer, Double, Person)
     * and uses ArrayIteratorImpl to iterate over them.
     *
     * @param args Command-line arguments (not used in this program).
     */
    public static void main(String[] args) {

        // String array example
        String[] stringArray = {"Hello", "World", "This", "Is", "Java"};
        ArrayIteratorImpl<String> stringArrayIterator = new ArrayIteratorImpl<>(stringArray);
        stringArrayIterator.iterateOverArray();

        System.out.println();

        // Integer array example
        Integer[] intArray = {1, 2, 3, 4, 5};
        ArrayIteratorImpl<Integer> intArrayIterator = new ArrayIteratorImpl<>(intArray);
        intArrayIterator.iterateOverArray();

        System.out.println();

        // Double array example
        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4, 5.5};
        ArrayIteratorImpl<Double> doubleArrayIterator = new ArrayIteratorImpl<>(doubleArray);
        doubleArrayIterator.iterateOverArray();

        System.out.println();

        // Person array example
        Person[] personArray = {
                new Person("Alice", 25),
                new Person("Bob", 30),
                new Person("Charlie", 22)
        };
        ArrayIteratorImpl<Person> personArrayIterator = new ArrayIteratorImpl<>(personArray);
        personArrayIterator.iterateOverArray();
    }
}

/**
 * The Person class represents a person with a name and an age.
 * It provides a custom toString() method to display the person's name and age in a readable format.
 */
class Person {
    private String name;
    private int age;

    /**
     * Constructor for the Person class.
     * It creates a Person object with a given name and age.
     *
     * @param name The name of the person.
     * @param age  The age of the person.
     */
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Returns a string representation of the person, showing their name and age.
     * This method is called automatically when the object is printed or converted to a string.
     *
     * @return A string in the format "Name (Age years old)".
     */
    @Override
    public String toString() {
        return name + " (" + age + " years old)";
    }
}
