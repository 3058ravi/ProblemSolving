package utils;

/* Node implementation for single Linked List */

public class ListNode {
    int data;
    public ListNode next;

    public ListNode(int data) {
        this.data = data;
    }

    public void setNext(ListNode ListNode) {
        this.next = ListNode;
    }

    public ListNode getNext() {
        return next;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}