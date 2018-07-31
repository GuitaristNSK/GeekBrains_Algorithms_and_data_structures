package Lesson_5.HomeWork_5;

public class Item {
    protected String name;
    protected int weight;
    protected int price;

    public Item(String name, int weight, int price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    public void print() {
        System.out.format("Item: %8s" + "; Weight: %1d" + "; Price: %6d\n", name, weight, price);
    }
}
