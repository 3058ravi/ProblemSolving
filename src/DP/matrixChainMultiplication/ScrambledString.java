package DP.matrixChainMultiplication;

import twoPointers.HappyNumber;

import java.util.HashMap;
import java.util.Map;

public class ScrambledString {
    public static void main(String[] args) {
        String s1 = "great";
        String s2 = "rgate";
        if (s1.length() != s2.length())
            System.out.println(false);
        Map<String, Boolean> map = new HashMap<>();
        System.out.println(scrambledString(s1, s2,map));

    }

    public static boolean scrambledString(String s1, String s2, Map<String, Boolean> map) {
        if (s1.equals(s2))
            return true;
        if (s1.length() <= 1)
            return false;

        String key = s1 + " " + s2;
        if (map.containsKey(key))
            return map.get(key);
        int n = s1.length();
        boolean flag = false;
        for (int i = 1; i <= n - 1; i++) {
            boolean c1 = (scrambledString(s1.substring(0, i), s2.substring(n - i, n),map)
                    && scrambledString(s1.substring(i, n), s2.substring(0, n - i),map));
            boolean c2 = (scrambledString(s1.substring(0, i), s2.substring(0, i),map)
                    && scrambledString(s1.substring(i, n), s2.substring(i, n),map));
            if (c1 || c2) {
                flag = true;
                break;
            }

        }
        map.put(key, flag);
        return flag;
    }
}
