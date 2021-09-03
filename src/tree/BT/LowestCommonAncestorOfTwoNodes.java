package tree.BT;

import utils.TNode;

public class LowestCommonAncestorOfTwoNodes {
    public static void main(String[] args) {

        TNode root = new TNode(1);
        root.left = new TNode(2);
        root.right = new TNode(3);
        root.left.right = new TNode(4);
        root.right.left = new TNode(5);
        root.right.right = new TNode(6);
        root.right.left.left = new TNode(7);
        root.right.right.right = new TNode(8);

        findLCA(root, root.right.left.left, root.right.right);
        findLCA(root, root.right.left.left, new TNode(10));
        findLCA(root, root.right.left.left, root.right.left.left);
        findLCA(root, root.right.left.left, root.right.left);
        findLCA(root, root.left, root.right.left);
    }

    public static void findLCA(TNode root, TNode first, TNode second) {
        TNode lca = null;

        if (isNodePresent(root, first) && isNodePresent(root, second)) {
            lca=findLCA(root, lca, first, second);
        }
        if (lca != null) {
            System.out.println("Lowest common ancestor is:" + lca.getData());
        }else{
            System.out.println("Lowest common ancestor is not found");
        }
    }

    public static TNode findLCA(TNode root, TNode lca, TNode first, TNode second) {
        if (root == null)
            return null;
        if(root==first|| root==second){
            return root;
        }
        TNode left= findLCA(root.left, lca, first, second);
        TNode right= findLCA(root.right, lca, first, second);

        if(left!=null&&right!=null)
           return root;
        else if(left!=null)
            return left;
        else return right;

    }

    public static boolean isNodePresent(TNode root, TNode first) {
        if (root == null)
            return false;
        if (root == first)
            return true;
        else
            return isNodePresent(root.left, first) || isNodePresent(root.right, first);
    }
}
