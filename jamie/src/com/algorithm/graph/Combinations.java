package com.algorithm.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/combinations/
 * 전체 수 n을 입력받아 k개의 조합을 리턴하라.
 */
public class Combinations {
	public static void main(String[] args) {
		Combinations solution = new Combinations();
		int n = 4, k = 2;
		System.out.println(solution.combine(n, k));
	}

	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> combinations = new ArrayList<>();
		dfs(combinations, new ArrayList<>(), 1, n, k);
		return combinations;
	}

	private void dfs(List<List<Integer>> combinations, List<Integer> list, int start, int n, int k) {
		if (k == 0) {
			combinations.add(new ArrayList<>(list));
			return;
		}

		for (int i = start; i <= n; i++) {
			list.add(i);
			dfs(combinations, list, i + 1, n, k - 1);
			list.remove(list.size() - 1);
		}
	}
}
