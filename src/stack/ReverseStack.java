package stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ReverseStack {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5, -2, 9, -7, 3);

        Stack<Integer> stack = new Stack<>();
        stack.addAll(list);

        System.out.println("Stack before reversing: " + stack);
        reverseStack(stack);
        System.out.println("Stack after Reversing: " + stack);
    }

    public static void reverseStack(Stack<Integer> s){
        if(s.isEmpty())
            return;
        int top= s.pop();
        reverseStack(s);
        insertAtBottom(s, top);
    }

    public static void insertAtBottom(Stack<Integer> s, int key){
        if(s.isEmpty()) {
            s.push(key);
            return;
        }
        int top= s.pop();
        insertAtBottom(s,key);
        s.push(top);
    }
}
