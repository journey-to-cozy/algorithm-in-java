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

	// 코코 코드
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

	public static void main(String[] args) {
		ValidParentheses solution = new ValidParentheses();
		String s = "()";
		System.out.println(solution.isValid(s));
	}
}
