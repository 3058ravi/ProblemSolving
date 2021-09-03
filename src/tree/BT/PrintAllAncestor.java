package tree.BT;

import utils.TNode;

public class PrintAllAncestor {

    public static void main(String[] args) {
        TNode root = new TNode(1);
        root.left = new TNode(2);
        root.right = new TNode(3);
        root.left.right = new TNode(4);
        root.right.left = new TNode(5);
        root.right.right = new TNode(6);
        root.right.left.left = new TNode(7);
        root.right.right.right = new TNode(8);

        int node= 7;
        printAncestors(root, node);
    }

    public static boolean printAncestors(TNode root, int find){
        if(root==null)
            return false;
        if(root.getData()==find)
            return true;
        boolean left=printAncestors(root.left,find);
        boolean right=false;
        if(!left)
            right=printAncestors(root.right,find);

        if(left||right)
            System.out.println(root.getData());

        return left||right;
    }


}
