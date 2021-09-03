package tree.BT;

import utils.TNode;

import java.util.HashMap;
import java.util.Map;

public class DiagonalSum {
    public static void main(String[] args)
    {


        TNode root = new TNode(1);
        root.left = new TNode(2);
        root.right = new TNode(3);
        root.left.left = new TNode(4);
        root.right.left = new TNode(5);
        root.right.right = new TNode(6);
        root.right.left.left = new TNode(7);
        root.right.left.right = new TNode(8);

        diagonalSum(root);
    }

    public static void diagonalSum(TNode root){
        Map<Integer,Integer> map = new HashMap<>();
        diagonalSum(root,0,map);
        System.out.println(map.values());
    }

    public static void diagonalSum(TNode root, int diagonal, Map<Integer,Integer> map){
        if(root==null)
            return;
        map.put(diagonal,map.getOrDefault(diagonal,0)+root.getData());
        diagonalSum(root.left,diagonal+1,map);
        diagonalSum(root.right,diagonal,map);
    }


}
