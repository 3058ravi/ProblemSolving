package DP.tabulation;

import java.util.Arrays;

public class PairWithSpecificDIfference {
    public static void main(String[] args){
        int arr[] = {3, 5, 10, 15, 17, 12, 9};
        int k=4;
        System.out.println(pairWithSpecificDifference(arr,k));
    }

    public static int pairWithSpecificDifference(int[] arr, int k){
        int n= arr.length;
        int[] dp = new int[n];
        Arrays.sort(arr);
        dp[0]=0;
        for(int i=1; i<n; i++){
            if(arr[i]-arr[i-1]<k){
                if(i>=2){
                    dp[i]=Math.max(dp[i-1], dp[i-2]+arr[i]+arr[i-1]);
                }else
                    dp[i]=Math.max(dp[i-1], arr[i]+arr[i-1]);
            }else{
                dp[i]=dp[i-1];
            }
        }
        return dp[n-1];
    }
}
