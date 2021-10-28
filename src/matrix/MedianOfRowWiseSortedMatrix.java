package matrix;

import java.util.Arrays;

public class MedianOfRowWiseSortedMatrix {
    public static void main(String[] args) {
        int r = 3, c = 3;
        int m[][] = {{1, 3, 5}, {2, 6, 9}, {3, 6, 9}};

        System.out.println("Median is " + binaryMedian(m, r, c));
    }

    public static int binaryMedian(int[][] m, int r, int c) {
       int[] arr = new int[r*c];
       int count=0;
       for(int i=0; i<r; i++){
           for(int j=0; j<c; j++){
               arr[count++]=m[i][j];
           }
       }

       Arrays.sort(arr);
       return arr[(arr.length)/2];

    }

}
