package Lesson_6;

import java.util.Stack;

public class TreeImpl implements Tree {

    private Node root;
    private int currentSize;

    private class RemovedElementAndParent {
        Node removedElement;
        Node parent;
    }

    @Override
    public boolean insert(Person person) {
        Node newNode = new Node(person);
        int key = newNode.getKey();
        Node parent = findParentForInsert(key);
        if (parent == null) {
            root = newNode;
        } else if (parent.getKey() == person.getId()) {
            return false;
        } else {
            if (parent.isLeft(key)) {
                parent.setLeftChild(newNode);
            } else {
                parent.setRightChild(newNode);
            }
        }

        currentSize++;
        return true;
    }

    @Override
    public boolean remove(int key) {
        RemovedElementAndParent elementAndParent = findRemovedElementAndParent(key);
        if (elementAndParent.removedElement == null) return false;
        Node removedNode = elementAndParent.removedElement;
        Node parent = elementAndParent.parent;
        if (removedNode.isLeaf()) {
            removeLeafNode(removedNode, parent);
        } else if (removedNode.hasOnlyOneChild()) {
            removeNodeWithOnlyOneChild(removedNode, parent);
        } else {
            removeNodeWithBothChild(removedNode, parent);
        }
        currentSize--;
        return true;
    }

    private void removeNodeWithBothChild(Node removedNode, Node parent) {
        Node succesor = getSuccessor(removedNode);
        if (removedNode == root) root = succesor;
        else if (parent.getLeftChild() == removedNode) {
            parent.setLeftChild(succesor);
        } else {
            parent.setRightChild(succesor);
        }
        succesor.setLeftChild(removedNode.getLeftChild());
        if (succesor != removedNode.getRightChild()) {
            succesor.setRightChild(removedNode.getRightChild());
        }
    }

    private void removeNodeWithOnlyOneChild(Node removedNode, Node parent) {
        Node removeChildNode = getSingleChildNode(removedNode);
        if (removedNode == root) root = removeChildNode;
        else if (parent.getLeftChild() == removedNode) {
            parent.setLeftChild(removeChildNode);
        } else {
            parent.setRightChild(removeChildNode);
        }
    }

    private Node getSingleChildNode(Node removedNode) {
        return removedNode.getLeftChild() != null ? removedNode.getLeftChild() : removedNode.getRightChild();
    }

    private void removeLeafNode(Node removedNode, Node parent) {
        if (removedNode == root) {
            root = null;
        } else {
            parent.deleteChild(removedNode);
        }
    }

    private RemovedElementAndParent findRemovedElementAndParent(int key) {
        RemovedElementAndParent elementAndParent = new RemovedElementAndParent();
        elementAndParent.removedElement = root;
        elementAndParent.parent = null;

        while (elementAndParent.removedElement != null) {
            if (elementAndParent.removedElement.getKey() == key) {
                break;
            }
            elementAndParent.parent = elementAndParent.removedElement;
            if (elementAndParent.removedElement.isRight(key)) {
                elementAndParent.removedElement = elementAndParent.removedElement.getRightChild();
            } else {
                elementAndParent.removedElement = elementAndParent.removedElement.getLeftChild();
            }
        }
        return elementAndParent;
    }

    private Node getSuccessor(Node node) {
        Node successorParent = null;
        Node successor = node;
        Node current = node.getRightChild();
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.getRightChild();
        }
        if (successor != node.getRightChild()) {
            successorParent.setLeftChild(successor.getRightChild());
        }
        return successor;
    }

    @Override
    public Person find(int key) {
        Node currentNode = root;
        while (currentNode != null) {
            if (currentNode.isRight(key))
                return currentNode.getPerson();
            if (key > currentNode.getKey())
                currentNode = currentNode.getRightChild();
            else currentNode = currentNode.getLeftChild();
        }
        return null;
    }

    @Override
    public int getSize() {
        return currentSize;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public Person getRoot() {
        return root.getPerson();
    }

    Node findParentForInsert(int key) {
        Node currentNode = root;
        Node parent = null;
        RemovedElementAndParent elementAndParent = new RemovedElementAndParent();
        elementAndParent.removedElement = currentNode;
        elementAndParent.parent = parent;

        while (currentNode != null) {
            parent = currentNode;
            if (currentNode.isRight(key)) {
                currentNode = currentNode.getRightChild();
            } else currentNode = currentNode.getLeftChild();
        }
        return parent;
    }

    @Override
    public void traverse(TraverseMod traverseMod) {
        switch (traverseMod) {
            case PRE_ORDER:
                preOrder(root);
                break;
            case POST_ORDER:
                postOrder(root);
                break;
            case IN_ORDER:
                inOrder(root);
                break;
            default:
                throw new IllegalArgumentException("Unknown traverse mod");
        }
    }

    private void preOrder(Node node) {
        if (node != null) {
            node.display();
            preOrder(node.getLeftChild());
            preOrder(node.getRightChild());
        }
    }

    private void postOrder(Node node) {
        if (node != null) {
            preOrder(node.getLeftChild());
            preOrder(node.getRightChild());
            node.display();
        }
    }

    private void inOrder(Node node) {
        if (node != null) {
            preOrder(node.getLeftChild());
            node.display();
            preOrder(node.getRightChild());
        }
    }

    @Override
    public Node getNodeRoot() {
        return root;
    }

    @Override
    public void displayTree() {
        Stack<Node> globalStack = new Stack();
        globalStack.push(root);
        int nBlanks = 64;

        boolean isRowEmpty = false;
        System.out.println("................................................................");

        while (!isRowEmpty) {
            Stack<Node> localStack = new Stack<>();

            isRowEmpty = true;
            for (int i = 0; i < nBlanks; i++) {
                System.out.print(" ");
            }

            while (!globalStack.isEmpty()) {
                Node tempNode = globalStack.pop();
                if (tempNode != null) {
                    System.out.print(tempNode.getKey());
                    localStack.push(tempNode.getLeftChild());
                    localStack.push(tempNode.getRightChild());
                    if (tempNode.getLeftChild() != null || tempNode.getRightChild() != null) {
                        isRowEmpty = false;
                    }
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 2; j++) {
                    System.out.print(" ");
                }
            }

            System.out.println();

            while (!localStack.isEmpty()) {
                globalStack.push(localStack.pop());
            }

            nBlanks /= 2;
        }
        System.out.println("................................................................");
    }
}
