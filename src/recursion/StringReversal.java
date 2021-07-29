package recursion;

public class StringReversal {
    public static void main(String[] args){
        String s="desrever si gnirtS";
        System.out.println(reverseString(s));
    }

    public static String reverseString(String str){
        if(str.equals("")|| str.length()==1)
            return str;
        return str.charAt(str.length()-1)+reverseString(str.substring(1,str.length()-1))+str.charAt(0);
    }
}
