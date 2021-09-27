package twoPointers;

import utils.CommonUtils;

public class SquaresOfSortedArray {
    public static void main(String[] args) {
        int[] a = {-3, -1, 0, 1, 2};
        CommonUtils.printArray(squaresOfSortedArray(a));
    }

    public static int[] squaresOfSortedArray(int[] a) {
        int right=0, left=0;
        int n = a.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            if (a[i] < 0) {
                left = i;
            }else
                break;
        }
       right=left+1;
        int k = 0;
        while (left >= 0 && right < n && k < n) {
            if (a[left] * a[left] < a[right] * a[right]) {
                res[k] = a[left] * a[left];
                left--;
            } else {
                res[k] = a[right] * a[right];
                right++;
            }
            k++;
        }
        while (left >= 0) {
            res[k] = a[left] * a[left];
            left--;
            k++;
        }
        while (right < n) {
            res[k] = a[right] * a[right];
            right++;
            k++;
        }
        return res;
    }
}

