/*
Problem Statement: Move from start of the 2D array to end of size m*n. you can only move down or towards right from any given point
This is solve using DP- memorization with O(m*n) time complexity and O(m) space complexity
 */

package DP.memorization;

import java.util.HashMap;

public class GridTraveller {
    public static void main(String[] args){
        HashMap<String, Long> map = new HashMap<>();
        long paths = gridSolve( 18,  18, map);
        System.out.println(paths);
    }

    public static long gridSolve(int m, int n, HashMap<String,Long> map){
    String key= m+","+n;
    if(map.containsKey(key)) return map.get(key);
    if(m==1&&n==1) return 1;
    if(m==0 || n==0) return 0;
    long value= gridSolve(m-1,n, map)+gridSolve(m,n-1, map);
    map.put(key,value);
    return map.get(key);
    }
}
