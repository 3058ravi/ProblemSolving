package sorting;

import utils.CommonUtils;

public class QuickSort {
    /* main method */
    public static void main(String[] args) {
        int[] arr = {4, 8, 7, 6, 1, 2, 3, 9, 5};
        sort(arr,0, arr.length-1);
        CommonUtils.printArray(arr);
    }

    public static void sort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = pivot(arr, low, high);
            sort(arr, low, pivot - 1);
            sort(arr, pivot + 1, high);
        }
    }

     static int pivot(int[] arr, int low, int high){
        int pivot=arr[high];
        int i=low-1;
        for( int j=low; j<high-1; j++){
            if(arr[j]<pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr,i+1,high);
        return (i+1);
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}