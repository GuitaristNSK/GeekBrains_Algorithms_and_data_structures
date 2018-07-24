package Lesson_4;

public class TwoWayLinkedListImpl<T extends Object> extends LinkedListImpl implements TwoWayLinkedList {

    protected Item lastElement;

    @Override
    public Object removeFirst() {
        T value = (T) super.removeFirst();
        if (isEmpty()){
            lastElement = null;
        }
        return value;
    }

    @Override
    public void insertFirst(Object value) {
        Item newElement = new Item(value);
        if (isEmpty()) {
            lastElement = newElement;
        }
        newElement.setNextItem(firstElement);
        firstElement = newElement;
        size++;
    }

    @Override
    public void insertLast(Object value) {
        Item newItem = new Item(value);
        if (isEmpty()) {
            firstElement = newItem;
        } else {
            lastElement.setNextItem(newItem);
        }
        lastElement = newItem;
        size++;
    }

    @Override
    public Object getLastElement() {
        return lastElement != null ? lastElement.getValue() : null;
    }
}
