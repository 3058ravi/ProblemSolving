package backtracking;

import java.util.Arrays;

public class SubsetSum {
    public static void main(String[] args) {
        int[] arr = {15, 22, 14, 26, 32, 9, 16, 8};
        int target_sum = 53;
        subsetSum(arr, target_sum);
    }

    public static void subsetSum(int[] arr, int target_sum) {
        Arrays.sort(arr);
        int totalSum = 0;
        int[] sol = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            totalSum += arr[i];
        }
        if (arr[0] <= target_sum && totalSum >= target_sum)
            subsetSumUtil(arr, sol, 0,0, 0, target_sum);

    }

    public static void printSolution(int[] sol,int count) {
        for (int i = 0; i <count; i++) {
            System.out.print(sol[i] + "  ");
        }
        System.out.println("");
    }

    public static void subsetSumUtil(int[] arr, int[] sol,int sol_count, int curr_sum, int count, int target_sum) {
        if (curr_sum == target_sum) {
            printSolution(sol,sol_count);
            if (count < arr.length && curr_sum - arr[count] + arr[count + 1] <= target_sum) {
                subsetSumUtil(arr, sol, sol_count-1,curr_sum - arr[count], count + 1, target_sum);
            }
            return;
        }
        else {
            if(count<arr.length && curr_sum+arr[count]<=target_sum){
                for(int i=count; i<arr.length; i++){
                    sol[sol_count]=arr[i];
                    if(curr_sum+arr[count]<=target_sum){
                        subsetSumUtil(arr, sol,sol_count+1,curr_sum+arr[i],i+1,target_sum);
                    }
                }
            }else{
                return;
            }
        }
    }
}
