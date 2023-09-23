package recursion;

import utils.CommonUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubsetOfString {
    static List<String> ans;

    public static void main(String[] args) {
        ans = new ArrayList<String>();
        subsetOfString("abc", "", 0);
        Collections.sort(ans);
        CommonUtils.printStringList(ans);
    }

    public static void subsetOfString(String s, String res, int i) {
        if (i == s.length()) {
            ans.add(res);
            return;
        }
        subsetOfString(s, res + s.charAt(i), i + 1);
        subsetOfString(s, res, i + 1);
    }
}
