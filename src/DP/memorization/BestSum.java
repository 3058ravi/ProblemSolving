/*
Problem Statement: Add elements of an array to check if a target Sum can achieved with minimum number of elements.
This is solve using DP- memorization with O(m*n) time complexity and O(m) space complexity
 */
package DP.memorization;

import java.util.HashMap;

public class BestSum {
    public static void main(String[] args) {
        int[] arr = { 5,3,4, 7,1};
        HashMap<Integer, int[]> map = new HashMap<>();
        int[] result=bestSum(arr, 100, map);
        for(int num: result)
            System.out.print(num +" ");
    }

    public static int[] bestSum(int[] arr, int n, HashMap<Integer,int[]> map){
        if(map.containsKey(n))
            return map.get(n);
        if (n == 0)
            return new int[]{};
        if (n < 0)
            return null;
        int[] shortest=null;
        for (int num : arr) {
            int reminder = n - num;
            int[] result = bestSum(arr, reminder, map);
            if (result != null) {
                int[] new_result = new int[result.length + 1];
                System.arraycopy(result, 0, new_result, 0, result.length);
                new_result[result.length]=num;
                if(shortest==null || new_result.length<shortest.length)
                    shortest=new_result;
            }
        }
        map.put(n,shortest);
        return map.get(n);
    }
}
