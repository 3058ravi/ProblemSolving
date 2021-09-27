package twoPointers;

import utils.CommonUtils;

public class Sorting012 {
    public static void main(String[] args) {
        int[] a = {1, 0, 2, 1, 0};
        CommonUtils.printArray(sorting012(a));
    }

    public static int[] sorting012(int[] a) {
        int low = 0;
        int high = a.length - 1;
        for (int i = 0; i < high; ) {
            if (a[i] == 0) {
                swap(a, i, low);
                i++;
                low++;

            }else if(a[i]==1)
                i++;
            else{
                swap(a,i,high);
                high--;
            }
        }
        return a;
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
