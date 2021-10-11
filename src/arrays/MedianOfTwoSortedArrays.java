package arrays;

public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        int[] a = {1, 3};
        int[] b = {2};
        System.out.println(findMedianSortedArrays(a,b));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        if (n > m)
            return findMedianSortedArrays(nums2, nums1);


        int left = 0, right = n;
        while (left <= right) {
            int i = (right+left+1) / 2;
            int j = (n + m ) / 2 - i;

            int l1 = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int r1 = (i == n) ? Integer.MAX_VALUE : nums1[i];
            int l2 = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int r2 = (j == m) ? Integer.MAX_VALUE : nums2[j];

            if (l1 <= r2 && l2 <= r1) {
                if ((m + n) % 2 == 0)
                    return (double)(Math.max(l1, l2) + Math.min(r1, r2)) / 2;
                else
                    return Math.max(l1, l2);

            } else if (l2 > r1)
                left = i + 1;
            else
                right = i - 1;
        }

        return -1;

    }

}
