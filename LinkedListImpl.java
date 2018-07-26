package Lesson_4;

import java.util.Iterator;

public class LinkedListImpl<T extends Object> implements LinkedList {
    protected Item firstElement;
    protected int size = 0;

    @Override
    public Object getFirstElement() {
        return firstElement != null ? firstElement.getValue() : null;
    }

    @Override
    public Object removeFirst() {
        if (firstElement == null) {
            throw new IllegalCallerException("Нельзя удалять из пустого списка!");
        }
        T value = (T) firstElement.getValue();
        Item nextItem = firstElement.getNextItem();
        firstElement.setNextItem(nextItem);
        firstElement = nextItem;
        size--;
        return value;
    }

    @Override
    public void insertFirst(Object value) {
        Item newElement = new Item(value);
        if (isEmpty()) {
            firstElement = newElement;
        } else {
            newElement.setNextItem(firstElement);
            firstElement = newElement;
        }
        size++;
    }

    @Override
    public boolean isEmpty() {
        return firstElement == null;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void display() {
        Item currentElement = firstElement;
        while (currentElement != null) {
            System.out.println(currentElement);
            currentElement = currentElement.getNextItem();
        }
    }

    @Override
    public boolean find(int value) {
        Item currentItem = firstElement;
        while (currentItem != null) {
            if (currentItem.getValue().equals(value)) {
                return true;
            }
            currentItem = currentItem.getNextItem();
        }
        return false;
    }

    @Override
    public boolean remove(Object value) {
        Item currentItem = firstElement;
        Item previousItem = null;
        while (currentItem != null) {
            if (currentItem.getValue().equals(value)) {
                break;
            }
            previousItem = currentItem;
            currentItem = currentItem.getNextItem();
        }
        if (currentItem == null) {
            return false;
        }
        if (currentItem == firstElement) {
            firstElement = currentItem.getNextItem();
        } else {
            Item nextItem = currentItem.getNextItem();
            previousItem.setNextItem(nextItem);
        }
        return true;
    }

    @Override
    public Item getFirstItem() {
        return firstElement;
    }

    @Override
    public Iterator iterator() {
        return new LinkedListIterator(this);
    }
}
