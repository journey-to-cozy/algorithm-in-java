package com.algorithm.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets/
 * 모든 부분집합을 리턴하라.
 */
public class Subsets {

	public static void main(String[] args) {
		Subsets solution = new Subsets();
		int[] nums = {1, 2, 3};
		System.out.println(solution.subsets(nums));
	}

	public List<List<Integer>> subsets(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<>();
		dfs(nums, 0, new ArrayList<>(), result);

		return result;
	}

	private void dfs(int[] nums, int index, List<Integer> path, List<List<Integer>> result) {
		result.add(path);

		for (int i = index; i < nums.length; i++) {
			List<Integer> temp = new ArrayList<>(path);
			temp.add(nums[i]);
			dfs(nums, i + 1, temp, result);
		}
	}
}
