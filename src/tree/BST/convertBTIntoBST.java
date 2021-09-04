package tree.BST;

import utils.CommonUtils;
import utils.TNode;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class convertBTIntoBST {
    public static void main(String[] args){
        TNode root = new TNode(8);
        root.left = new TNode(3);
        root.right = new TNode(5);
        root.left.left = new TNode(10);
        root.left.right = new TNode(2);
        root.right.left = new TNode(4);
        root.right.right = new TNode(6);

        // traverse the binary tree and store its keys in a set
        Set<Integer> set = new TreeSet<>();
        extractKeys(root, set);

        // put back keys present in the set to their correct order in the BST
        Iterator<Integer> it = set.iterator();
        convertToBST(root, it);

        // print the BST
        CommonUtils.printInOrderTree(root);
    }

    private static void convertToBST(TNode root, Iterator<Integer> it) {
        if(root==null)
            return;
        convertToBST(root.left,it);
        root.setData(it.next());
        convertToBST(root.right,it);

    }

    private static void extractKeys(TNode root, Set<Integer> set) {
        if(root==null)
            return;

        extractKeys(root.left,set);
        set.add(root.getData());
        extractKeys(root.right,set);

    }
}
