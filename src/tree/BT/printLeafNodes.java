package tree.BT;

import utils.TNode;

import java.util.Deque;
import java.util.LinkedList;

class printLeafTNodes {
    public static void main(String[] args)
    {
       

        TNode root = new TNode(1);
        root.left = new TNode(2);
        root.right = new TNode(3);
        root.left.left = new TNode(4);
        root.left.right = new TNode(5);
        root.right.left = new TNode(6);
        root.right.right = new TNode(7);
        root.right.left.left = new TNode(8);
        root.right.right.right = new TNode(9);

        // print all root-to-leaf paths
        printRootToLeafPaths(root);
    }

    public static void printRootToLeafPaths(TNode root){
        Deque<Integer> deque = new LinkedList<>();
        printRootToLeafPaths(root, deque);
    }

    public static void printRootToLeafPaths(TNode root, Deque<Integer> deque){
        if(root==null)
            return;
        deque.add(root.getData());
        // if a leaf node is found, print the path
        if (isLeaf(root)) {
            System.out.println(deque);
        }

        printRootToLeafPaths(root.left, deque);
        printRootToLeafPaths(root.right, deque);
        deque.removeLast();
    }

    public static boolean isLeaf(TNode root){
        return (root.left==null && root.right==null);
    }
}
