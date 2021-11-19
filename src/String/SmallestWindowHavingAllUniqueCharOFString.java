package String;

import java.util.HashMap;
import java.util.Map;

public class SmallestWindowHavingAllUniqueCharOFString {
    public static void main(String[] args) {
        String s = "AABBBCBBAC";
        System.out.println(smallestWindowHavingAllUniqueCharOFString(s, s.length()));
    }

    public static int smallestWindowHavingAllUniqueCharOFString(String s, int n) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < n; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        int distinct = map.size();
        String res = "";

        for (int i = 0; i < n; i++) {
            int[] visited = new int[256];
            int count = 0;
            String sub_str = "";

            for (int j = i; j < n; j++) {
                if (visited[s.charAt(j)] == 0) {
                    visited[s.charAt(j)] = 1;
                    count++;
                }
                sub_str += s.charAt(j);
                if (count == distinct)
                    break;
            }

            if (sub_str.length() < n && count == distinct) {
                res = sub_str;
                n = res.length();

            }
        }
        System.out.println("resulting substring ="+res);
        return n;

    }
}
