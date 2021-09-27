package SlidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeating {

    public static void main(String[] args) {
        String a = "aabcacbb";
        System.out.println(longestSubstringWithoutRepeating(a));
    }

    public static int longestSubstringWithoutRepeating(String s) {
        int left = 0;
        int longest = 0;
        Map<Character, Integer> map = new HashMap();
        int n = s.length();
        for (int right = 0; right < n; right++) {
            if (map.containsKey(s.charAt(right)))
                left = Math.max(left, map.get(s.charAt(right)) + 1);
            map.put(s.charAt(right), right);
            longest = Math.max(longest, right - left + 1);
        }
        return longest;
    }
}
