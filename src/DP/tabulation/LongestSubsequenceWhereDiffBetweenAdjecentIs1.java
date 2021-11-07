package DP.tabulation;

public class LongestSubsequenceWhereDiffBetweenAdjecentIs1 {
    public static void main(String[] args){
      int  n = 7;
        int [] a = {10, 9, 4, 5, 4, 8, 6};

        System.out.println(longestSubsequenceWhereDiffBetweenAdjecentIs1(a, a.length));
    }

    public static int longestSubsequenceWhereDiffBetweenAdjecentIs1(int[] a, int n){
        int[] dp= new int[n];
        dp[0]=1;
        int max=1;
        for(int i=1; i<n; i++){
            for(int j=i-1; j>=0; j--){
                if(Math.abs(a[j]-a[i])==1)
                    dp[i]=Math.max(dp[i], dp[j]);
            }
            dp[i]+=1;
            max=Math.max(max, dp[i]);
        }
        return max;
    }
}
