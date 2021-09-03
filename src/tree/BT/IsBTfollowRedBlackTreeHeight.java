package tree.BT;

import utils.TNode;

public class IsBTfollowRedBlackTreeHeight {

    public static void main(String[] args)
    {
        TNode root = new TNode(1);
        root.left = new TNode(2);
        root.right = new TNode(3);
        root.left.left = new TNode(4);
        root.right.left = new TNode(5);
        root.right.right = new TNode(6);
        root.right.left.left = new TNode(7);
        root.right.left.right = new TNode(8);
        root.right.left.left.left = new TNode(9);
        root.right.left.left.right = new TNode(10);

        int root_h=0;

        if (isHeightBalanced(root, root_h)) {
            System.out.print("The given binary tree is height-balanced");
        }
        else {
            System.out.print("The given binary tree is not height-balanced");
        }
    }

    public static boolean isHeightBalanced(TNode root,int root_h){
        if(root==null)
            return true;
        int left_h=0;
        int right_h=0;
        if(isHeightBalanced(root.left,root_h)&&isHeightBalanced(root.right,right_h)){
            int min=Math.min(left_h,right_h)+1;
            root_h=Math.max(left_h,right_h)+1;
            return root_h<=2*min;
        }
        return false;
    }

}
