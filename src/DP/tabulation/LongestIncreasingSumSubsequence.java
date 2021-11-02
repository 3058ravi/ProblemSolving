package DP.tabulation;

public class LongestIncreasingSumSubsequence {
    public static void main(String[] args) {
        int[] arr = {1, 101,2,3,100};
        System.out.println(LISS(arr, arr.length));
    }
    public static int LISS(int[] arr, int n){
        int[] dp= new int[n];
        dp[0]=arr[0];
        for(int i=1;i<n; i++){
            for(int j=0; j<i; j++){
                if(arr[i]>arr[j])
                    dp[i]=Math.max(dp[i], dp[j]+arr[i]);
            }

        }
        int max=0;
        for(int i=0; i<n; i++)
            max= Math.max(max, dp[i]);

        return max;
    }
}
