package DP.knapsack;

public class EqualSumSubsetPartition {
    public static void main(String [] args){
        int[] arr={1,5,11,5};
        System.out.println(equalSumPartition(arr));
    }

    public static boolean equalSumPartition(int[] arr){
        int sum=0;
        int n= arr.length;
        for(int i=0; i<n; i++)
            sum+=arr[i];

        if(sum%2==1)
            return false;

        sum=sum/2;
        boolean[][] dp=new boolean[n+1][sum+1];

        for(int i=0; i<=n; i++){
            for(int j=0; j<=sum; j++){
                if(i==0||j==0)
                    dp[i][j]=false;
                else if(arr[i-1]>j)
                    dp[i][j]=dp[i-1][j];
                else if(arr[i-1]==j)
                    dp[i][j]=true;
                else
                    dp[i][j]=dp[i-1][j]||dp[i-1][j-arr[i-1]];
            }
        }
        return dp[n][sum];

    }
}
