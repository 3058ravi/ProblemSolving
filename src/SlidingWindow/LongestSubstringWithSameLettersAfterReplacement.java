package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithSameLettersAfterReplacement {

    public static void main(String[] args) {
        String a = "aabccbb";
        System.out.println(longestSubstringWithSameLettersAfterReplacement(a,2));
    }

    public static int longestSubstringWithSameLettersAfterReplacement(String a,int k){
        int left = 0;
        int longest = 0;
        int maxLetterCount=0;
        Map<Character, Integer> map = new HashMap();
        for(int right =0; right<a.length(); right++){
        char c =a.charAt(right);
        map.put(c,map.getOrDefault(c,0)+1);
        maxLetterCount=Math.max(maxLetterCount,map.get(c));

        if(right-left+1-maxLetterCount>k){
            char d=a.charAt(left);
            map.put(d,map.get(d)-1);
            left++;
        }
        longest=Math.max(longest, right-left+1);
        }
        return longest;
    }

}
