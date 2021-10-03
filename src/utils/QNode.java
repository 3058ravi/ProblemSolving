package utils;

public class QNode {

    int data;
   public QNode next;

    public QNode(int data) {
        this.data = data;
        next=null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
