package String;

import java.util.ArrayList;
import java.util.List;

public class GenerateIpAddress {
    public static void main(String[] args) {
        System.out.println(restoreIpAddresses("25525511135").toString());
    }

    public static List<String> restoreIpAddresses(String s){
        List<String> res= new ArrayList<>();
        if(s.length()<4 || s.length()>12)
            return res;
        convert(s, res, "", 0);
        return res;
    }

    public static void convert(String s,List<String> res, String ans, int n){
        if(n==4){
            if(s.length()==0)
                res.add(ans.substring(0,ans.length()-1));
            return;
        }

        for(int i=0; i<3; i++){
            if(s.length()<i+1)
                continue;
            int val=Integer.parseInt(s.substring(0, i+1));
            if(val>255 || i+1!= String.valueOf(val).length())
                continue;

            convert(s.substring(i+1),res, ans+s.substring(0,i+1)+".",n+1);
        }

    }
}
