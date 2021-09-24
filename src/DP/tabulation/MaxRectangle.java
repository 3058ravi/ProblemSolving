package DP.tabulation;

import java.util.Stack;

public class MaxRectangle {
    public static void main(String[] args){
        int[][] matrix = {  {1,0,1,0,0},
                            {1,0,1,1,1},
                            {1,1,1,1,1},
                            {1,0,0,1,0}};
        System.out.println(maxRectangle(matrix));
    }

    public static int maxRectangle(int[][] matrix){
        if(matrix==null||matrix.length==0||matrix[0]==null||matrix[0].length==0)
            return 0;
        int max_area=0;
        int[] dp= new int[matrix[0].length];
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j]==0)
                    dp[j]=0;
                else
                    dp[j]++;
            }
            max_area=Math.max(max_area,maxArea(dp));
        }
        return max_area;
    }

    public static int maxArea(int[] arr){
        int len = arr.length;
        Stack<Integer> stack = new Stack<>();
        int max_area = 0;
        int top;
        for (int i = 0; i <= len; i++) {
            int h = (i == len ? 0 : arr[i]);
            if (stack.isEmpty() || h > arr[stack.peek()]) {
                stack.push(i);
            } else {
                top = stack.pop();
                max_area = Math.max(max_area, arr[top] * (stack.isEmpty() ? i : i - 1 - stack.peek()));
                i--;
            }
        }
        return max_area;
    }
}
