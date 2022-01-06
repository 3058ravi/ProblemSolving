/**
 * Program to write down all possible solution of classic word break problem.
 */
package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WordBreak2 {
    public static List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        wordBreak(s, wordDict, res, "", 0);
        Collections.reverse(res);
        return res;
    }

    public static void wordBreak(String s, List<String> wordDict, List<String> res, String f, int index) {
        if (index >= s.length()) {

            res.add(f.trim());
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (wordDict.contains(s.substring(index, i + 1))) {
                wordBreak(s, wordDict, res, f + s.substring(index, i + 1) + " ", i+1);
            }
        }
    }

    public static void main(String[] args) {
            String s="catsanddog";
            List<String> res= wordBreak(s, Arrays.asList("cat","cats","and","sand","dog"));
               for(String s1: res){
                   System.out.println(s1);
               }
    }
}
