package Lesson_4;

import java.util.Iterator;

public class LinkedListIterator<T extends Object> implements Iterator<T> {

    private LinkedList list;
    private boolean firstIterate = true;
    private Item current;
    private Item previous;

    public LinkedListIterator(LinkedList list) {
        this.list = list;
    }

    public void reset() {
        current = list.getFirstItem();
        previous = null;
    }

    public boolean isEnd() {
        return (current.getNextItem() == null);
    }

    public Item getCurrent() {
        return current;
    }

    public void insertAfter(T value) {
        Item newItem = new Item(value);
        if (list.isEmpty()) {
            list.insertFirst(newItem);
            current = newItem;
        } else {
            newItem.setNextItem(current.getNextItem());
            current.setNextItem(newItem);
            next();
        }
    }

    public void insertBefore(T value) {
        Item newItem = new Item(value);
        if (previous == null) {
            newItem.setNextItem(list.getFirstItem());
            list.insertFirst(newItem);
            reset();
        } else {
            newItem.setNextItem(previous.getNextItem());
            previous.setNextItem(newItem);
            current = newItem;
        }
    }

    public T deleteCurrent() {
        if (previous == null) {
            list.insertFirst(current.getNextItem());
            reset();
        } else {
            previous.setNextItem(current.getNextItem());
            if (isEnd()) {
                reset();
            } else {
                current = current.getNextItem();
            }
        }
        return (T) current.getValue();
    }

    @Override
    public boolean hasNext() {
        if (firstIterate) {
            firstIterate = false;
            return list.getFirstElement() != null;
        } else {
            return current.getNextItem() != null;
        }
    }

    @Override
    public T next() {
        previous = current;
        if (current == null) {
            current = list.getFirstItem();
        } else {
            current = current.getNextItem();
        }
        return (T) current.getValue();
    }

    @Override
    public void remove() {
        list.remove(current.getValue());
    }
}
