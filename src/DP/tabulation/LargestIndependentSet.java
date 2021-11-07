package DP.tabulation;

import utils.TNode;

public class LargestIndependentSet {
    public static void main(String[] args){
        TNode root= new TNode(1);
         root.left= new TNode(2);
        root.left.left= new TNode(3);
        root.left.right= new TNode(4);
        root.left.right.left= new TNode(5);
        root.left.right.right= new TNode(6);
        root.right= new TNode(7);
        root.right.right= new TNode(8);

        System.out.println(largestIndependentSet(root));
    }
    public static int largestIndependentSet(TNode root){
        if(root==null)
            return 0;

        int size_child= largestIndependentSet(root.left)+largestIndependentSet(root.right);
        int size_gchild=1;
        if(root.left!=null){
            size_gchild+=largestIndependentSet(root.left.left)+largestIndependentSet(root.left.right);
        }
        if(root.right!=null){
            size_gchild+=largestIndependentSet(root.right.left)+largestIndependentSet(root.right.right);
        }

        return Math.max(size_child,size_gchild);
    }
}
