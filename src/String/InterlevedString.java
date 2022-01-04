package String;

public class InterlevedString {
    /*
    Given strings A, B, and C, find whether C is formed by an interleaving of A and B.
    An interleaving of two strings S and T is a configuration such that it creates a new string Y from the concatenation substrings of A and B and |Y| = |A + B| = |C|

    For example: A = "XYZ" B = "ABC"

    so we can make multiple interleaving string Y like, XYZABC, XAYBCZ, AXBYZC, XYAZBC and many more so here your task is to check whether you can create a string Y which can be equal to C.

    Specifically, you just need to create substrings of string A and create substrings B and concatenate them and check whether it is equal to C or not.

    Note: a + b is the concatenation of strings a and b.

    Return true if C is formed by an interleaving of A and B, else return false.
     */

    public static void main(String[] args){
        String a="YX", b="X", c="XXY";
        System.out.println(solve(a,b,c,a.length(),b.length(), c.length()));
    }

    public static boolean solve(String a, String b, String c, int l, int m, int n){
        if(n<=0) return true;
        boolean x=false, y= false;
         if(l-1>=0 && a.charAt(l-1)==c.charAt(n-1))
             x= solve(a,b,c, l-1, m, n-1);
         if(m-1>=0 && b.charAt(m-1)==c.charAt(n-1))
             y= solve(a,b,c,l,m-1,n-1);

         return x|y;
    }
}
