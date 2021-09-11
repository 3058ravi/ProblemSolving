package LL;

import utils.CommonUtils;
import utils.TNode;

import javax.swing.tree.TreeNode;

public class ConvertBTIntoLL {

    static TNode prev=null;
    public static void main(String[] args){
        TNode root= new TNode(1);
        root.left=new TNode(2);
        root.left.left=new TNode(3);
        root.left.right=new TNode(4);
        root.right=new TNode(5);
        root.right.right=new TNode(6);
        convertBTintoLL(root);
        CommonUtils.printPreOrderTree(root);
    }

    public static void convertBTintoLL(TNode root){

            if(root==null)
                return;
            convertBTintoLL(root.right);
            convertBTintoLL(root.left);
            root.right=prev;
            root.left=null;
            prev=root;

    }
}
