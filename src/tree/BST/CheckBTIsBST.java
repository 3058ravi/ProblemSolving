package tree.BST;

import utils.CommonUtils;
import utils.TNode;

public class CheckBTIsBST {
    public static void main(String[] args){
        TNode root = new TNode(15);
        root.left = new TNode(10);
        root.right = new TNode(20);
        root.left.left = new TNode(8);
        root.left.right = new TNode(10);
        root.right.left = new TNode(16);
        root.right.right = new TNode(25);


        checkBTisaBST(root);
    }

    public static void checkBTisaBST(TNode root ){
        TNode prev = new TNode(Integer.MIN_VALUE);
        if(isBST(root,prev))
            System.out.println("Binary Tree is a BST");
        else
            System.out.println("Binary Tree is not a BST");
    }

    public static boolean isBST(TNode root, TNode prev){
        if(root==null)
            return true;
        boolean left=isBST(root.left,prev);
        if(root.getData()<=prev.getData())
            return false;
        prev.setData(root.getData());

        return left && isBST(root.right,prev);
    }

}
