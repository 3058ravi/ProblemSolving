package twoPointers;

public class ComparingStringWithBackspaces {
    public static void main(String[] args) {
        String a = "xzz#";
        String b = "xy#z";
        System.out.println(compareStringWithBackSpaces(a, b, a.length() - 1, b.length() - 1));
    }

    public static boolean compareStringWithBackSpaces(String a, String b, int a_i, int b_i) {
        if (a_i < 0 && b_i < 0)
            return true;
        if (a_i < 0 || b_i < 0)
            return false;

        if (a.charAt(a_i) == '#')
            a_i = getUpdatedIndex(a, a_i);

        if (b.charAt(b_i) == '#')
            b_i = getUpdatedIndex(b, b_i);

        if (a.charAt(a_i) == b.charAt(b_i))
            return compareStringWithBackSpaces(a, b, a_i - 1, b_i - 1);
        else
            return false;

    }

    static int getUpdatedIndex(String s, int i) {
        int backSpaceCount = 0;
        while (i >= 0) {
            if (s.charAt(i) == '#')
                backSpaceCount++;
            else
                break;

            i--;
        }
        return (i - backSpaceCount < 0 ? 0 : i - backSpaceCount);
    }
}
