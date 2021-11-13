package tree.heap;

import utils.TNode;

public class CheckBinaryTreeIsAHeap {
    public static void main(String[] args){
        TNode root = new TNode(10);
        root.left = new TNode(9);
        root.right = new TNode(8);
        root.left.left = new TNode(7);
        root.left.right = new TNode(6);
        root.right.left = new TNode(5);
        root.right.right = new TNode(4);
        root.left.left.left = new TNode(3);
        root.left.left.right = new TNode(2);
        root.left.right.left = new TNode(1);

        System.out.println(checkBinaryTreeIsAHeap(root));
    }

    public static boolean checkBinaryTreeIsAHeap(TNode root){
        if(root==null)
            return true;

        int nodecount=nodeCount(root);
        return isMaxHeap(root) && isComplete(root,0, nodecount);
    }

    public static boolean isMaxHeap(TNode root){
        if(root.left==null && root.right==null)
            return true;

        if(root.right==null )
            return root.getData()>=root.left.getData();
        else{
            if(root.getData()>=root.left.getData() && root.getData()>=root.right.getData())
                return isMaxHeap(root.left)&& isMaxHeap(root.right);
            else
                return false;
        }
    }

    public static boolean isComplete(TNode root, int index, int nodeCount){
        if(root==null)
            return true;

        if(index>=nodeCount)
            return false;

        return isComplete(root.left,2*index+1,nodeCount) && isComplete(root.right, 2*index+2, nodeCount);
    }

    public static int nodeCount(TNode root){
        if(root==null)
            return 0;
        return 1+nodeCount(root.left)+nodeCount(root.right);
    }
}
