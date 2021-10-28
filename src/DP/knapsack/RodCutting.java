package DP.knapsack;

public class RodCutting {
    public static void main(String[] args) {
        int[] len = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] price = {1, 5, 8, 9, 10, 17, 17, 20};
        int l = 8;
        System.out.println(rodCutting(len, price, l));
    }

    public static int rodCutting(int[] len, int[] price, int l) {
        int n=len.length;
        int[][] dp = new int[n+1][l+1];

        for (int i = 0; i <= n; i++){
            for(int j=0; j<=l; j++){
                if(i==0||j==0)
                    dp[i][j]=0;
                else if(len[i-1]<=j)
                    dp[i][j]=Math.max(price[i-1]+dp[i][j-len[i-1]],dp[i-1][j]);
                else
                    dp[i][j]=dp[i-1][j];
            }
        }
        return dp[n][l];
    }
}
