package DP.LCS;

import java.util.Arrays;

public class SequencePatternMatching {
    public static void main(String[] args) {
        String s1 = "axy";
        String s2 = "adxcpy";
        int m = s1.length(), n = s2.length();
        System.out.println(sequencePatternMatching(s1, s2, m, n));
    }
    public static boolean sequencePatternMatching(String s1, String s2, int m, int n){
        if(m>n)
            return sequencePatternMatching(s2,s1,n,m);

        int[][] dp= new int[m+1][n+1];
        for(int i=0; i<=m; i++){
            for(int j=0; j<=n; j++){
                if(i==0||j==0)
                    dp[i][j]=0;
                else if(s1.charAt(i-1)==s2.charAt(j-1))
                    dp[i][j]=1+dp[i-1][j-1];
                else
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }

        return  dp[m][n]==s1.length();


    }
}
