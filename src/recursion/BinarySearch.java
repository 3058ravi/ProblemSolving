package recursion;

public class BinarySearch {

    /* main method */
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        int k= search(arr,0, arr.length-1, 10);
        System.out.println(k<0?"Key not found in array":"key is found at index "+k);
    }
    /* Binary search method */
    public static int search(int[] arr, int left, int right, int key) {

        if (left > right)
            return -1;

        int mid = (left + right) / 2;

        if (arr[mid] == key)
            return mid;

        if(key<arr[mid])
           return search(arr,left,mid-1, key);

        return search(arr,mid+1, right, key);

    }
}
