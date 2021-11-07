package DP.tabulation;

import java.util.Arrays;

public class MinimumNumberOfRemovalForMinMaxArray {
    public static void main(String[] args){
        int[] a={1, 3, 4, 9, 10, 11, 12, 17, 20};
        int k=4;
        int n=a.length;
        int[][] dp= new int[n][n];
        for(int i=0; i<n; i++)
            Arrays.fill(dp[i],-1);

        System.out.println(solve(a, k, 0, a.length-1, dp));
    }

    public static int solve(int[] a, int k, int i, int j, int[][] dp){
       if(i>=j)
           return 0;
       else if(a[j]-a[i]<=k)
           return 0;

       else if(dp[i][j]!=-1)
           return dp[i][j];
       else
           dp[i][j]=1+Math.min(solve(a,k, i+1, j, dp), solve(a,k, i, j-1, dp));

       return dp[i][j];
    }
}
