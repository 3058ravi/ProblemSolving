package tree.BT;

import utils.TNode;

import java.util.HashMap;
import java.util.Map;

public class LeftView {
    public static void main(String[] args){
        TNode root = new TNode(1);
        root.left = new TNode(2);
        root.right = new TNode(3);
        root.left.right = new TNode(4);
        root.right.left = new TNode(5);
        root.right.right = new TNode(6);
        root.right.left.left = new TNode(7);
        root.right.left.right = new TNode(8);

        leftView(root);
    }

    public static void leftView(TNode root){
        Map<Integer,Integer> map=new HashMap<>();
        leftView(root,1,map);

        for(int i=1;i<=map.size();i++){
           System.out.println( map.get(i));
        }
    }

    public static void leftView(TNode root, int level,Map<Integer,Integer> map){
        if(root==null)
            return;

        map.putIfAbsent(level,root.getData());
        leftView(root.left,level+1,map);
        leftView(root.right,level+1,map);

    }
}
