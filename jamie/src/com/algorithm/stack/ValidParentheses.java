package com.algorithm.stack;

import java.util.Stack;

/**
 * 괄호로 된 입력값이 올바른지 판별하라.
 */
public class ValidParentheses {
	public boolean isValid(String s) {
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

	public static void main(String[] args) {
		ValidParentheses solution = new ValidParentheses();
		String s = "()";
		System.out.println(solution.isValid(s));
	}
}
