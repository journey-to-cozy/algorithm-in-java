package com.algorithm.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/jewels-and-stones
 * J는 보석이며, S는 갖고 있는 돌이다. S에는 보석이 몇 개나 있을까? 대소문자는 구분한다.
 * input) J = "aA", S = "aAAbbbb"
 * output) 3
 */
public class JewelsAndStones {
	public static void main(String[] args) {
		String jewels = "aA";
		String stones = "aAAbbbb";

		JewelsAndStones solution = new JewelsAndStones();
		System.out.println(solution.numJewelsInStones(jewels, stones));
	}

	public int numJewelsInStones(String jewels, String stones) {
		int result = 0;
		Map<Character, Integer> jewelsMap = new HashMap<>();
		for (Character c : jewels.toCharArray()) {
			jewelsMap.put(c, 0);
		}

		for (Character c : stones.toCharArray()) {
			if (jewelsMap.containsKey(c)) {
				int temp = jewelsMap.get(c);
				jewelsMap.put(c, ++temp);
			}
		}

		for (Character c : jewels.toCharArray()) {
			result += jewelsMap.get(c);
		}

		return result;
	}

}
