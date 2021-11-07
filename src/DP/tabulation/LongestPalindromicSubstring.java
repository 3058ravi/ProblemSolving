package DP.tabulation;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(longestPalindromeSimple("aaaabbaa"));
    }

    public static String longestPalindrome(String s) {

        int n = s.length();
        String res = null;
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {

                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);

                if (dp[i][j] && (res == null || j - i + 1 > res.length()))
                    res = s.substring(i, j + 1);

            }
        }

        return res;
    }

    public static String longestPalindromeSimple(String s) {
        int resLen = 0;
        String res = "";
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int l = i, r = i;
            String odd = findLongestPalindrom(s, l, r, n, resLen, res);
            String even = findLongestPalindrom(s, l, r + 1, n, resLen, res);
            String  temp=odd.length() > even.length() ? odd : even;
            res = res.length()>temp.length()?res:temp;
        }
        return res;
    }

    public static String findLongestPalindrom(String s, int l, int r, int n, int resLen, String res) {
        while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
            if (r - l + 1 > resLen) {
                resLen = r - l + 1;
                res = s.substring(l, r+1);
            }
            l--;
            r++;
        }
        return res;
    }
}
