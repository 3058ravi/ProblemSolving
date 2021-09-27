package stack;

import java.util.Stack;

public class SimplifyPath {

    public static void main(String[] args){
        String str="/a/./b/../../c/";
        System.out.println(simplifyPath(str));
    }

    public static String simplifyPath(String str){
        int n= str.length()-1;

        String[] arr= str.split("/");
        Stack<String> s= new Stack<>();
        for(String a: arr){
            if(a.equals("")||a.equals("."))
                continue;
            else if(a.equals("..")){
                if(!s.isEmpty())
                s.pop();
            }else
                s.push(a);
        }

        String  res = "";
        while(!s.isEmpty()){
            res= "/"+s.pop()+res;
        }
        res= (res==""?"/":res);
        return res;
    }
}
