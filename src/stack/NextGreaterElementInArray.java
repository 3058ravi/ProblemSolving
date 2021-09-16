package stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementInArray {
    public static void main(String[] args) {
        int[] input = {2, 7, 3, 5, 4, 6, 8};

        int[] result = findNextGreaterElements(input);
        System.out.println(Arrays.toString(result));
    }

    public static int[] findNextGreaterElements(int[] input) {
        if (input == null)
            return input;

        int n = input.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        Stack<Integer> s = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty()) {
                if (s.peek() <= input[i])
                    s.pop();
                else {
                    result[i] = s.peek();
                    break;
                }
            }
            s.push(input[i]);
        }
        return result;
    }
}
