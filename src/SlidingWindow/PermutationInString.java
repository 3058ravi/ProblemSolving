package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class PermutationInString {

    public static void main(String[] args) {
        String s = "bcdxabcdy";
        String p = "bcdyabcdx";

        System.out.println(findPermutationInString(s, p));
    }

    public static boolean findPermutationInString(String s, String p) {
        int left = 0;
        int matched = 0;
        Map<Character, Integer> map = new HashMap<>();
        //put all chars in pattern in map
        for (char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0)
                    matched++;
            }

            if (matched == map.size())
                return true;

            if (right - left + 1 > p.length()) {
                char d = s.charAt(left);
                if (map.containsKey(d)) {
                    if (map.get(d) == 0)
                        matched--;
                    map.put(d, map.get(d) + 1);
                }
            }

        }
        return false;
    }
}
