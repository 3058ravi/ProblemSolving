package String;

import utils.CommonUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubStringWithConcatenationOfAllWords {
    public static void main(String[] args) {
        String s = "wordgoodgoodgoodbestword";
        String words[] = {"word","good","best","good"};
        CommonUtils.printIntegerList(findSubstring(s, words));
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String w : words)
            map.put(w, map.getOrDefault(w, 0)+1);

        int wlen = words[0].length();

        for (int i = 0; i <= s.length() - wlen * words.length; i++) {
            Map<String, Integer> copy = new HashMap<>(map);
            for (int j = 0; j < words.length; j++) {
                String str = s.substring(i + j * wlen, i + j * wlen + wlen);
                if (copy.containsKey(str)) {
                    int count = copy.get(str);
                    if (count == 1) copy.remove(str);
                    else copy.put(str, count - 1);
                    if (copy.isEmpty()) {
                        res.add(i);
                        break;
                    }
                } else
                    break;

            }
        }
        return res;
    }

}
