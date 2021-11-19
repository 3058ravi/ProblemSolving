package String;

public class ConvertStringToEquivalentNumericKeypad {

    public static void main(String[] args){
        String str[] = {"2","22","222",
                "3","33","333",
                "4","44","444",
                "5","55","555",
                "6","66","666",
                "7","77","777","7777",
                "8","88","888",
                "9","99","999","9999"
        };

        String input = "GEEKSFORGEEKS";
        System.out.println(printSequence(str, input));
    }

    public static String printSequence(String[] arr, String s){
        String res="";
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)==' ')
                res+="0";
            res+=arr[s.charAt(i)-'A'];
        }
        return res;
    }
}
