package tree.BT;

import utils.TNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BTIsASubTreeOfAnotherBT {

    public static void main(String[] args)
    {
        TNode root = new TNode(1);
        root.left = new TNode(2);
        root.right = new TNode(3);
        root.left.left = new TNode(4);
        root.left.right = new TNode(5);
        root.right.left = new TNode(6);
        root.right.right = new TNode(7);

        if (checkSubtree(root, root.right)) {
            System.out.print("Yes, child tree is subset of parent tree");
        }
        else {
            System.out.print("No. child tree is not subset of parent tree ");
        }
    }

    public static boolean checkSubtree(TNode parent, TNode child){
        if(parent==child)
            return true;
        if(parent==null)
            return false;

        List<TNode> first= new ArrayList<>();
        List<TNode> second= new ArrayList<>();

        inorder(parent,first);
        inorder(child,second);

        if(!toString(first).contains(toString(second)))
            return false;
        first.clear();
        second.clear();

        postOrder(parent,first);
        postOrder(child,second);

        if(!toString(first).contains(toString(second)))
            return false;

        return true;
    }

    public static void inorder(TNode root, List<TNode> list){
        if(root==null)
            return;
        inorder(root.left,list);
        list.add(root);
        inorder(root.right,list);

    }

    public static void postOrder(TNode root, List<TNode> list){
        if(root==null)
            return;
        postOrder(root.left,list);
        postOrder(root.right,list);
        list.add(root);

    }

    public static String toString(List<TNode> list){
        if(list==null)
            return "";
        return list.toString().replace("[","").replace("]","");
    }
}
