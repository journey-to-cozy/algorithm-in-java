package com.algorithm.sort;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/valid-anagram/
 */
public class ValidAnagram {

	public boolean isAnagram(String s, String t) {
		char[] sChar = s.toCharArray();
		char[] tChar = t.toCharArray();

		Arrays.sort(sChar);
		Arrays.sort(tChar);

		return Arrays.equals(sChar, tChar);
	}
}
