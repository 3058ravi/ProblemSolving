package stack;

import java.util.Arrays;
import java.util.List;

public class TwoStackInArray {
    private int[] arr;
    private int capacity;
    private int top1, top2;

    public TwoStackInArray(int n){
        capacity=n;
        arr= new int[capacity];
        top1=-1; top2= n;
    }

    public void push1(int key){
        if(top1+1==top2) {
            System.out.println("Stack overflow");
            System.exit(-1);
        }
        arr[++top1]=key;
    }

    public void push2(int key){
        if(top1+1==top2) {
            System.out.println("Stack overflow");
            System.exit(-1);
        }
        arr[--top2]=key;
    }

    public int pop1(){
        if(top1<0){
            System.out.println("Stack underflow");
            System.exit(-1);
        }

        return arr[top1--];
    }

    public int pop2(){
        if(top2>=capacity){
            System.out.println("Stack underflow");
            System.exit(-1);
        }

        return arr[top2++];
    }

    public static void main(String [] args){
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list2 = Arrays.asList( 6, 7, 8, 9, 10);

        TwoStackInArray stack = new TwoStackInArray(list1.size() + list2.size());

        for (int i: list1) {
            stack.push1(i);
        }

        for (int j: list2) {
            stack.push2(j);
        }

        System.out.println("Popping element from the first stack: "
                + stack.pop1());
        System.out.println("Popping element from the second stack: "
                + stack.pop2());
    }
}
