package recursion;

public class palindrome {
    public static void main(String[] args){
        String s="kayak";
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String str){
        if(str.length()==0||str.length()==1)
            return true;
        if(str.charAt(0)==str.charAt(str.length()-1))
            return isPalindrome(str.substring(1,str.length()-1));

        return false;
    }
}
