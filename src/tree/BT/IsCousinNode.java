package tree.BT;

import utils.TNode;

public class IsCousinNode {
    static class NodeInfo {
        int key;
        int level;
        TNode parent = null;

        public NodeInfo(int key, int level, TNode parent) {
            this.key = key;
            this.level = level;
            this.parent = parent;
        }
    }

    public static void main(String[] args) {
        TNode root = new TNode(1);
        root.left = new TNode(2);
        root.right = new TNode(3);
        root.left.left = new TNode(4);
        root.left.right = new TNode(5);
        root.right.left = new TNode(6);
        root.right.right = new TNode(7);

        if (iterative(root, 5, 6)) {
            System.out.print("The given nodes are cousins");
        } else {
            System.out.print("The given nodes are not cousins");
        }
    }

    public static boolean iterative(TNode root, int e1, int e2) {
        if (root == null)
            return false;
        int level = 1;
        TNode parent = null;
        NodeInfo x = new NodeInfo(e1, level, parent);
        NodeInfo y = new NodeInfo(e2, level, parent);

        inorder(root, null, level, x, y);
        if (x.level != y.level || x.parent != y.parent)
            return false;

        return true;
    }

    public static void inorder(TNode root, TNode parent, int level, NodeInfo x, NodeInfo y) {
        if (root == null) {
            return;
        }

        inorder(root.left, root, level + 1, x, y);
        if (root.getData() == x.key) {
            x.level = level;
            x.parent = parent;
        }
        if (root.getData() == y.key) {
            y.level = level;
            y.parent = parent;
        }
        inorder(root.right, root, level + 1, x, y);
    }
}
