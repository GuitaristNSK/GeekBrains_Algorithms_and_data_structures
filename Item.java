package Lesson_4;

import java.util.Objects;

public class Item <T extends Object> {
    private final T value;
    private Item nextItem;

    public Item(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public Item getNextItem() {
        return nextItem;
    }

    public void setNextItem(Item nextItem) {
        this.nextItem = nextItem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item<?> item = (Item<?>) o;
        return Objects.equals(value, item.value);
    }

    @Override
    public String toString() {
        return "Item{" +
                "value=" + value +
                '}';
    }
}
