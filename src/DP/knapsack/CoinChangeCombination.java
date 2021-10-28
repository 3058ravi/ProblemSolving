package DP.knapsack;

public class CoinChangeCombination {

    public static void main(String[] args){
        int[] a={2,3,5,6};
        int amount=10;

        System.out.println(coinChange(a, a.length,amount));

    }

    public static int coinChange(int[] coins,int len, int total){

        int[][] dp= new int[len+1][total+1];
        for(int i=0; i<=len; i++){
            for(int j=0; j<=total; j++){
                if(j==0)
                    dp[i][j]=1;
                else if(i==0 && j!=0)
                    dp[i][j]=0;
                else if(coins[i-1]<=j)
                    dp[i][j]= dp[i][j-coins[i-1]]+ dp[i-1][j];
                else
                    dp[i][j]=dp[i-1][j];
            }
        }
       return dp[len][total];
    }

}
