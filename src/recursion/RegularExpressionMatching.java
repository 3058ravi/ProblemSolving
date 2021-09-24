package recursion;

public class RegularExpressionMatching {

        public static boolean isMatch(String s, String p, int i, int j){
            if(i>=s.length() && j>=p.length())
                return true;

            if(j>=p.length())
                return false;

            boolean match= i< s.length() &&(s.charAt(i)==p.charAt(j)|| p.charAt(j)=='.') ;
            if(j+1<p.length() && p.charAt(j+1)=='*'){
                return isMatch(s, p, i,j+2)||(match && isMatch(s, p, i+1,j));
            }else if(match)
                return isMatch(s,p,i+1,j+1);
            else
                return false;
        }


    public static void main(String[] args) {
        String s = "aab";
        String p = "c*a*b";
        System.out.println(isMatch(s, p,0,0));
    }
}
