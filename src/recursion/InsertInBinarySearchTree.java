package recursion;

import utils.CommonUtils;
import utils.TNode;

public class InsertInBinarySearchTree {
    public static void main(String[] args){
        TNode head= new TNode(100);
        head.left= new TNode(80);
        head.left.left= new TNode(50);
        head.left.right= new TNode(90);
        head.left.left.left= new TNode(30);
        head.left.left.right= new TNode(60);
        head.right= new TNode(120);
        head.right.left= new TNode(110);
        head.right.right= new TNode(130);
        head.right.left.right= new TNode(115);
        head.right.right.right= new TNode(150);

        CommonUtils.printInOrderTree(head);
        TNode curr= insertInBinarySearchTree(head, 105);
        System.out.println("\nAfter insertion");
        CommonUtils.printInOrderTree(head);

    }

    public static TNode insertInBinarySearchTree(TNode head, int key){
        if(head==null){
            head = new TNode(key);
            return head;
        }
        if(head.getData()<key){
            head.right=insertInBinarySearchTree(head.right, key);
            return head;
        }else {
            head.left=insertInBinarySearchTree(head.left, key);
            return head;
        }
    }
}
