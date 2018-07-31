package Lesson_6;

public class Lesson_6_Main {
    public static void main(String[] args) {
        Tree tree = new TreeImpl();
        addNode(tree, 60);
        addNode(tree, 66);
        addNode(tree, 25);
        addNode(tree, 45);
        addNode(tree, 30);
        addNode(tree, 55);
        addNode(tree, 15);
        addNode(tree, 5);
        addNode(tree, 20);

        tree.remove(30);

        tree.traverse(Tree.TraverseMod.PRE_ORDER);

    }

    private static void addNode(Tree tree, int id) {
        Person person = new Person("Pavel", id, id);
        tree.insert(person);
    }
}
