package utils;

public class LNode {
    int data;
    public LNode next;

    public LNode(int data) {
        this.data = data;
    }

    public void setNext(LNode LNode) {
        this.next = LNode;
    }

    public LNode getNext() {
        return next;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}