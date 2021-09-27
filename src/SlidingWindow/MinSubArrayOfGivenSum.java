package SlidingWindow;

public class MinSubArrayOfGivenSum {
    public static void main(String[] args) {
        int a[] = {2, 1, 5, 2, 3, 2};
        System.out.println("Max Sum on K size array is: " + minSubArrayOfGivenSum(a, 7));

    }

    public static int minSubArrayOfGivenSum(int[] a, int k){
        int n = a.length-1;
        int left=0;
        int min=Integer.MAX_VALUE, sum=0;
        for(int right=0; right<=n; right++){
            sum+=a[right];

            while(sum>=k ){
                min=Math.min(min,right-left+1);
                sum-=a[left];
                left++;
            }
        }
        return min==Integer.MAX_VALUE?0:min;
    }
}
