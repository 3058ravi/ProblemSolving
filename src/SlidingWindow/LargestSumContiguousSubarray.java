package SlidingWindow;

public class LargestSumContiguousSubarray {

    public static void main(String[] args){
        int a[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        int n = a.length;
        int max_sum = maxSubArraySum(a, n);
        System.out.println("Maximum contiguous sum is "
                + max_sum);
    }

    public static int maxSubArraySum(int[] arr, int n){
        int max=arr[0];
        int curr=arr[0];

        for(int i=1; i<n; i++){
            curr=Math.max(arr[i],curr+arr[i]);
            max=Math.max(curr, max);
        }

        return max;
    }
}
