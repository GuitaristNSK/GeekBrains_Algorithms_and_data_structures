package Lesson_8.HomeWork;

import Lesson_8.*;

public class Lesson_8_HomeWork_Main {
    public static void main(String[] args) {
        HashTable hashTable = new HashTableImp(5);
        hashTable.insert(new Item(4, "A-4", 10));
        hashTable.insert(new Item(14, "A-14", 10));
        hashTable.insert(new Item(5, "A-5", 10));
        hashTable.insert(new Item(7, "A-7", 10));
        hashTable.insert(new Item(17, "A-17", 10));
        hashTable.display();
        hashTable.remove(17);
        hashTable.remove(14);
        System.out.println("Removed '14', '17'");
        hashTable.display();
        System.out.println("Find '5': " + hashTable.find(5));
        System.out.println("Size: " + hashTable.getSize());
    }
}
