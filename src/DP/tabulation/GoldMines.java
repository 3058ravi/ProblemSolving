package DP.tabulation;

public class GoldMines {
    public static void main(String[] args){
        int[][] gm= { {1, 3, 1, 5},
                {2, 2, 4, 1},
                {5, 0, 2, 3},
                {0, 6, 1, 2} };

        int m = 4, n = 4;

        System.out.print(getMaxGold(gm, m, n));
    }

    public static int getMaxGold(int[][] gm, int m, int n){
        int[][] dp= new int[m][n];
        for(int col=n-1; col>=0; col--){
            for(int row= 0; row<m; row++){
                int right= (col==n-1)?0:dp[row][col+1];
                int right_up= (row==0|| col==n-1)?0:dp[row-1][col+1];
                int right_down= (row==m-1||col==n-1)?0:dp[row+1][col+1];
                dp[row][col]=gm[row][col]+Math.max(right,Math.max(right_up,right_down));

            }
        }
        int res=0;
        for(int i=0; i<m; i++){
           res=Math.max(res, dp[i][0]);
        }
        return res;
    }
}
