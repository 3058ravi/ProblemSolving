package DP.tabulation;

public class FriendsPairing{
    public static void main(String[] args){
        /*
        given n friends.
        Find number of combination in which friends can be paired or not.
         */
        System.out.println(friendsPair(6));
    }

    public static int friendsPair(int n){
        int[] dp = new int[n+1];
        dp[1]=1;
        dp[2]=2;
        if(n==1|| n==2)
            return n;
        for(int i=3; i<=n; i++){
            dp[i]= dp[i-1]+dp[i-2]*(i-1);
        }
        return dp[n];
    }
}
