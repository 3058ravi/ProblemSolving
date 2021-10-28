package DP.LCS;

public class MinimumNumberOfInsertionORDeletionFromS1toS2 {

    public static void main(String[] args){
        String s1="heap";
        String s2= "pea";
        int m=s1.length();
        int n= s2.length();
        System.out.println(minimumNumberOfInsertionOrDeletionFromS1toS2(s1,s2, m,n));
    }

    public static int minimumNumberOfInsertionOrDeletionFromS1toS2(String s1, String s2, int m, int n){
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
        /*
        TO solve this problem we will first find LCS for s1 ans S2
        Since we have LCS, all extra chars in S1 other than LCS will be accounted for deletion
        ALl the extra chars in S2 will account for new insertion in resulting String

        Formula: deletion = S1-LCS
                    insertion =s2-LCS
                    total insertion +deletion= S1-LCS +s2-LCS  => S1+S2-2*LCS

         */
        return  m+n- 2* dp[m][n];
    }
}
