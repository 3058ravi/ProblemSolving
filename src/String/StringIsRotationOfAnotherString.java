package String;

public class StringIsRotationOfAnotherString {
    public static void main(String [] args){
        String s1="abcd";
        String s2="cdab";
        System.out.println(stringIsRotationOfAnother(s1,s2));
    }

    public static boolean stringIsRotationOfAnother(String s1, String s2){
        return (s1.length()==s2.length() && (s1+s1).indexOf(s2)!=-1);
    }
}
