package tree.BT;

import utils.TNode;

public class PrintBoundaryTraversal {
        public static void main(String[] args)
        {
            // construct a binary tree as per the above diagram
            TNode root = new TNode(1);
            root.left = new TNode(2);
            root.right = new TNode(3);
            root.left.left = new TNode(4);
            root.left.right = new TNode(5);
            root.right.left = new TNode(6);
            root.right.right = new TNode(7);
            root.left.left.left = new TNode(8);
            root.left.left.right = new TNode(9);
            root.left.right.right = new TNode(10);
            root.right.right.left = new TNode(11);
            root.left.left.right.left = new TNode(12);
            root.left.left.right.right = new TNode(13);
            root.right.right.left.left = new TNode(14);

            performBoundaryTraversal(root);
        }

    public static void performBoundaryTraversal(TNode root){
            if(root==null)
                return;
            System.out.print(root.getData()+" ");
            leftBoundaryTraversal(root.left);
            if(!isLeaf(root))
                printLeafNodes(root);

            rightBoundaryTraversal(root.right);
    }

    public static void printLeafNodes(TNode root){
            if(root==null)
                return;
            printLeafNodes(root.left);

            if(isLeaf(root))
                System.out.print(root.getData()+" ");

        printLeafNodes(root.right);
    }

    public static void leftBoundaryTraversal(TNode root){
        TNode node = root;
        while (!isLeaf(node)){
            System.out.print(node.getData()+" ");
            node= (node.left!=null)?node.left:node.right;
        }
    }

    public static void rightBoundaryTraversal(TNode root){
        TNode node = root;
        while (!isLeaf(node)){
            System.out.print(node.getData()+" ");
            node= (node.right!=null)?node.right:node.left;
        }
    }

    public static boolean isLeaf(TNode root){
        return (root.left==null && root.right==null);
    }
}
