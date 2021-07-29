/*
Problem Statement: Add elements of an array to check if a target Sum can achieved.
This is solve using DP- memorization with O(m*n) time complexity and O(m) space complexity
 */
package DP.memorization;

import java.util.HashMap;

public class CanSum {
    public static void main(String[] args){
        int[] arr={7,14};
        HashMap<Integer, Boolean> map = new HashMap<>();
        System.out.println(canSum(arr, 300, map));
    }

    public static boolean canSum(int[] arr, int n, HashMap<Integer,Boolean> map){
        if(map.containsKey(n))return map.get(n);
        if (n==0)
            return true;
        if(n<0)
            return false;
        for(int num: arr){
            int reminder=n-num;
            if(canSum( arr, reminder, map)==true){
                map.put(n,true);
                return true;
            }
        }

        map.put(n,false);
        return false;
    }
}
