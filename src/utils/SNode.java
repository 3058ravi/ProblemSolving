package utils;

public class SNode {

    int data;
   public SNode next;

    public SNode(int data) {
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
