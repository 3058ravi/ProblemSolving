package tree.BT;

import utils.CommonUtils;
import utils.TNode;

public class SumTree {
    public static void main(String[] args)
    {
        TNode root = new TNode(1);
        root.left = new TNode(2);
        root.right = new TNode(3);
        root.left.right = new TNode(4);
        root.right.left = new TNode(5);
        root.right.right = new TNode(6);
        root.right.left.left = new TNode(7);
        root.right.left.right = new TNode(8);

        convertToSumTree(root);
        CommonUtils.printPreOrderTree(root);
    }

    public static int convertToSumTree(TNode root){
        if(root==null){
            return 0;
        }
        int left =convertToSumTree(root.left);
        int right =convertToSumTree(root.right);
        int old=root.getData();
        root.setData(left+right);
        return root.getData()+old;
    }


}
