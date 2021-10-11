package graph;

import java.util.Iterator;
import java.util.LinkedList;

public class GraphDFS {

    private int V;
    private LinkedList<Integer> adj[];

    public GraphDFS(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int u, int v) {
        adj[u].add(v);
    }

    void DFS(int v) {
        boolean[] visited = new boolean[V];
        DFSUtil(v, visited);
    }

    void DFSUtil(int v, boolean[] visited) {
        visited[v] = true;
        System.out.println(v + " ");

        Iterator<Integer> iterator = adj[v].listIterator();
        while (iterator.hasNext()){
            int n= iterator.next();
            if(!visited[n]){
                DFSUtil(n,visited);
            }
        }
    }

    public static void main(String args[]) {
        GraphDFS g = new GraphDFS(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Depth First Traversal " +
                "(starting from vertex 2)");

        g.DFS(2);
    }
}
