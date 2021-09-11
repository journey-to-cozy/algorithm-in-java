package com.algorithm.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/permutations/
 * 서로 다른 정수를 입력받아 가능한 모든 순열을 리턴하라.
 */
public class Permutations {
	public static void main(String[] args) {
		Permutations solution = new Permutations();
		int[] nums = {1, 2, 3};
		System.out.println(solution.permute(nums));
	}

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();

		if (nums == null || nums.length == 0)
			return result;
		dfs(result, new ArrayList<>(), nums);

		return result;
	}

	private void dfs(List<List<Integer>> result, List<Integer> list, int[] nums) {
		if (list.size() == nums.length) {
			result.add(new ArrayList<>(list));
		} else {
			for (int i = 0; i <= list.size(); i++) {
				list.add(i, nums[list.size()]);
				dfs(result, list, nums);
				list.remove(i);
			}
		}
	}
}
