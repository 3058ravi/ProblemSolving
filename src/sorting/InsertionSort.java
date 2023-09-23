package sorting;

import utils.CommonUtils;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {4, 8, 7, 6, 1, 2, 3, 9, 5};
        insertionSort(arr);
        CommonUtils.printArray(arr);
    }

    public static void insertionSort(int[] arr){
        for(int i=1; i<arr.length; i++){
            int key=arr[i];
            int j=i-1;

            while(j>=0 && arr[j]>key){
                arr[j+1]=arr[j];
                j=j-1;
            }
            arr[j+1]=key;
        }
    }

}
