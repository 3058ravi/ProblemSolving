package DP.tabulation;

import java.util.Arrays;

public class MinCostToFillABag {

public static void main(String[] args){
    /*
    given an array of costs for n items . n being denoted by index.
    W is the total weight/capacity of bag.
    find min cost to fill the bag.
     */
    int[] c={20,10,4,50,100};
    int W=4;
    System.out.println(minCostToFillBag(c,W));
}

public static int minCostToFillBag(int[] c , int w){
    int n= c.length;
    int dp[][] =new int[n+1][w+1];
//    for(int i=1; i<=n; i++)
//        Arrays.fill(dp[i],Integer.MAX_VALUE);

    for(int i=0; i<=n; i++){

        for(int j=0; j<=w; j++){
           if(i==0)
               dp[i][j]=Integer.MAX_VALUE;
           else if(j==0 && i!=0)
               dp[i][j]=0;
            else if(i>j)
                dp[i][j]= dp[i-1][j];

            else{
                dp[i][j]= Math.min(c[i-1]+Math.min(dp[i][j-i],dp[i-1][j-i]),dp[i-1][j]);
            }
        }

    }
    return dp[n][w];
}
}
