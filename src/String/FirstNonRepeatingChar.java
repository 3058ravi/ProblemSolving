package String;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FirstNonRepeatingChar {

    public static void main(String[] args) {
        String s = "aaabcccdeef";
        findNonRepeatingChar(s);
        findNonRepeatingCharThroughArray(s);
    }

    public static void findNonRepeatingChar(String s) {
        PriorityQueue<Character> pq = new PriorityQueue<>();
        char ncr;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length() - 1; i++) {
            char curr = s.charAt(i);
            if (!map.containsKey(curr))
                map.put(curr, 1);
            else
                map.put(curr, map.get(curr) + 1);
        }

        for (int i = 0; i < s.length() - 1; i++) {
            if (map.get(s.charAt(i)) == 1) {
                System.out.println("First non repeating char is : " + s.charAt(i));
                break;
            }
        }
    }

    public static void findNonRepeatingCharThroughArray(String s) {
        int[] arr = new int[26];
        for (int i = 0; i < s.length() - 1; i++) {
            arr[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (arr[s.charAt(i) - 'a'] == 1) {
                System.out.println("First non repeating char is : " + s.charAt(i));
                break;
            }
        }
    }


}
