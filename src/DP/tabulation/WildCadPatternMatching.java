package DP.tabulation;

public class WildCadPatternMatching {
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
                    if (p.charAt(j-1) == '*') {
                        dp[i][j] = dp[i][j - 1];
                    }else{
                        dp[i][j]=false;
                    }
                } else {
                    if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?')
                        dp[i][j] = dp[i - 1][j - 1];
                    else if (p.charAt(j - 1) == '*')
                        dp[i][j] = dp[i - 1][j] || dp[i][j-1];
                    else
                        dp[i][j] = false;
                }
            }
        }
        return dp[m][n];
    }

    public static boolean isMatch(String s, String p, int i, int j){
        if(i==s.length() &&j==p.length())
            return true;
         if(i<s.length() &&j==p.length())
            return false;

         if(i==s.length() && j<p.length()){
             for(int k=j; k<p.length(); k++){
                 if(p.charAt(k)!='*')
                     return false;
             }
             return  true;
         }


        if(s.charAt(i)==p.charAt(j)|| p.charAt(j)=='?')
            return isMatch(s, p, i+1, j+1);
        if(p.charAt(j)=='*')
            return (isMatch(s, p, i, j+1) ||isMatch(s, p, i+1, j)  );

        return false;
    }

    public static void main(String[] args) {
        String s = "aa";
        String p = "*";
        System.out.println(isMatch(s, p, 0,0));
    }
}
