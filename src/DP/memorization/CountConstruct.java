/*
Problem Statement: Find Number of ways Adding elements of an String array can construct a given string.
This is solve using DP- memorization with O(m*n) time complexity and O(m) space complexity
 */
package DP.memorization;

import java.util.HashMap;

public class CountConstruct {
    public static void main(String[] args){
        String[] arr={"ab", "abc", "cd","def","abcd"};
        HashMap<String,Integer> map = new HashMap<>();
        System.out.println(countConstruct("abcdef",arr,map));
        System.out.println(countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",new String[]{"e","ee","eee","eeee","eeeee","eeeeee"},map));
    }
    public static int countConstruct(String target, String[] arr, HashMap<String, Integer> map) {
        if(map.containsKey(target))
            return map.get(target);
        if (target.equals("")) return 1;
        int totalCount = 0;
        for (String s : arr) {
            if (target.indexOf(s) == 0) {
                String suffix = target.substring(s.length());
                int count = countConstruct(suffix, arr, map);
                totalCount += count;
            }
        }
        map.put(target,totalCount);
        return map.get(target);
    }
}
