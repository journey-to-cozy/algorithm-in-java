package com.algorithm.array;

public class TwoSum {
	// brute force - O(n^2)
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

	public static void main(String[] args) {
		TwoSum solution = new TwoSum();

		int[] nums = {2, 7, 11, 15};
		int target = 9;

		int[] result = solution.twoSum(nums, target);

		for (int i : result) {
			System.out.println(i);
		}
	}
}
