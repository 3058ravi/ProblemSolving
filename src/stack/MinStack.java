package stack;

import java.util.Stack;

public class MinStack {

    Stack<Integer> s = new Stack<>();
    private int minE;

    public void push(int x) {

        if (s.empty()) {
            s.push(x);
            minE = x;
        }else if (x > minE) {
            s.push(x);
        }else{
            s.push(2*x-minE);
            minE=x;
        }
    }

    public void pop() {
        if (s.empty()) {
            System.out.println("Stack underflow!!");
        }

        int top = s.peek();
        if (top < minE) {
            minE = 2*minE - top;
        }
        s.pop();
    }

    public int min(){
        return minE;
    }

    public static void main(String[] args) {
        MinStack s = new MinStack();

        s.push(6);
        System.out.println(s.min());    // prints 6

        s.push(7);
        System.out.println(s.min());    // prints 6

        s.push(8);
        System.out.println(s.min());    // prints 6

        s.push(5);
        System.out.println(s.min());    // prints 5

        s.push(3);
        System.out.println(s.min());    // prints 3

        s.pop();
        System.out.println(s.min());    // prints 5

        s.push(10);
        System.out.println(s.min());    // prints 5

        s.pop();
        System.out.println(s.min());    // prints 5

        s.pop();
        System.out.println(s.min());    // prints 6
    }
}
