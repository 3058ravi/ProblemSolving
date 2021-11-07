package DP.LCS;

import java.util.Arrays;

public class CountAllPalindromicSubsequence {
    public static void main(String[] args){
        String s="aa";
        System.out.println(countALlPalindromicSubsequence(s));
    }

    public static int countALlPalindromicSubsequence(String s){
        StringBuilder sb = new StringBuilder(s);
        String t= sb.reverse().toString();
        int n= s.length();
         int[][] dp= new int[n][n];
         for (int i=0; i<=n; i++)
                Arrays.fill( dp[i],-1);
         int count=0;
         for(int i=0; i<=n; i++){
             for(int j=0; j<=n; j++){
                 if(i==0||j==0)
                     dp[i][j]=0;
                 else if(dp[i][j]!=-1)
                     return dp[i][j];
                 else if(s.charAt(i-1)==t.charAt(j-1)) {
                     dp[i][j] = 1 + dp[i-1][j - 1];
                 }else
                     dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
             }
         }
         return count;
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
