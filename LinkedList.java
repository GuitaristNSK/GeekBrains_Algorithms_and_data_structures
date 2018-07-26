package Lesson_4;

public interface LinkedList<T extends Object> extends Iterable<T>{

    T removeFirst();

    void insertFirst(T value);

    boolean isEmpty();

    int getSize();

    void display();

    T getFirstElement();

    Item getFirstItem();

    boolean find(int value);

    boolean remove(T value);
}
