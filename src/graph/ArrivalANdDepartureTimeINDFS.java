package graph;

import utils.Edge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrivalANdDepartureTimeINDFS {

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
    public static int DFS(Graph graph, int vertices, boolean[] discovered, int[] arrival, int[] departure, int time) {
        arrival[vertices]=++time;
        discovered[vertices]=true;
        for( int i: graph.adj.get(vertices)){
            if(!discovered[i])
                time= DFS(graph, i, discovered,arrival,departure,time);
        }
        departure[vertices]=++time;
        return time;
    }

    public static void main(String[] args) {
        List<Edge> edges = Arrays.asList(
                new Edge(0, 1), new Edge(0, 2), new Edge(2, 3),
                new Edge(2, 4), new Edge(3, 1), new Edge(3, 5),
                new Edge(4, 5), new Edge(6, 7));


        final int N = 8;
        Graph graph = new Graph(edges, N);
        int[] arrival = new int[N];
        int[] departure = new int[N];
        boolean[] discovered = new boolean[N];
        int time = -1;

        for (int i = 0; i < N; i++) {
            if (!discovered[i]) {
                time = DFS(graph, i, discovered, arrival, departure, time);
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.println("Vertex " + i + " (" + arrival[i]
                    + ", " + departure[i] + ")");
        }
    }
}
