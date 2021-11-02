package DP.tabulation;

import java.util.Arrays;

public class MaximizeTheCutSegments {
    public static void main(String[] args)
    {
        int l = 11, p = 2, q = 3, r = 5;


        int ans = findMaximum(l, p, q, r);
        System.out.println(ans);
    }

    public static int findMaximum(int l, int p, int q, int r){
        int[] dp= new int[l+1];

        Arrays.fill(dp, -1);
        dp[0]=0;
        for(int i=0; i<=l; i++ ){
            if(dp[i]==-1)
                continue;

            if(i+p<=l)
            dp[i+p]=Math.max(dp[i+p],dp[i]+1);

            if(i+q<=l)
                dp[i+q]=Math.max(dp[i+q],dp[i]+1);

            if(i+r<=l)
                dp[i+r]=Math.max(dp[i+r],dp[i]+1);

        }
        return dp[l];
    }
}
