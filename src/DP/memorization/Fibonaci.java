/*
Problem Statement: find nth Fibonacci number.
This is solve using DP- memorization with O(n) time complexity and O(n) space complexity
 */

package DP.memorization;

import java.util.HashMap;

public class Fibonaci {
    public static void main(String[] args){
        HashMap<Integer, Long> map= new HashMap<>();
        long n= fib(51, map);
        System.out.println(n);
    }

    public static long fib(int n, HashMap<Integer, Long> map){
        if(map.containsKey(n))
            return (long) map.get(n);

        if(n<=2)
            return 1;

        long m = (long)fib(n-1,map)+fib(n-2,map);

        map.put(n,m);
        return map.get(n);
    }
}
