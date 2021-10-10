package com.algorithm.stringManipulation;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 * 가장 긴 팰린드롬 부분 문자열을 출력하라.
 */
public class LongestPalindromeSubstring {

	public static void main(String[] args) {
		LongestPalindromeSubstring solution = new LongestPalindromeSubstring();
		String s = "babad";
		System.out.println(solution.longestPalindrome(s));
	}

	public String longestPalindrome(String s) {
		if (s == null || s.length() < 1) {
			return "";
		}

		int start = 0;
		int end = 0;

		for (int i = 0; i < s.length(); i++) {
			int len1 = expand(i, i, s);
			int len2 = expand(i, i + 1, s);
			int length = Math.max(len1, len2);

			if (length > end - start) {
				start = i - (length - 1) / 2;
				end = i + length / 2;
			}
		}

		return s.substring(start, end + 1);
	}

	private int expand(int left, int right, String s) {
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left -= 1;
			right += 1;
		}

		return right - left - 1;
	}
}
