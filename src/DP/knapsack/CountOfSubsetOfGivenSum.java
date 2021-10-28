package DP.knapsack;

public class CountOfSubsetOfGivenSum {

    public static void main(String [] args){
        int[] arr={2,3,5,6,8,10};
        int sum=10;
        System.out.println(countSubsetOfGivenSum(arr, sum));
    }
    public static int countSubsetOfGivenSum(int[] arr, int sum){
        int n= arr.length;
        int[][] dp=new int[n+1][sum+1];

        for(int i=0; i<=n; i++){
            for(int j=0; j<=sum; j++){
                if(j==0)
                    dp[i][j]=1;
                else if(i==0 && j!=0)
                    dp[i][j]=0;
                else if(arr[i-1]>j)
                    dp[i][j]=dp[i-1][j];
                else {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - arr[i - 1]];
                }
            }
        }
        return dp[n][sum];

    }
}
