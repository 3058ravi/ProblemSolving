package utils;

public class TNode {
    int data;
    public TNode left;
    public TNode right;

    public TNode(){};
    public TNode(int data){
        this.data= data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TNode getLeft() {
        return left;
    }

    public void setLeft(TNode left) {
        this.left = left;
    }

    public TNode getRight() {
        return right;
    }

    public void setRight(TNode right) {
        this.right = right;
    }
}
