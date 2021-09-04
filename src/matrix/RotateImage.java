package matrix;

import utils.CommonUtils;

public class RotateImage {

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4},
                        {5, 6, 7, 8},
                        {9, 10, 11, 12},
                {13,14,15,16}};

        CommonUtils.printArray(arr);
        rotateArray(arr);
        System.out.println("Array after rotation");
        CommonUtils.printArray(arr);
    }

    public static void rotateArray(int[][] arr) {
        swapRowsIntoCol(arr);
        swapCols(arr);
    }

    public static void swapCols(int[][] arr) {
        int start = 0, end = arr.length - 1;
        while (start < end) {
            for (int i = 0; i <= arr.length - 1; i++) {
                int temp = arr[i][start];
                arr[i][start] = arr[i][end];
                arr[i][end] = temp;
            }
            start++;
            end--;
        }
    }

    public static void swapRowsIntoCol(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;

            }
        }
    }


}
