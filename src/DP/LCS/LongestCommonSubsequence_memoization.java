package DP.LCS;

import java.util.Arrays;

public class LongestCommonSubsequence_memoization {

    public static void main(String[] args){
        String s1="abcdgh";
        String s2= "abdefgh";
        int m=s1.length();
        int n= s2.length();
        int[][] dp= new int[m+1][n+1];
        for(int i=0; i<m+1;i++)
            Arrays.fill(dp[i],-1);
        System.out.println(longestCommonSubsequence(s1,s2, m,n,dp));
    }

    public static int longestCommonSubsequence(String s1, String s2, int m, int n, int[][] dp){

        if(m==0 || n==0) {
            dp[m][n]=0;
            return 0;
        }
        if(dp[m][n]!=-1)
            return dp[m][n];
        if(s1.charAt(m-1)==s2.charAt(n-1))
            return dp[m][n]= 1 +longestCommonSubsequence(s1, s2, m-1, n-1, dp);
        else
            return dp[m][n]=Math.max(longestCommonSubsequence(s1,s2,m-1,n,dp), longestCommonSubsequence(s1,s2,m,n-1,dp));

    }
}
