package tree.BT;

import utils.TNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagTraversal {
    public static void main(String args[]) {
        TNode root = new TNode(1);
        root.left = new TNode(2);
        root.right = new TNode(3);
        root.left.left = new TNode(4);
        root.left.right = new TNode(5);

        System.out.println("Level order traversal of binary tree is ");
        List<List<Integer>> list = zigzagTraversal(root);
        System.out.println(list);
    }

    public static List<List<Integer>> zigzagTraversal(TNode root) {
        List<List<Integer>> res = new LinkedList<>();

        if (root == null)
            return res;

        Queue<TNode> q = new LinkedList<>();
        q.add(root);
        boolean leftToRight = true;
        while (!q.isEmpty()) {
            int levelSize = q.size();
            List<Integer> currentLevel = new ArrayList<>(levelSize);
            for (int i = 0; i < levelSize; i++) {
                TNode temp = q.poll();
                if (leftToRight)
                    currentLevel.add(temp.getData());
                else
                    currentLevel.add(0, temp.getData());
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
            //insert at 0 index
            res.add( currentLevel);
            leftToRight=!leftToRight;

        }
        return res;
    }
}
