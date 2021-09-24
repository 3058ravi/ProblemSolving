package misc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestBalancedStringWithSmallAndCapitalLetter {

    public static void main(String[] args) {
       System.out.println( solution("azABaabba"));
    }

    static int solution(String s) {
        int[] sLetter = new int[26], cLetter = new int[26];
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        Arrays.fill(cLetter, 0);
        Arrays.fill(sLetter, 0);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 65 && s.charAt(i) <= 96)
                cLetter[s.charAt(i) - 'A']++;
            else
                sLetter[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (sLetter[i] != 0 && cLetter[i] == 0)
                map.put((char) (i + 'a'), 1);
            else if (cLetter[i] != 0 && sLetter[i] == 0)
                map.put((char) (i + 'A'), 1);
        }
        Arrays.fill(sLetter, 0);
        Arrays.fill(cLetter, 0);
        int i = 0, str = 0;
        int start = -1, end = -1;
        int minLen = Integer.MAX_VALUE;
        while (i < s.length()) {
            if (map.get(s.charAt(i)) != null) {
                while (str < i) {
                    if (s.charAt(str) >= 65 && s.charAt(str) <= 90)
                        cLetter[s.charAt(str) - 'A']--;
                    else
                        sLetter[s.charAt(str) - 'a']--;
                    str++;
                }
                i++;
                str = i;
            } else {
                if (s.charAt(i) >= 65 && s.charAt(i) <= 90)
                    cLetter[s.charAt(i) - 'A']++;
                else
                    sLetter[s.charAt(i) - 'a']++;

                while (true) {
                    if (s.charAt(str) >= 65 && s.charAt(str) <= 90 && cLetter[s.charAt(str) - 'A'] > 1) {
                        cLetter[s.charAt(str) - 'A']--;
                        str++;
                    } else if (s.charAt(str) >= 97 && s.charAt(str) <= 122 && sLetter[s.charAt(str) - 'a'] > 1) {
                        sLetter[s.charAt(str) - 'a']--;
                        str++;
                    } else
                        break;
                }
                if (isBalanced(sLetter, cLetter)) {
                    if (minLen > (i - str + 1)) {
                        minLen = i - str + 1;
                        start = str;
                        end = i;
                    }
                }
                i++;
            }
        }
        if (start == -1 || end == -1)
            return -1;
            // Store answer string
        else {
            String ans = "";
            for (int j = start; j <= end; j++)
                ans += s.charAt(j);

            return ans.length();
        }
    }

    static boolean isBalanced(int sLetter[], int cLetter[]) {
        for (int i = 0; i < 26; i++) {
            if (sLetter[i] != 0 && (cLetter[i] == 0))
                return false;
            else if ((sLetter[i] == 0) && (cLetter[i] != 0))
                return false;
        }
        return true;
    }


}
