package tree.BT;

import utils.CommonUtils;
import utils.TNode;

public class InvertBT {
    public static TNode invertTree(TNode root) {
        if (root == null)
            return root;

        TNode temp;

        if (root.left != null)
            invertTree(root.left);
        if (root.right != null)
            invertTree(root.right);

        temp = root.right;
        root.right = root.left;
        root.left = temp;

        return root;
    }

    public static void main(String [] args){
        TNode root = new TNode(1);
        root.left = new TNode(2);
        root.right = new TNode(3);
        root.left.left = new TNode(4);
        root.left.right = new TNode(5);
        root.right.left = new TNode(6);
        root.right.right = new TNode(7);


        LevelOrderTraversal.printLevelOrder(root);
        invertTree(root);
        System.out.println("after inversion");
        LevelOrderTraversal.printLevelOrder(root);
    }

}
