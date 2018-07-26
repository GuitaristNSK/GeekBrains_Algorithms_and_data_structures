package Lesson_4;

public interface TwoWayLinkedList <T extends Object> extends LinkedList{

    void insertLast(T value);

    T getLastElement();
}
