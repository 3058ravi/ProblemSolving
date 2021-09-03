package tree.BT;

import utils.TNode;

public class PostOrderFromPreAndInorder {

    static int preIndex=0;
    public static void main(String[] args){
        int[] in={4,2,5,1,3,6};
        int[] pre={1,2,4,5,3,6};
        printPostOrder(in,pre,0,in.length-1);

    }

    public static void printPostOrder(int[] in, int[] pre, int start, int end){
        if(start>end)
            return;

        int root=search(in,start, end,pre[preIndex++]);

        printPostOrder(in,pre,start, root-1);
        printPostOrder(in,pre,root+1, end);

        System.out.println(in[root]);
    }

    public static int search(int[] in, int start, int end, int data){
        int i=0;
        for( i =start; i<end; i++){
            if(in[i]==data)
                return i;
        }
        return i;
    }
}
