package Lesson_6;

public class Node {

    private Node leftChild;
    private Node rightChild;

    private Person person;

    public Node(Person person) {
        this.person = person;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public Person getPerson() {
        return person;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    public int getKey() {
        return person.getId();
    }

    public void display() {
        System.out.println(person);
    }

    public boolean isLeft(int key) {
        return key < getKey();
    }

    public boolean isRight(int key) {
        return !isLeft(key);
    }

    public boolean isLeaf() {
        return leftChild == null && rightChild == null;
    }

    protected boolean deleteChild(Node child) {
        if (leftChild == child) {
            leftChild = null;
            return true;
        } else if (rightChild == child) {
            rightChild = null;
            return true;
        }
        return false;
    }

    public boolean hasOnlyOneChild() {
        return leftChild != null ^ rightChild != null;
    }
}
