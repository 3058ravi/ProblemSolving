package DP.tabulation;

public class MaxSquare {
    public  static void main(String[] args){
       int[][] matrix = {{1,0,1,0,0},{1,0,1,1,1},{1,1,1,1,1},{1,0,0,1,0}};
       System.out.println(maxSquare(matrix));
    }

    public static int maxSquare(int[][] matrix){
        int[][] dp= new int[matrix.length+1][matrix[0].length+1];
        int max=0;

         for(int i=1; i<dp.length; i++){
             for(int j=1; j<dp[0].length; j++){
                 if(matrix[i-1][j-1]==1){
                     dp[i][j]=1+Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
                     max=Math.max(max,dp[i][j]);
                 }
             }
         }
         return max*max;
    }
}
