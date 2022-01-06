/**
 * Solution for graph coloring problem.
 */
package backtracking;

import java.util.Arrays;

public class GraphColoring {
    static int V=4;

    public static void main(String[] args) {
        int graph[][] = {
                { 0, 1, 1, 1 },
                { 1, 0, 1, 0 },
                { 1, 1, 0, 1 },
                { 1, 0, 1, 0 },
        };
        int m = 3;
        int[] color = new int[V];
        Arrays.fill(color, 0);

        if (!graphColoring(graph, m, color,0))
            System.out.println("Solution does not exist");

        printSolution(color);
    }

    public static boolean isSafe(int[][] graph, int[] color, int V, int j) {

        for (int i = 0; i < V; i++) {
                if (graph[i][j] ==1 && j == color[i])
                    return false;
        }
        return true;
    }

    public static void printSolution(int[] color) {
        for (int i = 0; i < V; i++)
            System.out.print("  " + color[i]);
        System.out.println();
    }

    public static boolean graphColoring(int[][] graph, int m,  int[] color, int i) {
        if (i == V)
            return true;


        for (int j = 1; j <= m; j++) {
            if(isSafe(graph,color,i, j)){
                color[i] = j;
                if (graphColoring(graph, m,  color,i+1))
                    return true;
                color[i] = 0;
            }


        }
        return false;
    }
}
