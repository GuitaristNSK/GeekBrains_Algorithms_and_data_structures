package Lesson_7;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
//        testDfs();
//        testBfs();
        Graph graph = new GraphImpl(10);
        graph.addVertex("Москва");
        graph.addVertex("Тула");
        graph.addVertex("Липецк");
        graph.addVertex("Воронеж");
        graph.addVertex("Рязань");
        graph.addVertex("Тамбов");
        graph.addVertex("Саратов");
        graph.addVertex("Калуга");
        graph.addVertex("Орел");
        graph.addVertex("Курск");

        graph.addEdge("Москва", "Тула");
        graph.addEdge("Москва", "Рязань");
        graph.addEdge("Москва", "Калуга");
        graph.addEdge("Тула", "Липецк");
        graph.addEdge("Липецк", "Воронеж");
        graph.addEdge("Рязань", "Тамбов");
        graph.addEdge("Тамбов", "Саратов");
        graph.addEdge("Саратов", "Воронеж");
        graph.addEdge("Калуга", "Орел");
        graph.addEdge("Орел", "Курск");
        graph.addEdge("Курск", "Воронеж");

        Stack<Vertex> stack = graph.search("Москва");
        int size = stack.size();
        System.out.println("Кратчайший путь Москва - Воронеж:");
        for (int i = 0; i < size; i++) {
            System.out.print(stack.pop() + " ");
        }
    }

    private static void testBfs() {
        Graph graph = new GraphImpl(8);

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");
        graph.addVertex("H");

        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("A", "D");
        graph.addEdge("B", "E");
        graph.addEdge("C", "F");
        graph.addEdge("D", "G");
        graph.addEdge("E", "H");

        graph.bfs("A");
    }

    private static void testDfs() {
        Graph graph = new GraphImpl(7);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");

        graph.addEdge("A", "B");
        graph.addEdge("B", "E");
        graph.addEdge("A", "C");
        graph.addEdge("A", "D");
        graph.addEdge("D", "F");
        graph.addEdge("F", "G");

        graph.dfs("A");
    }
}
