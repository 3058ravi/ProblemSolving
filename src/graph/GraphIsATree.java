package graph;

import utils.Edge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GraphIsATree {
    static class Graph {
        List<List<Integer>> adj = null;

        public Graph(List<Edge> edges, int n) {
            adj = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                adj.add(new ArrayList<>());
            }

            for (Edge e : edges) {
                adj.get(e.source).add(e.dest);
                adj.get(e.dest).add(e.source);
            }
        }
    }

    public static void main(String[] args) {
        List<Edge> edges = Arrays.asList(
                new Edge(0, 1), new Edge(1, 2), new Edge(2, 3),
                new Edge(3, 4), new Edge(4, 5)
                , new Edge(5, 0)
        );

        final int N = 6;
        Graph graph = new Graph(edges, N);
        boolean[] discovered = new boolean[N];


        boolean isTree = DFS(graph, 0, discovered, -1);

        for (int i = 0; isTree && i < N; i++) {
            if (!discovered[i]) {
                isTree = false;
            }
        }

        if (isTree) {
            System.out.println("The graph is a tree");
        } else {
            System.out.println("The graph is not a tree");
        }
    }

    public static boolean DFS(Graph graph, int v, boolean[] discovered, int prev) {
        discovered[v] = true;
        for (int w : graph.adj.get(v)) {
            if (!discovered[w]) {
                if (!DFS(graph, w, discovered, v)) {
                    return false;
                }
            } else if (w != prev)
                return false;

        }
        return true;
    }
}
