package Lesson_5.HomeWork_5;

import Lesson_2.Array;

import java.util.ArrayList;

public class Backpack {

    protected ArrayList<Item> bestSet = null;

    private int capacity;

    private int bestPrice;

    public Backpack(int capacity) {
        this.capacity = capacity;
    }

    public int calcWeight(ArrayList<Item> items) {
        int sum = 0;
        for (Item i : items) {
            sum += i.weight;
        }
        return sum;
    }

    public int calcPrice(ArrayList<Item> items) {
        int sum = 0;
        for (Item i : items) {
            sum += i.price;
        }
        return sum;
    }

    public void checkSet(ArrayList<Item> items) {
        if (bestSet == null) {
            if (calcWeight(items) <= capacity) {
                bestSet = items;
                bestPrice = calcPrice(items);
            }
        } else {
            if (calcWeight(items) <= capacity && calcPrice(items) > bestPrice) {
                bestSet = items;
                bestPrice = calcPrice(items);
            }
        }
    }

    public void searchBestSet(ArrayList<Item> items) {
        if (items.size() > 0) {
            checkSet(items);
        }
        for (int i = 0; i < items.size(); i++) {
            ArrayList<Item> temp = new ArrayList<>(items);
            temp.remove(i);
            searchBestSet(temp);
        }
    }

}
