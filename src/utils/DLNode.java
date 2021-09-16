package utils;

/* Node implementation for Doubly Linked List */
public class DLNode {
    int data;
    public DLNode next, prev;

    public DLNode(int d) {
        data = d;
        next = prev = null;
    }

    public DLNode(int d, DLNode prev) {
        data = d;
        this.prev=prev;
        next =null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public DLNode getNext() {
        return next;
    }

    public void setNext(DLNode next) {
        this.next = next;
    }

    public DLNode getPrev() {
        return prev;
    }

    public void setPrev(DLNode prev) {
        this.prev = prev;
    }
}
