package stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class SortAStack {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5, -2, 9, -7, 3);

        Stack<Integer> stack = new Stack<>();
        stack.addAll(list);

        System.out.println("Stack before sorting: " + stack);
        sortStack(stack);
        System.out.println("Stack after sorting: " + stack);
    }

    public static void sortStack(Stack<Integer> s) {
        if (s.isEmpty()) {
            return;
        }
        int top = s.pop();
        sortStack(s);
        insertSorted(s, top);
    }

    public static void insertSorted(Stack<Integer> s, int key) {
        if (s.isEmpty() || key > s.peek()) {
            s.push(key);
            return;
        }
        int top = s.pop();
        insertSorted(s, key);
        s.push(top);
    }
}
