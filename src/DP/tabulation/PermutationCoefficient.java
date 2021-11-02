package DP.tabulation;

public class PermutationCoefficient {
    public static void main(String[] args){
         System.out.println(nPr(10,5));
    }

    public static int nPr(int n, int r){
        int dp[][] = new int[r + 1][n + 1];
        for(int i=0; i<=r; i++){
            for(int j=0; j<=n;j++){
                if(j<i)
                    dp[i][j]=0;
                else if( i==0)
                    dp[i][j]=1;
                else
                    dp[i][j]= j*dp[i-1][j-1];
            }
        }


        return dp[r][n];
    }
}
