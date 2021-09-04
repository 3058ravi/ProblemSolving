package tree.BT;

import utils.TNode;

public class SpiralTraversal {
    public static void main(String[] args){
        TNode root = new TNode(15);
        root.left = new TNode(10);
        root.right = new TNode(20);
        root.left.left = new TNode(8);
        root.left.right = new TNode(12);
        root.right.left = new TNode(16);
        root.right.right = new TNode(25);

        spiralOrderTraversal(root);
    
    }

    public static void spiralOrderTraversal(TNode root){
        if(root==null)
            return;
        int level=1;
        while(leftToRightTraversal(root,level++) && rightToLeftTraversal(root, level++));
    }

    public static boolean leftToRightTraversal(TNode root, int level){
        if(root==null)
            return false;
        if(level==1){
            System.out.println(root.getData());
            return true;
        }


        boolean left = leftToRightTraversal(root.left, level - 1);
        boolean right = leftToRightTraversal(root.right, level - 1);

        return left||right;
    }

    public static boolean rightToLeftTraversal(TNode root, int level){
        if(root==null)
            return false;
        if(level==1){
            System.out.println(root.getData());
            return true;
        }


        boolean left = rightToLeftTraversal(root.right, level - 1);
        boolean right = rightToLeftTraversal(root.left, level - 1);

        return left||right;
    }

}
