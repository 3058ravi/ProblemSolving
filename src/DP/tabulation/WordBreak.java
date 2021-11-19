package DP.tabulation;

import java.util.ArrayList;
import java.util.List;

public class WordBreak {

    public static void main(String[] args){
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(wordBreak(s,wordDict));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        int[] dp = new int[s.length()];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                String sb = s.substring(j, i+1);
                if (wordDict.contains(sb)) {
                    if (j > 0)
                        dp[i] += dp[j - 1];
                    else
                        dp[i] += 1;
                }

            }

        }

        if (dp[n - 1] > 0)
            return true;

        return false;
    }

}
