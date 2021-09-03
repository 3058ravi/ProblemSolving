package tree.BT;

import utils.TNode;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversalUsingQueue {
    public static void main(String args[]) {
        TNode root = new TNode(1);
        root.left= new TNode(2);
        root.right= new TNode(3);
        root.left.left= new TNode(4);
        root.left.right= new TNode(5);

        System.out.println("Level order traversal of binary tree is ");
        printLevelOrder(root);
    }

    public static void printLevelOrder(TNode root){
        Queue<TNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TNode temp=q.poll();
            System.out.println(temp.getData());

            if(temp.left!=null){
                q.add(temp.left);
            }
            if(temp.right!=null){
                q.add(temp.right);
            }
        }
    }
}
