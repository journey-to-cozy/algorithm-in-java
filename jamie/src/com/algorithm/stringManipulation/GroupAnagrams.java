package com.algorithm.stringManipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/group-anagrams/
 * 문자열 배열을 받아 애너그램 단위로 그룹핑하라.
 */
public class GroupAnagrams {

	public static void main(String[] args) {
		GroupAnagrams solution = new GroupAnagrams();
		String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };

		System.out.println(solution.groupAnagrams(strs));
	}

	public List<List<String>> groupAnagrams(String[] strs) {
		if (strs == null || strs.length == 0)
			return new ArrayList<>();

		Map<String, List<String>> map = new HashMap<>();

		for (String str : strs) {
			char[] chars = str.toCharArray();
			Arrays.sort(chars);
			String key = String.valueOf(chars);

			if (!map.containsKey(key)) {
				map.put(key, new ArrayList<>());
			}

			map.get(key).add(str);

		}

		return new ArrayList<>(map.values());
	}

}
