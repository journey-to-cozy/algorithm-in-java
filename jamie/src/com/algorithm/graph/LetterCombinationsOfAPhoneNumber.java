package com.algorithm.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * 2에서 9까지 숫자가 주어졌을 때 전화번호로 조합 가능한 모든 문자를 출력하라.
 */
public class LetterCombinationsOfAPhoneNumber {

	public static void main(String[] args) {
		LetterCombinationsOfAPhoneNumber solution = new LetterCombinationsOfAPhoneNumber();
		String digits = "23";
		System.out.println(solution.letterCombinations(digits));

	}

	String[] chars = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

	public List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<>();

		if (digits == null || digits.length() == 0) return result;
		dfs(result, new StringBuilder(), digits, 0);

		return result;
	}

	private void dfs(List<String> result, StringBuilder sb, String digits, int index) {
		if (index == digits.length()) {
			result.add(sb.toString());
			return;
		}

		String str = chars[digits.charAt(index) - '0'];

		for (char c : str.toCharArray()) {
			sb.append(c);
			dfs(result, sb, digits, index + 1);
			sb.setLength(sb.length() - 1);
		}
	}

}
