package DP.LCS;

public class LongestCommonSubsequence_topDown {
    public static void main(String[] args){
        String s1="abcdgh";
        String s2= "abdefgh";
        int m=s1.length();
        int n= s2.length();
        System.out.println(longestCommonSubsequence(s1,s2, m,n));
    }

    public static int longestCommonSubsequence(String s1, String s2, int m, int n){
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
        printLongestCommonSubsequence(dp,s1,s2,m,n);
       return  dp[m][n];
    }

    public static void printLongestCommonSubsequence(int[][] dp,String s1, String s2, int m, int n){
        int i=m, j=n;
        String s="";
        while(i>0 && j>0){
            if(s1.charAt(i-1)==s2.charAt(j-1)) {
                s = s1.charAt(i - 1) + s;
                i--; j--;
            }else {
                if (dp[i-1][j]>dp[i][j-1])
                    i--;
                else
                    j--;
            }

        }
        System.out.println(s);
    }

}
