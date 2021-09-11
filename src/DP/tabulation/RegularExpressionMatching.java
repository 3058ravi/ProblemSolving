package DP.tabulation;

public class RegularExpressionMatching {

    public static boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];


        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 && j == 0)
                    dp[i][j] = true;
                else if (j == 0)
                    dp[i][j] = false;
                else if (i == 0) {
                    if (p.charAt(j - 1) == '*') {
                        dp[i][j] = dp[i][j - 2];
                    } else {
                        dp[i][j] = false;
                    }
                } else {
                    if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?')
                        dp[i][j] = dp[i - 1][j - 1];
                    else if (p.charAt(j - 1) == '*') {
                        dp[i][j] = dp[i][j - 2];
                        char p_prev = p.charAt(j - 2);
                        if (p_prev == '.' || p_prev == s.charAt(i - 1))
                            dp[i][j] = dp[i][j]||dp[i][j-1];
                    } else
                        dp[i][j] = false;
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String s = "aab";
        String p = "c*a*b";
        System.out.println(isMatch(s, p));
    }
}
