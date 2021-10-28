package DP.LCS;

public class ShortestCommonSuperSequence {
    public static void main(String[] args) {
        String s1 = "aggtab";
        String s2 = "gxtxayb";
        int m = s1.length(), n = s2.length();
        System.out.println(longestCommonSuperSequence(s1, s2, m, n));
    }

    public static int longestCommonSuperSequence(String s1, String s2, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {

                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        printShortestCommonSuperSequence(s1,s2,m,n,dp);
        /** since LCS is common in both the string.
         * Removing LCS one time from M+N return shortest super sequence.*/
        return m + n - dp[m][n];
    }

    public static void printShortestCommonSuperSequence(String s1, String s2, int m, int n, int[][] dp ){
        int i=m, j=n;
        String s="";
        while(i>=0 && j>=0){
            if(i==0){
                while(j>0){
                    s=s2.charAt(j-1)+s;
                    j--;
                }
                break;
            }
            if(j==0) {
                while(i>0){
                    s=s1.charAt(i-1)+s;
                    i--;
                }
                break;
            }

            if(s1.charAt(i-1)==s2.charAt(j-1)){
                s=s1.charAt(i-1)+s;
                i--;j--;
            }else{
                if(dp[i-1][j]<=dp[i][j-1]){
                    s=s2.charAt(j-1)+s;
                    j--;
                }
                else{
                    s=s1.charAt(i-1)+s;
                    i--;
                }
            }
        }
        System.out.println(s);
    }

}
