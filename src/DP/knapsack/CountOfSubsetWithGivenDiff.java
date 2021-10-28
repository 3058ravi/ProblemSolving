package DP.knapsack;

public class CountOfSubsetWithGivenDiff {
    public static void main(String[] args){
        int[] arr={1,1,2,3};
        int diff=1;
        System.out.println(countSubsetWithGivenDiff(arr, diff));
    }

    public static int countSubsetWithGivenDiff(int[] arr, int diff){
        /*
        * lets assume two set s1 and s2 such that s2- s1= diff
        * since s2+s1=sum
        * 2*s2=diff +sum
        * s2= diff+sum /2
        */

        int n= arr.length;
        int sum=0;
        for(int i=0; i<n; i++)
            sum+=arr[i];
        int subsetSum=(sum+diff)/2;
        int[][] dp=new int[n+1][subsetSum+1];

        for(int i=0; i<=n; i++){
            for(int j=0; j<=subsetSum; j++){
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
        return dp[n][subsetSum];

    }
}
