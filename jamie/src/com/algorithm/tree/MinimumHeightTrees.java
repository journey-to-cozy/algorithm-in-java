package com.algorithm.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/minimum-height-trees/
 */
public class MinimumHeightTrees {

	public static void main(String[] args) {
		MinimumHeightTrees solution = new MinimumHeightTrees();
		int[][] edges = {{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}};

		List<Integer> result = solution.findMinHeightTrees(6, edges);

		for (Integer i : result) {
			System.out.println(i);
		}
	}

	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		if (n == 1)
			return Arrays.asList(0);

		List<List<Integer>> adj = new ArrayList<>();
		int[] inLinks = new int[n];
		createGraph(n, edges, adj, inLinks);

		List<Integer> leaves = new LinkedList<>();

		// 첫번째 리프 노드 추가
		for (int i = 0; i < inLinks.length; i++) {
			if (inLinks[i] == 1)
				leaves.add(i);
		}

		// 루트 노드만 남을 때까지 반복 제거
		while (n > 2) {
			List<Integer> newLeaves = new ArrayList<>();

			for (int leaf : leaves) {
				for (int nb : adj.get(leaf)) {
					inLinks[nb]--;
					if (inLinks[nb] == 1)
						newLeaves.add(nb);
				}
			}

			n -= leaves.size();
			leaves = newLeaves;
		}

		return leaves;
	}

	private void createGraph(int n, int[][] edges, List<List<Integer>> adj, int[] inLinks) {
		for (int i = 0; i < n; i++)
			adj.add(new ArrayList<>());

		for (int[] edge : edges) {
			adj.get(edge[0]).add(edge[1]);
			adj.get(edge[1]).add(edge[0]); // 양방향 그래프 구성
			inLinks[edge[0]]++;
			inLinks[edge[1]]++;
		}
	}
}
