package backtracking;

import java.util.Arrays;

public class NQueen {
    static int N;
    public static void main(String[] args){
        N=4;

        int board[][] = new int[N][N];
        for(int i =0; i<N;i++){
            Arrays.fill(board[i],0);
        }

        if (solveNQueen(board, 0) == false) {
            System.out.print("Solution does not exist");
        }

        printSolution(board);
    }

    public static void printSolution(int[][] sol) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(sol[i][j]+ "  ");
            }
            System.out.println();
        }
    }

    public static boolean isSafe(int[][] board,int row, int col){
        int i, j;
        //check row on left
        for( i=0; i<col;i++){
            if(board[row][i]==1)
                return false;
        }

        //check upper diagonal from left
        for( i=row, j=col;i>=0&&j>=0;i--,j--){
            if(board[i][j]==1)
                return false;
        }

        //check low diagonal from left
        for( i=row, j=col;i<N&&j>=0;i++,j--){
            if(board[i][j]==1)
                return false;
        }

        return true;
    }

    public static boolean solveNQueen(int[][] board,int col){
        if
        (col>=N)
            return true;

        for(int i=0; i<N; i++){
            if(isSafe(board,i,col)){
                board[i][col]=1;
                if(solveNQueen(board,col+1))
                    return true;

                board[i][col]=0;
            }
        }
        return false;
    }
}
