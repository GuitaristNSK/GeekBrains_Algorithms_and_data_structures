package Lesson_6;

public interface Tree {

    enum TraverseMod {
        PRE_ORDER,
        POST_ORDER,
        IN_ORDER,
    }

    boolean insert(Person person);

    boolean remove(int key);

    Person find(int key);

    int getSize();

    boolean isEmpty();

    Person getRoot();

    void traverse(TraverseMod traverseMod);

    Node getNodeRoot();

    void displayTree();
}
