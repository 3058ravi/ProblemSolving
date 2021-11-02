package DP.tabulation;

public class CatalanNumber {
    public static void main(String[] args){
        System.out.println(catalanNumber(10));
    }

    public static int catalanNumber(int n){
        int[] dp= new int[n+1];
        dp[0]=1;
        dp[1]=1;
         for(int i=2; i<=n; i++){
             dp[i]=0;
             for(int j=0; j<i; j++){
                 dp[i]+=dp[j]* dp[i-j-1];
             }
         }
         return dp[n];
    }
}
