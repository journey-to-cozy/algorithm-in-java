package src.sanga.data_structure.string;

import java.util.Stack;

/**
 * 괄호로 된 입력값이 올바른지 판별하라
 * https://leetcode.com/problems/valid-parentheses/
 */
class ValidParentheses {

    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        System.out.println(validParentheses.isValid("(())"));
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }


    public boolean isValid2(String s) {
        Stack<Character> stack = new Stack<>();
        String left = "([{";
        String right = ")]}";

        for (char c : s.toCharArray()) {
            if (left.indexOf(c) > -1) {
                stack.push(c);
            } else if (stack.isEmpty() || left.indexOf((char) stack.pop()) != right.indexOf(c)) {
                return false;
            }
        }

        return stack.isEmpty();
    }


    public boolean isValid3(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (char c : chars) {
            if (stack.isEmpty() && (c == '}' || c == ']' || c == ')'))
                return false;
            else if (!stack.isEmpty() && isMatched(stack.peek(), c))
                stack.pop();
            else
                stack.push(c);
        }

        return stack.isEmpty();

    }

    private boolean isMatched(Character peek, char c) {
        if (peek == '(' && c == ')')
            return true;
        if (peek == '[' && c == ']')
            return true;
        if (peek == '{' && c == '}')
            return true;

        return false;
    }

}