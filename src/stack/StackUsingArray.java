package stack;

public class StackUsingArray {
    static final int MAX = 1000;
    int top;
    int a[] = new int[MAX];

    boolean isEmpty() {
        return top < 0;
    }

    StackUsingArray() {
        top = -1;
    }

    int peek() {
        if (top < 0) {
            System.out.println("Stack is empty");
            return 0;
        }

        return a[top];
    }

    boolean push(int data) {
        if (top ==MAX) {
            System.out.println("Stack is full");
            return false;
        }else{
            a[++top]=data;
            return true;
        }

    }

    int pop() {
        if (top < 0) {
            System.out.println("Stack is empty");
            return 0;
        }
        return a[top--];
    }

    void print() {
        for (int i = top; i > -1; i--) {
            System.out.print(" " + a[i]);
        }
    }

    public static void main(String[] args){
        StackUsingArray stack = new StackUsingArray();
        System.out.println("Is stack Empty: "+stack.isEmpty());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println("top of the stack"+stack.peek());
        System.out.println("removed from top of stack:"+ stack.pop());
        System.out.println("Is stack Empty: "+stack.isEmpty());
        stack.print();
    }
}
