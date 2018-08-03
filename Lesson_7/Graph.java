package Lesson_7;

import java.util.Stack;

public interface Graph {

    public void addVertex(String label);

    public boolean addEdge(String fromLabel, String toLabel);

    public boolean remove(String label);

    public Vertex find(String label);

    int indexOf(String label);

    boolean isEmpty();

    int getSize();

    void display();

    //Death-first search, DFS
    void dfs(String startVertexLabel);

    //Breadth-first search, BFS
    void bfs(String startVertexLabel);

    Stack<Vertex> search(String startVertexLabel);

}
