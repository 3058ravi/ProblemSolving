package recursion;

import utils.CommonUtils;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {9, 7, 5, 3, 1, 8, 6, 4, 2};
        mergesort(arr, 0, arr.length - 1);
        CommonUtils.printArray(arr);
    }

    public static void mergesort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergesort(arr, left, mid);
            mergesort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }

        for(i=left; i<=right; i++)
            arr[i]=temp[i-left];
    }
}
