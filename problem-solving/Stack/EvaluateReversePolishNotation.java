package Stack;

import java.util.Stack;
public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        String[] tokens = new String[]{"4","13","5","/","+"};
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (!token.equals("+") && !token.equals("-") && !token.equals("*") && !token.equals("/")) stack.push(Integer.valueOf(token));
            else {
                Integer pop1 = stack.pop();
                Integer pop = stack.pop();
                int val;
                if (token.equals("+")) {
                    val = pop + pop1;
                    stack.push(val);
                }
                if (token.equals("-")) {
                    val = pop - pop1;
                    stack.push(val);
                }
                if (token.equals("*")) {
                    val = pop * pop1;
                    stack.push(val);
                }
                if (token.equals("/")) {
                    val = pop / pop1;
                    stack.push(val);
                }
            }
        }
        System.out.println(stack.peek());
    }
}
