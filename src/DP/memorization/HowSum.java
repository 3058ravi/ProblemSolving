/*
Problem Statement: Add elements of an array to check if a target Sum can achieved and return the sequence on numbers to be added.
This is solve using DP- memorization with O(m*n) time complexity and O(m) space complexity
 */

package DP.memorization;

import java.util.HashMap;

public class HowSum {
    public static void main(String[] args) {
        int[] arr = { 5,3,4, 7};
        HashMap<Integer, int[]> map = new HashMap<>();
        int[] result=howSum(arr, 7, map);
        for(int num: result)
            System.out.print(num +" ");
    }

    public static int[] howSum(int[] arr, int n, HashMap<Integer, int[]> map) {
        if(map.containsKey(n))
            return map.get(n);
        if (n == 0)
            return new int[]{};
        if (n < 0)
            return null;


        for (int num : arr) {
            int reminder = n - num;
            int[] result = howSum(arr, reminder, map);
            if (result != null) {
                int[] new_result = new int[result.length + 1];
                System.arraycopy(result, 0, new_result, 0, result.length);
                new_result[result.length]=num;
                map.put(n,new_result);
                return map.get(n);

            }
        }
        map.put(n,null);
        return null;
    }
}
