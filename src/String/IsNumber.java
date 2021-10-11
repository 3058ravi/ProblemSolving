package String;

public class IsNumber {

    public static void main(String args[]) {
        System.out.println(isNumber("1E9"));
    }
    public static boolean isNumber(String s) {
        s.trim();

        boolean pointSeen = false;
        boolean eSeen = false;
        boolean numberSeen = false;
        for (int i = 0; i < s.length(); i++) {
            if ('0' <= s.charAt(i) && s.charAt(i) <= '9') {
                numberSeen = true;
            } else if (s.charAt(i) == '.') {
                if (eSeen || pointSeen)
                    return false;
                pointSeen = true;
            } else if (s.charAt(i) == 'e'||s.charAt(i)=='E') {
                if (eSeen || !numberSeen) {
                    return false;
                }
                eSeen = true;
                numberSeen = false;
            } else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                if (i != 0 && s.charAt(i - 1) != 'e')
                    return false;
            } else
                return false;

        }
        return numberSeen;
    }
}
