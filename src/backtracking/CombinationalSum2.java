/**
 * Print all the distinct combination of values in array whose sum equals a given value
 * combinations cannot reuse the same value again unless multiple occurance in array.
 * */
package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationalSum2 {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res= new ArrayList<>();
        Arrays.sort(candidates);
        comb(candidates, target, res, new ArrayList<Integer>(),0);
        return res;
    }

    public static void comb(int[] candidates, int target, List<List<Integer>> res, List<Integer> temp, int index){
        if(target==0){

            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i=index; i< candidates.length; i++){
            if(target-candidates[i]>=0){
                if (i > index && candidates[i] == candidates[i-1]) {
                    continue;
                }
                temp.add(candidates[i]);
                comb(candidates,target-candidates[i],res, temp,i+1);
                temp.remove(temp.size() - 1);
            }
        }
    }


    public static void main(String[] args){
        int[] arr= {10,1,2,7,6,1,5};
        int target=8;
        List<List<Integer>> list = combinationSum2(arr, target);
        for(List<Integer> l: list){
            for(Integer i: l){
                System.out.print(i+", ");
            }
            System.out.println("");
        }
    }
}
