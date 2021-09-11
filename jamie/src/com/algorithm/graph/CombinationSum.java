package com.algorithm.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum/
 * 숫자 집합 candidates를 조합하여 합이 target이 되는 원소를 나열하라. 각 원소는 중복으로 나열 가능하다.
 */
public class CombinationSum {
	public static void main(String[] args) {
		CombinationSum solution = new CombinationSum();
		int[] candidates = {2, 3, 6, 7};
		int target = 7;
		System.out.println(solution.combinationSum(candidates, target));
	}

	List<List<Integer>> result = new ArrayList<>();

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		dfs(new ArrayList<>(), candidates, 0, target);

		return result;
	}

	private void dfs(List<Integer> current, int[] candidates, int index, int target) {
		for (int i = index; i < candidates.length; i++) {
			List<Integer> temp = new ArrayList<>(current);
			if (candidates[i] == target) {
				temp.add(candidates[i]);
				result.add(temp);
				break;
			} else if (candidates[i] < target) {
				temp.add(candidates[i]);
				dfs(new ArrayList<>(temp), candidates, i, target - candidates[i]);
			} else {
				break;
			}
		}
		return;
	}
}
