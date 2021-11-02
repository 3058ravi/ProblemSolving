package DP.tabulation;

public class BinomialCoefficient {
    public static void main(String[] args){
        System.out.println(nCr(10,5));
    }
   public static long nCr(int n, int r){
       int dp[][] = new int[r + 1][n + 1];
       for(int i=0; i<=r; i++){
           for(int j=0; j<=n;j++){
               if(dp[i][j]!=0)
                   return dp[i][j];
               if(j<i)
                   dp[i][j]=0;
               else if(i==j|| i==0)
                   dp[i][j]=1;
               else
                   dp[i][j]= dp[i-1][j-1]+ dp[i][j-1];
           }
       }


        return dp[r][n];
   }

}
