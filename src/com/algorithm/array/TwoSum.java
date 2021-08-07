package com.algorithm.array;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	// brute force - O(n^2), 52ms
	public int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		boolean flag = false;

		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					result[0] = i;
					result[1] = j;
					flag = true;
					break;
				}
			}
			if (flag)
				break;
		}
		return result;
	}

	// HashMap, 4ms
	public int[] twoSumByHashMap(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		int[] result = new int[2];

		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i])) {
				result[0] = i;
				result[1] = map.get(target - nums[i]);
			}
			map.put(nums[i], i);
		}
		return result;
	}

	public static void main(String[] args) {
		TwoSum solution = new TwoSum();

		int[] nums = {2, 7, 11, 15};
		int target = 9;

		int[] result = solution.twoSumByHashMap(nums, target);

		for (int i : result) {
			System.out.println(i);
		}
	}
}
