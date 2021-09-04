package sorting;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        int[] A = {9, 4, 7, 1, -2, 6, 5};
        heapSort(A);
        System.out.println(Arrays.toString(A));
    }

    public static void heapSort(int[] arr){
        int n=arr.length;
        int i = (arr.length - 2) / 2;
        while (i >= 0) {
            heapify(arr, i--, arr.length);
        }

        while (n > 0)
        {
            arr[n - 1] = pop(arr, n);
            n--;
        }
    }

    private static int LEFT(int i) {
        return (2 * i + 1);
    }

    private static int RIGHT(int i) {
        return (2 * i + 2);
    }

    private static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static void heapify(int[] arr, int i, int n){

        int left=LEFT(i);
        int right=RIGHT(i);

        int largest = i;
        if(left<n && arr[left]>arr[i])
            largest=left;

        if(right<n && arr[right]>arr[largest])
            largest=right;

        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, largest, n);
        }
    }

    public static int pop(int[] A, int size)
    {
        // if the heap has no elements
        if (size <= 0) {
            return -1;
        }

        int top = A[0];

        // replace the root of the heap with the last element
        // of the array
        A[0] = A[size-1];

        // call heapify-down on the root node
        heapify(A, 0, size - 1);

        return top;
    }
}
