package Lesson_5.HomeWork_5;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        System.out.println(homeWorkTask1(2, 3));
        System.out.println(homeWorkTask1(2, -3));
        System.out.println(homeWorkTask1(2, 0));

        homeWorkTask2(7);
    }

    public static double homeWorkTask1(double number, int power) {
        if (power > 0) {
            return number * homeWorkTask1(number, --power);
        }
        if (power < 0) {
            return 1 / homeWorkTask1(number, power * -1);
        }
        return 1;
    }

    public static void homeWorkTask2(int capacity) {
        ArrayList<Item> items = new ArrayList<>();

        items.add(new Item("iPhone", 1, 30000));
        items.add(new Item("Книга", 2, 2000));
        items.add(new Item("Гитара", 4, 50000));
        items.add(new Item("Ноутбук", 2, 40000));
        items.add(new Item("PS4", 3, 20000));

        System.out.println("Исходный набор: ");
        show(items);

        Backpack backpack = new Backpack(capacity);

        backpack.searchBestSet(items);

        ArrayList<Item> result = backpack.bestSet;

        if (result == null) {
            System.out.println("Нет решения!");
        } else {
            System.out.println("Лучший набор: ");
            show(result);
        }
    }

    public static void show(ArrayList<Item> items) {
        for (Item i : items) {
            i.print();
        }
    }
}
