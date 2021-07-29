package DP.tabulation;

import java.util.Arrays;

public class Fibonacci {

    public static void main(String[] args){
        System.out.println( fib(100));
    }

    public static long fib(int n){
        long[] arr = new long[n+2];
        Arrays.fill(arr,0);
        arr[1]=1;
        for(int i=0; i<n; i++){
            arr[i+1] += arr[i];
            arr[i+2] += arr[i];
        }
        return arr[n];
    }
}
