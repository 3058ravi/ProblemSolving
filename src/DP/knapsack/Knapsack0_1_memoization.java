package DP.knapsack;

import java.util.Arrays;

public class Knapsack0_1_memoization {
    public static void main(String args[]) {
        int val[] = new int[]{60, 100, 120};
        int wt[] = new int[]{10, 20, 30};
        int W = 50;
        int n = val.length;
        int[][] dp= new int[n+1][W+1];
        for(int i=0; i<n+1;i++)
            Arrays.fill(dp[i],-1);
        System.out.println(knapSack(W, wt, val, n,dp));
    }

    public static int knapSack(int W, int[] wt, int[] val, int n, int[][] dp){
        if(n==0|| W==0)
            return 0;

        if(wt[n-1]>W)
            return dp[n][W]= knapSack(W, wt, val, n-1,dp);

        if (dp[n][W]!=-1)
            return dp[n][W];

        return dp[n][W]= Math.max(val[n-1]+knapSack(W-wt[n-1], wt, val, n-1,dp),knapSack(W,wt,val, n-1,dp));
    }
}
