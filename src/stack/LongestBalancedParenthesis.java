package stack;

import java.util.Stack;

public class LongestBalancedParenthesis {
    public static void main(String[] args)
    {
        System.out.println(findMaxLen("((()()"));       // prints 4
        System.out.println(findMaxLen("(((()"));        // prints 2
        System.out.println(findMaxLen("(((("));         // prints 0
        System.out.println(findMaxLen("()()"));         // prints 4
        System.out.println(findMaxLen("(()())(()"));    // prints 6
    }

    public static int findMaxLen(String p){
        if(p==null)
            return 0;
        Stack<Integer> s= new Stack<>();
        s.push(-1);
        int len=0;

        for(int i=0; i<p.length(); i++){
            if(p.charAt(i)=='(')
                s.push(i);
            else{
                s.pop();

                if(s.isEmpty()) {
                    s.push(i);
                    continue;
                }

                int curr_len=i-s.peek();
                if(len<curr_len)
                    len=curr_len;
            }
        }
        return len;
    }
}
