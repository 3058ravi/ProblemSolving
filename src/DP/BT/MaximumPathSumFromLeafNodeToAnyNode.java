package DP.BT;

import utils.TNode;

public class MaximumPathSumFromLeafNodeToAnyNode {
    static int res;
    public static void main(String[] args) {

        TNode root = new TNode(1);
        root.left = new TNode(2);
        root.right = new TNode(3);
        root.left.left = new TNode(-8);
        root.left.right = new TNode(4);
        root.right.left = new TNode(5);
        root.right.right = new TNode(6);
        root.left.right.left = new TNode(-10);
        root.right.left.left = new TNode(-7);
        root.right.left.right = new TNode(-9);
        root.right.right.right = new TNode(-5);

        res = Integer.MIN_VALUE;
        maxPathSumLeafToAnyNode(root);
        System.out.println(res);
    }

    public static int maxPathSumLeafToAnyNode(TNode root) {
        if (root == null)
            return 0;
        int l = maxPathSumLeafToAnyNode(root.left);
        int r = maxPathSumLeafToAnyNode(root.right);
        int temp =Math.max( Math.max(l, r) + root.getData(), root.getData());
        int ans = Math.max(temp, l + r + root.getData());
        res = Math.max(res, ans);
        return temp;
    }
}
