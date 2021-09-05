package utils;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    // A list of lists to represent an adjacency list
    List<List<Edge>> adjList = null;

    // Constructor
    public Graph(List<Edge> edges, int N) {
        adjList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            adjList.add(new ArrayList<>());
        }

        // add edges to the undirected graph
        for (Edge edge : edges) {
            adjList.get(edge.source).add(edge);
        }

    }
}
