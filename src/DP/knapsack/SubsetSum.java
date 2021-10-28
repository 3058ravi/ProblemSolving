package DP.knapsack;

public class SubsetSum {
    public static void main(String[] args){
        int[] arr={2,3,7,8,10};
        int sum= 11;
        System.out.println(subsetSum(arr, sum));
    }

    public static boolean subsetSum(int[] arr, int sum){
        int n= arr.length;
        boolean[][] dp = new boolean[n+1][sum+1];

        for(int i=0; i<=n;i++){
            for(int j=0;j<=sum; j++){
                if(j==0)
                    dp[i][j]=true;
                else if(i==0 && j!=0)
                    dp[i][j]=false;
                else if(arr[i-1]<=j)
                    dp[i][j]=dp[i-1][j-arr[i-1]]||dp[i-1][j];
                else
                    dp[i][j]=dp[i-1][j];
            }
        }
    return dp[n][sum];
    }
}
