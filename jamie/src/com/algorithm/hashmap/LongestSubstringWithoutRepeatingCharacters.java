package com.algorithm.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters
 * 중복 문자가 없는 가장 긴 부분 문자열(substring)의 길이를 리턴하라.
 * input) "abcabcbb"
 * output) 3
 * 정답은 "abc"로 길이는 3이다.
 */
public class LongestSubstringWithoutRepeatingCharacters {
	public static void main(String[] args) {
		LongestSubstringWithoutRepeatingCharacters solution = new LongestSubstringWithoutRepeatingCharacters();
		String s = "abcabcbb";
		System.out.println(solution.lengthOfLongestSubstring(s));
	}

	public int lengthOfLongestSubstring(String s) {
		int start = 0;
		int max = 0;

		Map<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i)) && start <= map.get(s.charAt(i))) {
				start = map.get(s.charAt(i)) + 1;
			} else {
				max = Math.max(max, i - start + 1);
			}

			map.put(s.charAt(i), i);
		}

		return max;
	}
}
