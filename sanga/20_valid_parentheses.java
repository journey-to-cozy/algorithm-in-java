package src.sanga;

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
            } else if (stack.empty() || left.indexOf((char) stack.pop()) != right.indexOf(c)) {
                return false;
            }
        }

        return stack.empty();
    }
}