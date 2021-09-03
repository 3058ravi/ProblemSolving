package tree.BT;

import utils.CommonUtils;
import utils.TNode;

import java.util.HashMap;
import java.util.Map;

public class BinaryTreeFromArray {

    public static void main(String[] args)
    {
        int[] parent = {-1, 0, 0, 1, 2, 2, 4, 4};

        TNode root = createTree(parent);
        CommonUtils.printInOrderTree(root);
    }

    public static TNode createTree(int[] arr){
        Map<Integer, TNode> map = new HashMap();
        for(int i=0; i<arr.length; i++){
            map.put(i,new TNode(i));
        }
        TNode root=null;
        for(int i=0; i<arr.length; i++){
            if(arr[i]==-1)
                root=map.get(i);

            else{
                TNode ptr= map.get(arr[i]);
                if(ptr.left!=null)
                    ptr.right=map.get(i);
                else
                    ptr.left=map.get(i);
            }
        }
        return root;
    }
}
