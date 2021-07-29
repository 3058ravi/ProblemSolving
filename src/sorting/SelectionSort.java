package sorting;

import utils.CommonUtils;

public class SelectionSort {

    /* main method */
    public static void main(String[] args) {
        int[] arr = {4, 8, 7, 6, 1, 2, 3, 9, 5};
        sort(arr);
        CommonUtils.printArray(arr);
    }
    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min_index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min_index])
                    min_index = j;
            }
            int temp = arr[min_index];
            arr[min_index] = arr[i];
            arr[i] = temp;
        }
    }
}
