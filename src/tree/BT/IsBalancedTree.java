package tree.BT;

import utils.TNode;

public class IsBalancedTree {
    public static void main(String[] args) {
        TNode root = new TNode(1);
        root.left = new TNode(2);
        root.right = new TNode(3);
        root.left.right = new TNode(4);
        root.right.left = new TNode(5);
        root.right.right = new TNode(6);
        root.right.left.left = new TNode(7);
        root.right.left.right = new TNode(8);

        if (isHeightBalanced(root)) {
            System.out.print("Binary tree is balanced");
        } else {
            System.out.print("Binary tree is not balanced");
        }
    }

    public static boolean isHeightBalanced(TNode root) {
        if (root == null)
            return true;

        isHeightBalanced(root.left);
        isHeightBalanced(root.right);

        int lHeight = height(root.left);
        int rHeight = height(root.right);

        if (Math.abs(lHeight - rHeight) > 1)
            return false;

        return true;
    }

    public static int height(TNode root) {
        if (root == null)
            return 0;
        else {
            int lHeight = height(root.left);
            int rHeight = height(root.right);

            if (lHeight > rHeight)
                return lHeight + 1;
            else
                return rHeight + 1;

        }
    }
}
