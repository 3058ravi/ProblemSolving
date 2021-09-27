package twoPointers;

import utils.CommonUtils;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args){
        int[] a={2,3,3,3,6,9,9};
        CommonUtils.printArray(removeDuplicatesFromSortedArray(a));
    }

    public static int[] removeDuplicatesFromSortedArray(int[] a){
        int left=0;
        int n=a.length;
        for(int right=0; right<n-1; right++){
            if(a[right]!=a[right+1]){
                a[left++]=a[right];
            }
        }
        a[left++]= a[n-1];

        return Arrays.copyOf(a,left);
    }
}
