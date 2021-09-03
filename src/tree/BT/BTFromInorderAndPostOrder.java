package tree.BT;

import utils.CommonUtils;
import utils.TNode;

public class BTFromInorderAndPostOrder {
    static int postIndex;
    public static void main(String[] args){
        int[] in={ 4, 2, 1, 7, 5, 8, 3, 6 };
        postIndex= in.length-1;
        int[] post={ 4, 2, 7, 8, 5, 6, 3, 1 };
        TNode root=createBTFromPostorderAndInOrder(in,post,0,in.length-1);
        System.out.println("Inorder :");
        CommonUtils.printInOrderTree(root);
        System.out.println("\nPreorder:");
        CommonUtils.printPostOrderTree(root);
    }

    public static int search(int[] in, int start, int end, int data){
        int i=0;
        for( i =start; i<end; i++){
            if(in[i]==data)
                return i;
        }
        return i;
    }

    public static TNode createBTFromPostorderAndInOrder(int[] in, int[] post, int start, int end){
        if(start>end){
            return null;
        }

        int index=search(in,start,end,post[postIndex--]);
        TNode root = new TNode(in[index]);
        root.right=createBTFromPostorderAndInOrder(in,post,index+1,end);
        root.left=createBTFromPostorderAndInOrder(in,post,start,index-1);

        return root;

    }
}
