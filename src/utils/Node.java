package utils;

public class Node {
    int data;
    public Node next;

    public Node(int data) {
        this.data = data;
    }

    public void setNext(Node node) {
        this.next = node;
    }

    public Node getNext() {
        return next;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}