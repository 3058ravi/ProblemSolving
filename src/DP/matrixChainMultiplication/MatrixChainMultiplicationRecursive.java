package DP.matrixChainMultiplication;

import java.util.Arrays;

public class MatrixChainMultiplicationRecursive {
    static int[][] dp;
    public static void main(String[] args){
        int[] arr={40,20,30,10,30};
        int n= arr.length;
        dp= new int[n][n];
        for(int i=0; i<n; i++)
            Arrays.fill(dp[i],-1);
        System.out.println(matrixChainMultiplication(arr,1,arr.length-1));
    }

    public static int matrixChainMultiplication(int[] arr,int i,int j ){
        if(i>=j)
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
         dp[i][j]= Integer.MAX_VALUE;
        for(int k=i; k<j; k++){
            int temp=matrixChainMultiplication(arr, i, k)+matrixChainMultiplication(arr,k+1,j)+arr[i-1]*arr[k]*arr[j];
            dp[i][j]= Math.min(dp[i][j], temp);
        }
        return dp[i][j];
    }


}
