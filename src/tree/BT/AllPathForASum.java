package tree.BT;

import utils.TNode;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class AllPathForASum {

    /*
    Given a tree, print all combination of nodes whose sum equals given value.
    The solution is considered valid only if sum of  root to leaf node equals given sum.
     */
    public static void main(String[] args) {

        TNode root = new TNode(12);
        root.left = new TNode(7);
        root.right = new TNode(1);
        root.left.left = new TNode(4);
        root.right.left = new TNode(10);
        root.right.right = new TNode(5);


        List<List<Integer>> list = printAllPathsForASum(root, 23);
        for (List<Integer> l : list) {
            for (int i : l) {
                System.out.print(i + " ");
            }
            System.out.println("");
        }
    }

    public static List<List<Integer>> printAllPathsForASum(TNode root, int sum) {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> currPath = new ArrayList<>();
        printAllPathsForASum(root, sum, currPath, allPaths);
        return allPaths;
    }

    public static void printAllPathsForASum(TNode currNode, int sum, List<Integer> currPath, List<List<Integer>> allPaths) {
        if (currNode == null)
            return;

        currPath.add(currNode.getData());
        if (currNode.getData() == sum && currNode.left == null && currNode.right == null)
            allPaths.add(new ArrayList<>(currPath));
        else {
            printAllPathsForASum(currNode.left, sum - currNode.getData(), currPath, allPaths);
            printAllPathsForASum(currNode.right, sum - currNode.getData(), currPath, allPaths);
        }
        currPath.remove(currPath.size() - 1);

    }
}
