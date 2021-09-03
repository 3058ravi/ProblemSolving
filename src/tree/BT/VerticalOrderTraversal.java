package tree.BT;

import utils.TNode;

import java.util.*;

public class VerticalOrderTraversal {
    public static void main(String[] args) {
        TNode root = new TNode(1);
        root.left = new TNode(2);
        root.right = new TNode(3);
        root.left.left = new TNode(4);
        root.right.left = new TNode(5);
        root.right.right = new TNode(6);
        root.right.left.left = new TNode(7);
        root.right.left.right = new TNode(8);
        verticalOrderTraversal(root);
    }

    public static void verticalOrderTraversal(TNode root){
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        verticalOrderTraversal(root,0,0,map);
        List<List<Integer>> list = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()) {
            list.add(new ArrayList<>());
            for (PriorityQueue<Integer> nodes : ys.values()) {

                while (!nodes.isEmpty()) {
                    System.out.print(nodes.peek()+",");
                    list.get(list.size() - 1).add(nodes.poll());

                }

            }
        }
    }

    public static void verticalOrderTraversal(TNode root, int vertices, int level,Map<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map){
        if(root==null)
            return;
        if(!map.containsKey(vertices)){
            map.put(vertices,new TreeMap<>());
        }
        if(!map.get(vertices).containsKey(level)){
            map.get(vertices).put(level, new PriorityQueue<>());
        }

        map.get(vertices).get(level).offer(root.getData());
        verticalOrderTraversal(root.left,vertices-1,level+1,map);
        verticalOrderTraversal(root.right,vertices+1,level+1,map);
    }
}
