package stack;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 6, 2, 3};
        System.out.println(findLargestRectangleInHistogram(arr));
    }

    public static int findLargestRectangleInHistogram(int[] arr) {
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
