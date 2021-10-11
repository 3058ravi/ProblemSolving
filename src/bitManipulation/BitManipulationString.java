package bitManipulation;

public class BitManipulationString {
    public static void main(String[] args) {
        System.out.println(uppercaseToLowerCase("SAMPLE STRING"));
        System.out.println(lowercaseToUppercase("samplestring"));
        System.out.println(invertCaseInString("AbCdEf"));
    }

    public static String uppercaseToLowerCase(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            res += (char) (s.charAt(i) | ' ');
        }
        return res;
    }

    public static String lowercaseToUppercase(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            res += (char) (s.charAt(i) & '_');
        }
        return res;
    }

    public static String invertCaseInString(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            res += (char) (s.charAt(i) ^ ' ');
        }
        return res;
    }
}
