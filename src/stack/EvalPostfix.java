package stack;

import java.util.Stack;

public class EvalPostfix {
    public static void main(String[] args)
    {
        String exp = "138*+5/";
        System.out.println(evalPostfix(exp));
    }

    public static int evalPostfix(String exp){
        if (exp == null || exp.length() == 0) {
            System.exit(-1);
        }

        Stack<Integer> s= new Stack<>();
        for(char c:exp.toCharArray()){
            if(Character.isDigit(c))
                s.push(c-'0');
            else{
                int x=s.pop();
                int y= s.pop();
                if (c == '+') {
                    s.push(y + x);
                }else  if (c == '-') {
                    s.push(y - x);
                }else  if (c == '*') {
                    s.push(y * x);
                }else  if (c == '/') {
                    s.push(y / x);
                }
            }
        }
        return s.pop();
    }
}
