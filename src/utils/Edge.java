package utils;

public class Edge {
    public int source, dest, weight;
    public Edge(int source, int dest, int weight)
    {
        this.source = source;
        this.dest = dest;
        this.weight = weight;
    }

    public Edge(int source, int dest)
    {
        this.source = source;
        this.dest = dest;
    }
}
