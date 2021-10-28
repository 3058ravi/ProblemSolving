package DP.knapsack;

public class MinimumSubsetSumDifference {
    public static void main(String[] args){
        int[] arr={1,6,11,5};
        System.out.println(minimumSubsetSumDifference(arr));
    }

    public static int minimumSubsetSumDifference(int[] arr){
        int n= arr.length;
        int sum=0;
        for(int i=0; i<n; i++)
            sum+=arr[i];
        int half=sum/2;
        boolean[][] dp=new boolean[n+1][sum+1];
        for(int i=0; i<=n; i++){
            for(int j=0; j<=sum; j++){
                if(j==0)
                    dp[i][j]=true;
                else if(i==0 && j!=0)
                    dp[i][j]=false;
                else if(arr[i-1]>j)
                    dp[i][j]= dp[i-1][j];
                else
                    dp[i][j]=dp[i-1][j-arr[i-1]]||dp[i-1][j];
            }
        }
        int[] b= new int[half+1];
        int count=0;
        int min=Integer.MAX_VALUE;
        for(int i=1; i<=half; i++) {
            if (dp[n][i] == true)
                b[count++]=i;
            /*
            * TO minimize diff let assume S1 and s2
            * s2-s1= min
            * since s1+s2=sum
            * s2=sum-s1
            * hence first equation becomes sum-s1-s1=min
            * sum-2*s1=min
            * assuming s2 is always greater  s1 should always be less than sum/2
            * */
            min =Math.min(sum-2*i, min);
        }
        return min;
    }
}
