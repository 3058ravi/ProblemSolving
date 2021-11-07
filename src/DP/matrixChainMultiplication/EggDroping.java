package DP.matrixChainMultiplication;

import java.util.Arrays;
/*
1:1
2-3:2
4-7:3
8-14:4
15-25:5
26
 */
public class EggDroping {
    public static void main(String[] args){
        int f=100;
        int e=2;
        int[][] dp= new int[e+1][f+1];
        for(int i=0; i<=e; i++)
            Arrays.fill(dp[i],-1);
        System.out.println(eggDrop(e,f,dp));
    }

    public static int eggDrop(int e, int f, int[][] dp){
        if(e==0|| f==0 )
            return 0;
        if(e==1 || f==1)
            return f;
        if(dp[e][f]!=-1)
            return dp[e][f];
        dp[e][f]=Integer.MAX_VALUE;
        for(int i =1; i<=f; i++ ){
            int temp= 1+Math.max(eggDrop(e-1,i-1, dp), eggDrop(e, f-i, dp));
            dp[e][f]=Math.min(dp[e][f],temp);
        }
        return dp[e][f];
    }
}
