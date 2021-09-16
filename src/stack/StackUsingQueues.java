package stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {
    static Queue<Integer> q1 = new LinkedList<Integer>();
    static Queue<Integer> q2 = new LinkedList<Integer>();
    static int curr_size;

    StackUsingQueues()
    {
        curr_size = 0;
    }

    static void push(int x)
    {
        curr_size++;
        q2.add(x);

        // Push all the remaining
        // elements in q1 to q2.
        while (!q1.isEmpty()) {
            q2.add(q1.peek());
            q1.remove();
        }

        // swap the names of two queues
        Queue<Integer> q = q1;
        q1 = q2;
        q2 = q;
    }


    static int pop()
    {
        int x= Integer.MIN_VALUE;
        if (q1.isEmpty())
           System.out.println("Stack is empty");
        x=q1.peek();
        q1.remove();
        curr_size--;
        return x;
    }

    static int peek()
    {
        if (q1.isEmpty())
            return -1;
        return q1.peek();
    }
    static boolean isEmpty()
    {
        return curr_size<=0;
    }
    void print() {
        for(int  i : q1) {
            System.out.println(i);
        }
    }


    public static void main(String[] args){
        StackUsingQueues stack = new StackUsingQueues();
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
