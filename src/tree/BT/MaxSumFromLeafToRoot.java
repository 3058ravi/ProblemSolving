package tree.BT;

import utils.TNode;

public class MaxSumFromLeafToRoot {
    public static void main(String[] args)
    {

        TNode root = new TNode(1);
        root.left = new TNode(2);
        root.right = new TNode(3);
        root.left.left = new TNode(8);
        root.left.right = new TNode(4);
        root.right.left = new TNode(5);
        root.right.right = new TNode(6);
        root.left.right.left = new TNode(10);
        root.right.left.left = new TNode(7);
        root.right.left.right = new TNode(9);
        root.right.right.right = new TNode(5);

        findMaxSumPath(root);
    }

    public static void findMaxSumPath(TNode root){
        int sum= findMaxSum(root);
        System.out.println("Max sum is: "+sum);
        System.out.println("Max sum path is");
        printPath(root, sum);
    }

    public static int findMaxSum(TNode root){
        if(root==null)
            return 0;
        int left= findMaxSum(root.left);
        int right= findMaxSum(root.right);
        return (left>right?left:right)+root.getData();
    }

    public static boolean printPath(TNode node,int sum){
        if(sum==0)
            return true;
        if(node==null)
            return false;
        boolean left = printPath(node.left,sum-node.getData());
        boolean right = printPath(node.right,sum-node.getData());
        if(left||right)
            System.out.print(node.getData()+" ");

        return left||right;
    }
}
