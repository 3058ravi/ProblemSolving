package DP.matrixChainMultiplication;

import java.util.Arrays;

public class PalindromPartitioning {
    static int[][] dp;

    public static void main(String[] args) {
        String s = "ritik";
//                "ababbbabbababa";
        int n= s.length();
        dp = new int[n][n];
        for(int i=0; i<n; i++)
            Arrays.fill(dp[i],-1);
        System.out.println(palindromePartitioning(s, 0, n-1));
    }

    public static int palindromePartitioning(String s, int i, int j) {
        if(i>=j)
            return 0;
        if(isPalindrome(s, i,j))
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        dp[i][j]=Integer.MAX_VALUE;
        for(int k=i;k<=j; k++){
            int temp= palindromePartitioning(s,i,k)+ palindromePartitioning(s,k+1,j)+1;
            dp[i][j]=Math.min(dp[i][j],temp);
        }
        return dp[i][j];
    }

    public static boolean isPalindrome(String s, int i, int j){
        while(i<j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;j--;
        }
        return true;
    }
}
