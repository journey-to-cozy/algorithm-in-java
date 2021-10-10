package com.algorithm.stringManipulation;

/**
 * https://leetcode.com/problems/valid-palindrome/
 * 주어진 문자열이 팰린드롬인지 확인하라.
 * 대소문자를 구분하지 않으며, 영문자와 숫자만을 대상으로 한다.
 */
public class ValidPalindrome {

	public static void main(String[] args) {
		ValidPalindrome solution = new ValidPalindrome();
		String s = "A man, a plan, a canal: Panama";
		System.out.println(solution.isPalindrome(s));
	}
	public boolean isPalindrome(String s) {
		char[] chars = s.toLowerCase().replaceAll("[^a-z0-9]", "").toCharArray();
		int left = 0;
		int right = chars.length - 1;

		while (left < right) {
			if (chars[left] == chars[right]) {
				left += 1;
				right -= 1;
				continue;
			}
			return false;
		}
		return true;
	}
}
