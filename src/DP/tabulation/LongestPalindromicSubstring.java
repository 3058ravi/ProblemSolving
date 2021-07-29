package DP.tabulation;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(longestPalindrome2("aaaabbaa"));
    }

    public static String longestPalindrome(String s) {

        int n = s.length();
        String res = null;
        boolean[][] dp = new boolean[n][n];
        for (int i = n-1; i >=0 ; i--) {
            for (int j = i; j <n; j++) {

                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);

                if (dp[i][j] && (res == null || j - i + 1 > res.length()))
                    res = s.substring(i, j + 1);

            }
        }

        return res;
    }

    static int start = 0, end = 0;
    public static String longestPalindrome2(String s) {

        if (s.length() < 2) {
            return s;
        }
        char[] c = s.toCharArray();
        longestPalAt(c, 0);
        return s.substring(start, end + 1);
    }

    private  static void longestPalAt(char[] c, int p) {
        int a = p;
        int b = p;
        // pos at the end or not enough char left
        // base case
        if (p == c.length - 1 || (c.length - p) <= (end - start + 1) / 2 - 1) {
            return;
        }
        while (b < c.length - 1 && c[b] == c[b + 1]) {
            b++;
        }
        p = b;
        while (a > 0 && b < c.length - 1 && c[a - 1] == c[b + 1]) {
            a--;
            b++;
        }
        if (b - a > end - start) {
            end = b;
            start = a;
        }
        longestPalAt(c, p + 1);
    }

    public static String longestPalindrome1(String s) {
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            //StringBuffer sb = new StringBuffer();
            //sb.append(s.charAt[i]);
            char c = s.charAt(i);
            int left = i;
            int right = i;

            while (left >= 0 && s.charAt(left) == c) {
                left--;
            }

            while (right < s.length() && s.charAt(right) == c) {
                right++;
            }

            while (left >= 0 && right < s.length()) {
                if (s.charAt(left) != s.charAt(right)) {
                    break;
                }
                left--;
                right++;
            }


            // left + 1 and right - 1 are actually the start and end index of the Palindromic string
            // we don't set "right" because String.substring function required end index exclusively
            left = left + 1;
            if (end - start < right - left) {
                start = left;
                end = right;
            }
        }

        return s.substring(start, end);
    }
}
