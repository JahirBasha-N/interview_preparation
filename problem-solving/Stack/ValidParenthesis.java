package Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParenthesis {
    public static void main(String[] args) {
        String s = "()";
        Map<Character, Character> parMap = new HashMap<>() {{
            put(')', '(');
            put('}', '{');
            put(']', '[');
        }};
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!stack.isEmpty() && parMap.containsKey(c)) {
                if (parMap.get(c) == stack.peek()) {
                    stack.pop();
                }
            }
            else {
                stack.push(c);
            }
        }
        System.out.println(stack.isEmpty());
    }
}
