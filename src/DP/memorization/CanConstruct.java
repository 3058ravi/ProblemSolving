/*
Problem Statement: Check Adding elements of an String array can construct a given string.
This is solve using DP- memorization with O(m*n) time complexity and O(m) space complexity
 */

package DP.memorization;

import java.util.HashMap;

public class CanConstruct {
    public static void main(String[] args){
        String[] arr={"ab", "abc", "cd","def","abcd"};
        HashMap<String,Boolean> map = new HashMap<>();
        System.out.println(canConstruct("abcdef",arr,map));
        System.out.println(canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",new String[]{"e","ee","eee","eeee","eeeee","eeeeee"},map));
    }

    public static boolean canConstruct(String target, String[] arr, HashMap<String,Boolean> map){
        if(map.containsKey(target))
            return map.get(target);
        if(target.equals(""))
            return true;
        for(String s: arr){
            if(target.indexOf(s)==0){
                String suffix= target.substring(s.length());
                if(canConstruct(suffix,arr,map)==true){
                    map.put(target,true);
                    return true;
                }
            }
        }
        map.put(target,false);
        return map.get(target);
    }
}
