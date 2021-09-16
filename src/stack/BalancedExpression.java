package stack;

import java.util.Stack;

public class BalancedExpression {
    public static void main(String[] args)
    {
        String exp = "{()}[{}]";

        if (isBalanced(exp)) {
            System.out.println("The expression is balanced");
        }
        else {
            System.out.println("The expression is not balanced");
        }
    }

    public static boolean isBalanced(String s){
        if(s==null|| s.length()%2==1)
            return false;

        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()){
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            if (c == ')' || c == '}' || c == ']')
            {
                if (stack.empty()) {
                    return false;
                }
                Character top = stack.pop();
                if ((top == '(' && c != ')') || (top == '{' && c != '}')
                        || (top == '[' && c != ']')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();

    }
}
