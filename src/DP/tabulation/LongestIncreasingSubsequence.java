package DP.tabulation;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] arr = {10, 22, 9, 33, 21, 50, 41, 60};
        System.out.println(LIS(arr, arr.length));
    }

    public static int LIS(int[] arr, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j])
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++)
            max = Math.max(max, dp[i]);

        return max;
    }
}
