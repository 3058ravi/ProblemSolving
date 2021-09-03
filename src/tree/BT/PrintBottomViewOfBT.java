package tree.BT;

import utils.TNode;

import java.util.Map;
import java.util.TreeMap;

class Pair<U,V>{
    public final U first;   	// first field of a pair
    public final V second;  	// second field of a pair

    // Constructs a new Pair with specified values
    private Pair(U first, V second)
    {
        this.first = first;
        this.second = second;
    }

    // Factory method for creating a Typed Pair immutable instance
    public static <U, V> Pair <U, V> of(U a, V b)
    {
        // calls private constructor
        return new Pair<>(a, b);
    }
}

public class PrintBottomViewOfBT {

    public static void main(String[] args)
    {
        TNode root = new TNode(1);
        root.left = new TNode(2);
        root.right = new TNode(3);
        root.left.right = new TNode(4);
        root.right.left = new TNode(5);
        root.right.right = new TNode(6);
        root.right.left.left = new TNode(7);
        root.right.left.right = new TNode(8);
        Map<Integer, Pair<Integer,Integer>> map = new TreeMap<>();
        printBottom(root, 0,0,map);
        for(Pair<Integer,Integer> it:map.values()){
            System.out.println(it.first +" ");
        }
    }

    public static void printBottom(TNode root, int dist, int level, Map<Integer,Pair<Integer,Integer>> map){
    if(root==null)
        return;

    if(!map.containsKey(dist)||level>=map.get(dist).second){
        map.put(dist,Pair.of(root.getData(),level));
    }

    printBottom(root.left,dist-1, level+1,map);
        printBottom(root.right,dist+1, level+1,map);

    }
}
