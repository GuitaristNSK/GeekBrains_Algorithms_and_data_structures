package Lesson_8.HomeWork;

import Lesson_8.*;

import java.util.LinkedList;

public class HashTableImp implements HashTable {

    private LinkedList[] data;
    private int capacity;
    private int currentSize;

    public HashTableImp(int capacity) {
        this.capacity = capacity * 2;
        this.data = new LinkedList[this.capacity];
        for (int i = 0; i < data.length; i++) {
            data[i] = new LinkedList();
        }
    }

    @Override
    public boolean insert(Item item) {
        int hashValue = hashFunc(item);
        data[hashValue].add(item);
        currentSize++;
        return true;
    }

    @Override
    public boolean remove(Item item) {
        return remove(item.hashCode());
    }

    @Override
    public boolean remove(int id) {
        int hashValue = hashFunc(id);
        Item removedItem = find(id);
        for (Object item : data[hashValue]) {
            if (((Item) item).getId() == id) {
                data[hashValue].remove(removedItem);
                currentSize--;
                return true;
            }
        }
        return false;
    }

    @Override
    public Item find(int id) {
        for (Object item : data[hashFunc(id)]) {
            if (((Item) item).getId() == id) {
                return (Item) item;
            }
        }
        return null;
    }

    @Override
    public int hashFunc(Item item) {
        return hashFunc(item.hashCode());
    }

    private int hashFunc(int itemId) {
        return itemId % capacity;
    }

    @Override
    public int getSize() {
        return currentSize;
    }

    @Override
    public boolean isEmpty() {
        return currentSize == 0;
    }

    @Override
    public void display() {
        for (LinkedList list : data) {
            for (Object item : list) {
                System.out.println(item);
            }
//            System.out.println();
        }
    }
}
