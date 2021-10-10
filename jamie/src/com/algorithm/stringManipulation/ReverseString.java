package com.algorithm.stringManipulation;

/**
 * https://leetcode.com/problems/reverse-string/
 * 문자열을 뒤집는 함수를 작성하라.
 * 리턴 없이 리스트 내부를 직접 조작하라.
 */
public class ReverseString {
	public static void main(String[] args) {
		ReverseString solution = new ReverseString();
		char[] s = {'h', 'e', 'l', 'l', 'o'};
		solution.reverseString(s);
		System.out.println(s);
	}

	public void reverseString(char[] s) {
		int left = 0;
		int right = s.length - 1;

		while (left < right) {
			char temp = s[left];
			s[left] = s[right];
			s[right] = temp;
			left++;
			right--;
		}
	}
}
