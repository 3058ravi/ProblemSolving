package tree.BT;

import utils.TNode;

public class IsBTSymmetric {
    public static void main(String[] args)
    {

        TNode root = new TNode(1);
        root.left = new TNode(2);
        root.right = new TNode(3);
        root.left.right = new TNode(4);
        root.right.left = new TNode(5);

        if (isSymmetric(root)) {
            System.out.print("The binary tree is symmetric");
        }
        else {
            System.out.print("The binary tree is not symmetric");
        }
    }

    public static boolean isSymmetric(TNode root){
        return isSymmetric(root.left, root.right);
    }

    public static boolean isSymmetric(TNode x, TNode y){
        if (x==null && y ==null)
            return true;
        return (x!=null && y!=null) &&isSymmetric(x.left,y.right) && isSymmetric(x.right,y.left);
    }
}
