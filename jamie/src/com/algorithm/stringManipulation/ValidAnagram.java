package com.algorithm.stringManipulation;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/valid-anagram/
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 */
public class ValidAnagram {
	public static void main(String[] args) {
		ValidAnagram solution = new ValidAnagram();

		String s = "a";
		String t = "ab";

		System.out.println(solution.isAnagram(s, t));
	}

	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) return false;

		char[] sArray = s.toCharArray();
		char[] tArray = t.toCharArray();

		Arrays.sort(sArray);
		Arrays.sort(tArray);

		for (int i = 0; i < sArray.length; i++) {
			if (sArray[i] != tArray[i]) {
				return false;
			}
		}
		return true;
	}
}
