package stack;

import utils.SNode;

public class StackUsingLinkedList {

    SNode root;

    boolean isEmpty() {
        return root==null ;
    }

    int peek() {
        if (root == null) {
            System.out.println("Stack is empty");
            return 0;
        }

        return root.getData();
    }

    void push(int data) {
        SNode sNode = new SNode(data);
        if (root == null) {
            root = sNode;
        } else {
            SNode temp = root;
            root = sNode;
            root.next = temp;
        }
    }

    int pop() {
        int x = Integer.MIN_VALUE;
        if (root == null) {
            System.out.println("Stack is empty");
        } else {
            x = root.getData();
            root = root.next;
        }
        return x;
    }

    void print() {
        SNode temp=root;
        while (temp!=null) {
            System.out.print(" " + temp.getData());
            temp=temp.next;
        }
    }

    public static void main(String[] args) {
        StackUsingLinkedList stack = new StackUsingLinkedList();
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
