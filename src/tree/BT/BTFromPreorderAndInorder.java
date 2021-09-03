package tree.BT;

import utils.CommonUtils;
import utils.TNode;

public class BTFromPreorderAndInorder {
    static int preIndex=0;
    public static void main(String[] args){
        int[] in={4,2,5,1,3,6};
        int[] pre={1,2,4,5,3,6};
        TNode root=createBTFromPreorderAndInOrder(in,pre,0,in.length-1);
        System.out.println("Inorder :");
        CommonUtils.printInOrderTree(root);
        System.out.println("\nPreorder:");
        CommonUtils.printPreOrderTree(root);
    }

    public static int search(int[] in, int start, int end, int data){
        int i=0;
        for( i =start; i<end; i++){
            if(in[i]==data)
                return i;
        }
        return i;
    }

    public static TNode createBTFromPreorderAndInOrder(int[] in, int[] pre, int start, int end){
        if(start>end){
            return null;
        }

        int index=search(in,start,end,pre[preIndex++]);
        TNode root = new TNode(in[index]);
        root.left=createBTFromPreorderAndInOrder(in,pre,start,index-1);
        root.right=createBTFromPreorderAndInOrder(in,pre,index+1,end);

        return root;

    }
}
