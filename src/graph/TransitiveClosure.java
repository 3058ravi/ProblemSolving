package graph;

import utils.Edge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TransitiveClosure {
    static class Graph {
        List<List<Integer>> adj = null;

        public Graph(List<Edge> edges, int n) {
            adj = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                adj.add(new ArrayList<>());
            }

            for (Edge e : edges) {
                adj.get(e.source).add(e.dest);
            }
        }
    }

    public static void main(String[] args) {
        List<Edge> edges = Arrays.asList(
                new Edge(0, 2), new Edge(1, 0), new Edge(3, 1));

        final int N = 4;
        Graph graph = new Graph(edges, N);
        byte c[][] = new byte[N][N];
        for (int i = 0; i < N; i++) {
            c[i][i] = 1;
            DFS(graph, c, i, i);
            System.out.println(Arrays.toString(c[i]));
        }
    }

    public static void DFS(Graph graph, byte[][] c, int root, int descendent) {
        for (int i : graph.adj.get(descendent)) {
            if (c[root][i] == 0) {
                c[root][i] = 1;
                DFS(graph, c, root, i);
            }
        }
    }
}
