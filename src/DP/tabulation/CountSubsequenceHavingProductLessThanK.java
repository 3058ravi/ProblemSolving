package DP.tabulation;

public class CountSubsequenceHavingProductLessThanK {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int k = 10;
        System.out.println(countOfSubsequenceHavingProductLessThanK(arr, k));
    }

    public static int countOfSubsequenceHavingProductLessThanK(int[] arr, int k) {
        int n = arr.length;
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if (arr[i - 1] <= j && arr[i - 1] > 0)
                    dp[i][j] = dp[i-1][j]+ dp[i - 1][j / arr[i - 1]] + 1;
                else
                    dp[i][j]=dp[i-1][j];
            }
        }

        return dp[n][k];
    }
}
