package searching;

import utils.CommonUtils;

public class BinarySearch {

    /* main method */
    public static void main(String[] args) {
        int[] arr = {4, 8, 7, 6, 1, 2, 3, 9, 5};
        search(arr,9);
    }
    /* Binary search method */
    public static void search(int[] arr, int key) {
        int start = 0, end = arr.length - 1;
        int count = 0;
        int mid;

        while (start <= end) {
            mid = (start + end) / 2;

            if (arr[mid] == key) {
                count++;
                System.out.println(key + " found at index " + mid + " in " + count + " operations");
                return;
            } else if (arr[mid] < key) {
                start = mid + 1;
            } else if (arr[mid] > key) {
                end = mid - 1;
            }
            count++;
        }
        System.out.println(key + " is not found in the given array ");
    }
}
