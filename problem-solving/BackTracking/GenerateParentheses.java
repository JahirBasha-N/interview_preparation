package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class GenerateParentheses {
    public static void main(String[] args) {
        int n = 3; // 3 open 3 close
        List<String> result = new ArrayList<>();
        generateParentheses(0, 0, new Stack<>(), result, n);
        System.out.println(result);
    }

    private static void generateParentheses(int openP, int closeP, Stack<Character> charStack, List<String> result, int n) {
        if (openP == n && closeP == n) {
            StringBuilder string = new StringBuilder();
            for (Character c : charStack) {
                if (c != ',') string.append(c);
            }
            result.add(string.toString());
            return;
        }
        if (openP < n) {
            charStack.push('(');
            generateParentheses(openP + 1, closeP, charStack, result, n);
            charStack.pop();
        }

        if (closeP < openP) {
            charStack.push(')');
            generateParentheses(openP, closeP + 1, charStack, result, n);
            charStack.pop();
        }
    }
}
