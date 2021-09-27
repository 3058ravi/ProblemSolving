package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKDistinctChars {

    public static void main(String[] args) {
        String a = "araaci";
        System.out.println(longestSubstringWithKDistinctChars(a, 2));
    }

    public static int longestSubstringWithKDistinctChars(String a, int k) {
        if (a == null || a.length() == 0 || a.length() < k)
            return -1;
        int n = a.length() - 1;
        int left = 0;
        int longest = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int right = 0; right <= n; right++) {
            char c = a.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);
                while (map.size() > k) {
                    char r=a.charAt(left);
                    map.put(r, map.get(r) - 1);
                    if(map.get(r)==0)
                        map.remove(r);
                    left++;
                }

            longest=Math.max(longest, right-left+1);
        }
        return longest;
    }
}
