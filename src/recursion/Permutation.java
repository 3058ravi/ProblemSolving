package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        if (nums.length == 0) {
            return permutations;
        }
        permutethroughRecurssion(nums, 0, new ArrayList<>(), permutations);
        return permutations;
    }
    public static List<Integer> swap(List<Integer> per, int i, int j)
    {
        int temp = per.get(i) ;
        per.add(i,per.get(j));
        per.add(j,temp);
        return per;
    }

    public static void permutethroughRecurssion(int[] nums, int start, List<Integer> permutation, List<List<Integer>> permutations) {

        if (permutation.size() == nums.length) {
            permutations.add(permutation);
            return;
        }
        for (int i = 0; i <= permutation.size(); i++) {
            List<Integer> newPermutation = new ArrayList<>(permutation);
            newPermutation.add(i, nums[start]);
            permutethroughRecurssion(nums, start + 1, newPermutation, permutations);
        }


    }



    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> list = permute(nums);
        for (List<Integer> l : list) {
            for (int n : l) {
                System.out.print(n + " ");
            }
            System.out.println("");
        }
    }

}
