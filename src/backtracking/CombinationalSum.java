/**
* Print all the combination of values in array whose sum equals a given value
* combinations can be made by repeating the same value multiple times
**/
package backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationalSum {
        public static List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> res= new ArrayList<>();
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
                    temp.add(candidates[i]);
                    comb(candidates,target-candidates[i],res, temp,i);
                    temp.remove(temp.size() - 1);
                }
            }
        }

        public static void main(String[] args){
            int[] arr= {2,3,6,7};
            int target=7;
            List<List<Integer>> list = combinationSum(arr, target);
            for(List<Integer> l: list){
                for(Integer i: l){
                    System.out.print(i+", ");
                }
                System.out.println("");
            }
        }
}
