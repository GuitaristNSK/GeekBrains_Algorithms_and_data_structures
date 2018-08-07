package Lesson_7;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class GraphImpl implements Graph {

    private Vertex[] vertexes;
    private int[][] adjMatrix;

    private int size;

    public GraphImpl(int maxVertexCount) {
        this.vertexes = new Vertex[maxVertexCount];
        this.size = 0;
        createAdjMatrix(maxVertexCount);
    }

    private void createAdjMatrix(int maxVertexCount) {
        this.adjMatrix = new int[maxVertexCount][maxVertexCount];
        for (int i = 0; i < maxVertexCount; i++) {
            for (int j = 0; j < maxVertexCount; j++) {
                adjMatrix[i][j] = 0;
            }
        }
    }

    @Override
    public void addVertex(String label) {
        Vertex newVertex = new Vertex(label);
        vertexes[size++] = newVertex;
    }

    @Override
    public boolean addEdge(String fromLabel, String toLabel) {
        int from = indexOf(fromLabel);
        int to = indexOf(toLabel);
        if (from == -1 || to == -1) {
            return false;
        }
        adjMatrix[from][to] = 1;
        adjMatrix[to][from] = 1;
        return true;
    }

    @Override
    public boolean remove(String label) {
        int vertexIndex = indexOf(label);
        if (vertexIndex == -1) {
            return false;
        }
        clearEdges(vertexIndex);
        vertexes[vertexIndex] = null;
        size--;
        return true;
    }

    private void clearEdges(int vertexIndex) {
        for (int i = 0; i < vertexes.length; i++) {
            adjMatrix[vertexIndex][i] = 0;
            adjMatrix[i][vertexIndex] = 0;
        }
    }

    private boolean hasEdge(Vertex from, Vertex to) {
        return hasEdge(from.getLabel(), to.getLabel());
    }

    private boolean hasEdge(String fromLabel, String toLabel) {
        int from = indexOf(fromLabel);
        int to = indexOf(toLabel);
        if (from == -1 || to == -1) return false;
        return adjMatrix[from][to] == 1;
    }

    @Override
    public Vertex find(String label) {
        for (int i = 0; i < vertexes.length; i++) {
            String vertexLabel = vertexes[i].getLabel();
            if (vertexLabel.equals(label)) {
                return vertexes[i];
            }
        }
        return null;
    }

    @Override
    public int indexOf(String label) {
        for (int i = 0; i < vertexes.length; i++) {
            if (vertexes[i] == null) continue;
            String vertexLabel = vertexes[i].getLabel();
            if (vertexLabel.equals(label)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void display() {
        for (int i = 0; i < vertexes.length; i++) {
            if (vertexes[i] == null) continue;
            String out = vertexes[i].toString();
            for (int j = 0; j < vertexes.length; j++) {
                if (adjMatrix[i][j] == 1) {
                    out += " -> " + vertexes[j];
                }
            }
            System.out.println(out);
        }
    }

    @Override
    public void dfs(String startVertexLabel) {
        Vertex vertex = find(startVertexLabel);
        if (vertex == null) {
            return;
        }
        Stack<Vertex> stack = new Stack<>();
        visit(vertex, stack);


        while (!stack.isEmpty()) {
            vertex = getAdjUnvisitedVertex(stack.peek());
            if (vertex == null) {
                vertex = stack.pop();
            } else {
                visit(vertex, stack);
            }
        }
        resetVertexStates();
    }

    @Override
    public void bfs(String startVertexLabel) {
        Vertex vertex = find(startVertexLabel);
        if (vertex == null) {
            return;
        }
        Queue<Vertex> queue = new ArrayDeque();
        visit(vertex, queue);

        while (!queue.isEmpty()) {
            vertex = queue.remove();
            Vertex currentVertex = null;
            while ((currentVertex = getAdjUnvisitedVertex(vertex)) != null) {
                visit(currentVertex, queue);
            }
        }
        resetVertexStates();
    }

    @Override
    public Stack<Vertex> search(String startVertexLabel) {
        Vertex vertex = find(startVertexLabel);
        if (vertex == null) {
            System.out.println("Вершины " + startVertexLabel + " в данном графе нет");
            return null;
        }
        Queue<Vertex> queue = new ArrayDeque();
        visit(vertex, queue);
        Stack<Vertex> resultStack = new Stack<>();

        while (!queue.isEmpty()) {
            vertex = queue.remove();
            Vertex currentVertex = null;
            Vertex resultVertex = null;
            while ((currentVertex = getAdjUnvisitedVertex(vertex)) != null) {
                currentVertex.setPreviousVertex(vertex);
                visit(currentVertex, queue);
                resultVertex = currentVertex;
            }
            if (resultVertex.getLabel().equals("Воронеж")) {
                resultStack.push(resultVertex);
                while (resultVertex.getPreviousVertex() != null) {
                    resultVertex = resultVertex.getPreviousVertex();
                    resultStack.push(resultVertex);
                }
                break;
            }
        }
        resetVertexStates();
        return resultStack;//stack
    }

    private void visit(Vertex vertex, Queue<Vertex> queue) {
//        display(vertex);
        vertex.setWasVisited(true);
        queue.add(vertex);
    }

    private Vertex getAdjUnvisitedVertex(Vertex vertex) {
        for (int i = 0; i < vertexes.length; i++) {
            Vertex currentVertex = vertexes[i];
            if (hasEdge(vertex, currentVertex) && !currentVertex.isWasVisited())
                return currentVertex;
        }
        return null;
    }

    private void resetVertexStates() {
        for (int i = 0; i < vertexes.length; i++) {
            vertexes[i].setWasVisited(false);
        }
    }

    private void visit(Vertex vertex, Stack<Vertex> stack) {
        stack.push(vertex);
        display(vertex);
        vertex.setWasVisited(true);
    }

    private void display(Vertex vertex) {
        System.out.println(vertex);
    }
}
