package graph;

import java.util.Iterator;
import java.util.LinkedList;

public class GraphBFS {

    private int V;
    private LinkedList<Integer> adj[];
    public GraphBFS(int v){
        V=v;
        adj= new LinkedList[v];
        for(int i=0; i<v; i++){
            adj[i]= new LinkedList<>();
        }
    }

    public void addEdge( int u, int v){
        adj[u].add(v);
    }

    public void BFS(int s){
        boolean[] visited= new boolean[V];
        LinkedList<Integer> queue = new LinkedList<>();
        visited[s]=true;
        queue.add(s);

        while (!queue.isEmpty()){
            s= queue.poll();
            System.out.println(s+" ");

            Iterator iterator = adj[s].listIterator();
            while (iterator.hasNext()){
                int n= (int) iterator.next();
                if(!visited[n]){
                    visited[n]=true;
                    queue.add(n);
                }
            }
        }
    }

    public static void main(String args[]) {
        GraphBFS g = new GraphBFS(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal "+
                "(starting from vertex 2)");

        g.BFS(2);
    }

}
