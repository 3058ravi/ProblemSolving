package SlidingWindow;

public class MaxSumSubarrayOfSizeK {

    public static void main(String[] args) {
        int a[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println("Max Sum on K size array is: " + maxSumSubarrayOfSizeK(a, 3));

    }

    public static int maxSumSubarrayOfSizeK(int[] a, int k) {
        int n = a.length-1;
        int left=0;
        int max_sum=0, w_sum=0;
        for(int right=0; right<=n; right++){
            w_sum+=a[right];

            if(right>=k-1 ){
                max_sum=Math.max(max_sum,w_sum);
                w_sum-=a[left];
                left++;
            }
        }
        return max_sum;
    }
}
