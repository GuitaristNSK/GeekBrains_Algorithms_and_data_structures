package Lesson_8;

public interface HashTable {

    boolean insert(Item item);

    boolean remove(Item item);

    boolean remove(int id);

    Item find(int hashValue);

    int hashFunc(Item item);

    int getSize();

    boolean isEmpty();

    void display();
}
