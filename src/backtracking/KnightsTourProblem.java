/**
 * Solution for moving a knight on chess board
 * such that it does not traverse the same cell twice covering all the cells.
 */
package backtracking;

import java.util.Arrays;

public class KnightsTourProblem {
    static int N = 8;

    public static void main(String[] args) {
        solveKT();
    }

    public static void printSolution(int[][] sol) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(sol[i][j]+ "  ");
            }
            System.out.println();
        }
    }

    public static boolean solveKT() {
        int[][] sol = new int[8][8];
        for(int i=0; i<N; i++){
            Arrays.fill(sol[i], -1);
        }


        int xMove[] = {2, 1, -1, -2, -2, -1, 1, 2};
        int yMove[] = {1, 2, 2, 1, -1, -2, -2, -1};

        sol[0][0] = 0;

        if (!solveKTUtil(0, 0, 1, sol, xMove, yMove)) {
            System.out.println("Solution Not possible");
            return false;
        } else{
            printSolution(sol);

        }
        return true;
    }

    public static boolean isSafe(int[][] sol, int x, int y){
        return (x>=0 && x<N && y>=0 && y<N && sol[x][y]==-1);
    }

    public static boolean solveKTUtil(int x, int y, int nextMove, int[][] sol, int[] xMove, int[] yMove){
        int k, next_x,next_y;
        if(nextMove==N*N)
            return true;

        for(k=0; k<8; k++){
            next_x=x+xMove[k];
            next_y= y+yMove[k];
            if(isSafe(sol,next_x,next_y)){
                sol[next_x][next_y]=nextMove;
                if(solveKTUtil(next_x, next_y, nextMove+1, sol, xMove, yMove))
                    return true;
                else
                    sol[next_x][next_y]=-1;
            }

        }
        return false;
    }
}
