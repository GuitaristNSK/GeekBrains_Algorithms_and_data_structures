package Lesson_4;

import Lesson_3.Queue;

public class LinkedListQueue <T extends Object> implements Queue {

    private TwoWayLinkedList linkedList;

    public LinkedListQueue() {
        this.linkedList = new TwoWayLinkedListImpl();
    }

    @Override
    public void insertLast(Object value) {
        linkedList.insertLast(value);
    }

    @Override
    public Object removeFirst() {
        return linkedList.removeFirst();
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public boolean isFull() {
        return false;
    }
}
