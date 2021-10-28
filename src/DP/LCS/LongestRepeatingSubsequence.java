package DP.LCS;

public class LongestRepeatingSubsequence {

    public static void main(String[] args) {
        String s1 = "aabebcdd";

        int m = s1.length();
        System.out.println(longestRepeatingSubSequence(s1, s1, m));
    }

    public static int longestRepeatingSubSequence(String s1, String s2, int n) {
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                 if(i==0||j==0)
                     dp[i][j]=0;
                 else if(s1.charAt(i-1)== s2.charAt(j-1) && i!=j)
                     dp[i][j]=1+ dp[i-1][j-1];
                 else
                     dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[n][n];
    }
}
