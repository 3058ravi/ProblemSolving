package graph;

import utils.Edge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckGraphIsBipartite {

    static class Graph {
        List<List<Integer>> adj = null;

        public Graph(List<Edge> edges, int n) {
            adj = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                adj.add(new ArrayList<>());
            }

            for (Edge e : edges) {
                int src = e.source;
                int dest = e.dest;
                adj.get(src).add(dest);
                adj.get(dest).add(src);
            }
        }
    }

    public static boolean DFS(Graph graph, int v, boolean[] discovered, boolean[] color) {
        for (int e : graph.adj.get(v)) {
            if (!discovered[e]) {
                discovered[e] = true;
                color[e] = !color[v];
                if (!DFS(graph, e, discovered, color))
                    return false;
            } else if (color[e] == color[v]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<Edge> edges = Arrays.asList(
                new Edge(0, 1), new Edge(0, 2), new Edge(2, 3),
                new Edge(2, 4), new Edge(3, 1), new Edge(3, 5),
                new Edge(4, 5), new Edge(6, 7));


        final int N = 8;
        Graph graph = new Graph(edges, N);
        boolean[] color = new boolean[N];
        boolean[] discovered = new boolean[N];

        discovered[0] = true;
        color[0] = false;

        if (DFS(graph, 1, discovered, color))
            System.out.println("The graph is bipartite");
        else
            System.out.println("The graph is not bipartite");


    }
}
