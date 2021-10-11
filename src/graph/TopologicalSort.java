package graph;

import utils.Edge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TopologicalSort {

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
                new Edge(0, 6), new Edge(1, 2), new Edge(1, 4),
                new Edge(1, 6), new Edge(3, 0), new Edge(3, 4),
                new Edge(5, 1), new Edge(7, 0), new Edge(7, 1)
        );

        final int N = 8;
        Graph graph = new Graph(edges, N);
        doTopologicalSort(graph, N);
    }

    public static void doTopologicalSort(Graph graph, int N) {
        int[] departure = new int[2 * N];
        Arrays.fill(departure, -1);
        boolean[] discovered = new boolean[N];
        int time = 0;

        for (int i = 0; i < N; i++) {
            if (!discovered[i])
                time = DFS(graph, i, discovered, departure, time);
        }

        for (int i = 2 * N - 1; i >= 0; i--) {
            if (departure[i] != -1) {
                System.out.print(departure[i] + " ");
            }
        }

    }

    public static int DFS(Graph graph, int v, boolean[] discovered, int[] departure, int time) {
        discovered[v] = true;
        time++;
        for (int e : graph.adj.get(v)) {
            if (!discovered[e])
                time = DFS(graph, e, discovered, departure, time);
        }

        departure[time] = v;
        time++;
        return time;
    }
}
