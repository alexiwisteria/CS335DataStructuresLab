package edu.ensign.cs335.assignment8.structure.list;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedListImpl<String> list = new SinglyLinkedListImpl<>();

        // Test isEmpty on an empty list
        System.out.println("List empty? " + list.isEmpty());

        // Insert elements at the tail
        list.insertTail("Apple");
        list.insertTail("Banana");
        list.insertTail("Cherry");
        System.out.println("After inserting 'Apple', 'Banana', 'Cherry' at tail: " + list);

        // Insert elements at the head
        list.insertHead("Avocado");
        System.out.println("After inserting 'Avocado' at head: " + list);

        // Insert element at a specific position
        list.insertNth("Blueberry", 2); // Insert "Blueberry" at index 2
        System.out.println("After inserting 'Blueberry' at index 2: " + list);

        // Test contains method
        System.out.println("List contains 'Banana'? " + list.contains("Banana"));
        System.out.println("List contains 'LingonBerry'? " + list.contains("LingonBerry"));

        // Test getNth method
        System.out.println("Element at index 2: " + list.getNth(2));

        // Test deleteHead and deleteTail
        list.deleteHead();
        System.out.println("After deleting head: " + list);
        list.deleteTail();
        System.out.println("After deleting tail: " + list);

        // Test deleteNth at index 1
        list.deleteNth(1);
        System.out.println("After deleting element at index 1: " + list);

        // Test clear
        list.clear();
        System.out.println("After clearing the list: " + list);
    }
}
