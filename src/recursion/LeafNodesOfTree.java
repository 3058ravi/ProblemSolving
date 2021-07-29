package recursion;

import utils.TNode;

public class LeafNodesOfTree {
    public static void main(String[] args) {
        TNode head = new TNode(100);
        head.left = new TNode(80);
        head.left.left = new TNode(50);
        head.left.right = new TNode(90);
        head.left.left.left = new TNode(30);
        head.left.left.right = new TNode(60);
        head.right = new TNode(120);
        head.right.left = new TNode(110);
        head.right.right = new TNode(130);
        head.right.left.right = new TNode(115);
        head.right.right.right = new TNode(150);

        printLeafNodes(head);
    }
    public static void printLeafNodes(TNode head){
        if(head== null) return;
         if(head.left==null&& head.right==null){
             System.out.println(head.getData());
             return;
         }
             if(head.left!=null)
                 printLeafNodes(head.left);
             if(head.right!=null)
                 printLeafNodes(head.right);

    }
    }
