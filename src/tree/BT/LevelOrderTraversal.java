package tree.BT;

import utils.TNode;

public class LevelOrderTraversal {
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
       int h= height(root);
       for(int i=1; i<=h; i++){
           printLevel(root, i);
           System.out.println("");
       }

    }

    public static void printLevel(TNode root, int level){
        if(root==null)
            return;
        if(level==1)
            System.out.print(root.getData()+" ");
        else if(level>1){
            printLevel(root.left,level-1);
            printLevel(root.right,level-1);
        }
    }

    public static int height(TNode root){
        if(root==null)
            return 0;
        else{
            int lHeight=height(root.left);
            int rHeight=height(root.right);

            if(lHeight>rHeight)
                return lHeight+1;
            else
                return rHeight+1;

        }
    }
}
