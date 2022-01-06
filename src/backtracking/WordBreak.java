/**
 * Checking if a string can be completely broken down into substrings wrt a given dictonary of words
 */
package backtracking;

import java.util.Arrays;
import java.util.List;

public class WordBreak {
    public static void main(String args[])
    {
        String str1 = "iloveicecreamandmango"; // for first test case
        String str2 ="ilovesamsungmobile";     // for second test case
        int n1 = str1.length();                 // length of first string
        int n2 = str2.length();                 // length of second string

        // List of strings in dictionary
        List<String> dict= Arrays.asList("mobile","samsung","sam","sung",
                "man","mango", "icecream","and",
                "go","i","love","ice","cream");
        System.out.println("First Test:");

        // call to the method
        wordBreak(n1,dict,str1);
        System.out.println("\nSecond Test:");

        // call to the method
        wordBreak(n2,dict,str2);
    }

    public static void wordBreak(int length, List<String> dict, String str){
        String ans="";
        wordBreakUtil(length,dict,str,ans);
    }

    public static void wordBreakUtil(int length, List<String> dict, String str, String ans){
        for(int i=1; i<=length; i++){
            String prefix= str.substring(0,i);
            if(dict.contains(prefix)){
                if(i==length){
                    ans += prefix;
                    System.out.println(ans);
                    return;
                }
                wordBreakUtil(length-i,dict,str.substring(i,length),ans+prefix+" ");
            }

        }
    }
}
