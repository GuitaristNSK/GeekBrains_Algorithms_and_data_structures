package Lesson_4;

import Lesson_3.Stack;

public class LinkedListStack implements Stack {

    LinkedList list;

    public LinkedListStack() {
        this.list = new LinkedListImpl();
    }

    @Override
    public Object pop() {
        return list.removeFirst();
    }

    @Override
    public void push(Object value) {
        list.insertFirst(value);
    }

    @Override
    public Object peek() {
        return list.getFirstElement();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean isFull() {
        return false;
    }
}
