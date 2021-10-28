package DP.LCS;

public class MinimumNumberOFDeletionToMakeStringPalindrom {
    public static void main(String[] args){
        String s="agbcba";
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        System.out.println(minimumNumberOfDeletionToMakeAStringPalindrome(s,sb.reverse().toString()));
    }

    public static int minimumNumberOfDeletionToMakeAStringPalindrome(String s1, String s2){
        int n= s1.length();
        int[][] dp = new int[n+1][n+1];
        for(int i=0; i<=n; i++){
            for(int j=0; j<=n; j++){
                if(i==0||j==0) {
                    dp[i][j]=0;
                }
                else if(s1.charAt(i-1)==s2.charAt(j-1))
                    dp[i][j]=1+dp[i-1][j-1];
                else
                    dp[i][j]= Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        /*
        Since LCS of String s and reverse of s will return the palindrome .
        Length of String - palindrome length = total deletion required to make string palindrom

         */

        /* the same code works for minimum number of insertion */
        return n-dp[n][n];
    }
}
