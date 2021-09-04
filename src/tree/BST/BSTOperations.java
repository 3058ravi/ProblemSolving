package tree.BST;

import utils.CommonUtils;
import utils.Node;
import utils.TNode;

public class BSTOperations {
    public static void main(String[] args) {
        int[] keys = {15, 10, 20, 8, 12, 16, 25};

        TNode root = null;
        for (int key : keys) {
            root = insert(root, key);
        }

        search(root, 12, null);
        CommonUtils.printInOrderTree(root);

        root=delete(root, 20);
        System.out.println("\n After deletion");
        CommonUtils.printInOrderTree(root);
    }

    public static TNode insert(TNode root, int key) {
        if (root == null) {
            return new TNode(key);
        }

        if (key < root.getData()) {
            root.left = insert(root.left, key);
        } else {
            root.right = insert(root.right, key);
        }

        return root;
    }

    public static void search(TNode root, int key, TNode parent) {
        if (root == null) {
            System.out.print("Key Not found");
            return;
        }

        if (root.getData() == key) {
            if (parent == null)
                System.out.println("Key " + key + " is found at root of tree");
            else if (key < parent.getData())
                System.out.println("Key " + key + " is at left child of " + parent.getData());
            else
                System.out.println("Key " + key + " is at right child of " + parent.getData());
            return;
        }

        if (key < root.getData())
            search(root.left, key, root);
        else
            search(root.right, key, root);


    }

    public static TNode delete(TNode root, int key) {
        TNode parent = null;
        TNode curr = root;

        while (curr != null && curr.getData() != key) {
            parent = curr;
            if (key < curr.getData())
                curr = curr.left;
            else
                curr = curr.right;

        }

        if (curr == null)
            return root;

        if (curr.left == null && curr.right == null) {
            if (curr != root) {
                if (parent.left == curr)
                    parent.left = null;
                else
                    parent.right = null;
            } else
                root = null;

        } else if (curr.left != null && curr.right != null) {
            TNode successor = getMinimum(curr.right);

            int val = successor.getData();
            delete(root, val);
            curr.setData(val);

        } else {
            TNode child = curr.left != null ? curr.left : curr.right;

            if (curr != root) {
                if (curr == parent.left)
                    parent.left = child;
                else
                    parent.right = child;
            } else
                root = child;
        }
        return root;
    }

    public static TNode getMinimum(TNode root) {
        while (root.left != null)
            root = root.left;

        return root;
    }
}
