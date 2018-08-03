
package Lesson_6;

import java.util.Random;

public class HomeWork_6_Main {
    public static void main(String[] args) {
        int balanced = 0;
        int notBalanced = 0;
        for (int i = 0; i < 20; i++) {
            Tree tree1 = createTree();
            if (isBalanced(tree1.getNodeRoot())) {
                balanced++;
            } else {
                notBalanced++;
            }
        }
        System.out.println("Количество сбалансированных деревьев: " + balanced);
        System.out.println("Количество несбалансированных деревьев: " + notBalanced);
        System.out.println("Процент сбалансированных деревьев: "+(double) balanced / (balanced + notBalanced) * 100 + "%");
        //Очень низкий процент сбалансированных деревьев...Из 10 запусков программы,
        // примерно 1 раз встретится одно сбалансированное дерево.

        //После внесения изменений (Не добавляются элементы с одинаковыми ключами) в метод insert(),
        // процент сбаланчированных деревьев в среднем возрос
    }

    private static Tree createTree() {
        Tree tree = new TreeImpl();
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            while (true) {
                int id = random.nextInt(41) - 20;
                if (tree.insert(new Person(id + " - Name", id, id))) {
                    break;
                } else {
                    id = random.nextInt(41) - 20;
                }
            }
        }
        return tree;
    }

    public static boolean isBalanced(Node node) {
        return (node == null) ||
                isBalanced(node.getLeftChild()) &&
                        isBalanced(node.getRightChild()) &&
                        Math.abs(height(node.getLeftChild()) - height(node.getRightChild())) <= 1;
    }

    private static int height(Node node) {
        return node == null ? 0 : 1 + Math.max(height(node.getLeftChild()), height(node.getRightChild()));
    }
}
