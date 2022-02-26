package com.algorithm.bitManipulation;

/**
 * https://leetcode.com/problems/single-number
 * 딱 하나를 제외하고 모든 엘리먼트는 2개씩 있다. 1개인 엘리먼트를 찾아라.
 */
public class SingleNumber {

	// XOR 풀이
	public int singleNumber(int[] nums) {
		int result = 0;

		for (Integer num : nums) {
			result ^= num;
		}
		return result;
	}
}
