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

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(candidates);
		// dfs(result, new ArrayList<>(), candidates, 0, target);
		dfs2(result, new ArrayList<>(), candidates, target, 0);

		return result;
	}

	private void dfs(List<List<Integer>> result, List<Integer> current, int[] candidates, int index, int target) {
		for (int i = index; i < candidates.length; i++) {
			List<Integer> temp = new ArrayList<>(current);
			if (candidates[i] == target) {
				temp.add(candidates[i]);
				result.add(temp);
				break;
			} else if (candidates[i] < target) {
				temp.add(candidates[i]);
				dfs(result, new ArrayList<>(temp), candidates, i, target - candidates[i]);
			} else {
				break;
			}
		}
		return;
	}

	private void dfs2(List<List<Integer>> list, List<Integer> current, int[] candidates, int target, int index) {
		if (target < 0) return;
		if (target == 0) {
			list.add(new ArrayList<>(current));
			return;
		}

		for (int i = index; i < candidates.length; i++) {
			current.add(candidates[i]);
			dfs2(list, current, candidates,target - candidates[i], i);
			current.remove(current.size() - 1);
		}
	}

	private void dfs3(List<List<Integer>> result, List<Integer> current, int[] candidates, int index, int target) {
		for (int i = index; i < candidates.length; i++) {
			List<Integer> temp = new ArrayList<>(current);
			int candidate = candidates[i];

			if (candidate > target) break;

			temp.add(candidate);

			if (candidate == target) {
				result.add(temp);
				continue;
			}

			dfs3(result, temp, candidates, i, target - candidate);
		}
	}


	private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] candidates, int remain, int start) {
		if (remain < 0) return;
		if (remain == 0) {
			list.add(new ArrayList<>(tempList));
			return;
		}

		for (int i = start; i < candidates.length; i++) {
			tempList.add(candidates[i]);
			backtrack(list, tempList, candidates, remain - candidates[i], i); // 중복을 허용하므로 i + 1이 아님
			tempList.remove(tempList.size() - 1);
		}
	}
}
