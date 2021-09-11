package com.algorithm.graph;

/**
 * https://leetcode.com/problems/number-of-islands/
 * 1을 육지로, 0을 물로 가정한 2D 그리드 맵이 주어졌을 때, 섬의 개수를 계산하라.
 * (연결되어 있는 1의 덩어리 개수를 구하라.)
 */
public class NumberOfIslands {

	private int n;
	private int m;

	public static void main(String[] args) {
		NumberOfIslands solution = new NumberOfIslands();
		char[][] grid = {
				{'1', '1', '1', '1', '0'},
				{'1', '1', '0', '1', '0'},
				{'1', '1', '0', '0', '0'},
				{'0', '0', '0', '0', '0'}
		};

		System.out.println(solution.numIslands(grid));
	}

	public int numIslands(char[][] grid) {
		int count = 0;

		n = grid.length;
		// 예외처리
		if (n == 0)
			return 0;

		m = grid[0].length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == '1') {
					dfs(grid, i, j);
					// 모든 육지 탐색 후 카운트 1 증가
					++count;
				}
			}
		}
		return count;
	}

	private void dfs(char[][] grid, int i, int j) {
		// 더이상 땅이 아닌 경우 종료
		if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1')
			return;
		grid[i][j] = '0';

		// 동서남북 탐색
		dfs(grid, i + 1, j);
		dfs(grid, i - 1, j);
		dfs(grid, i, j + 1);
		dfs(grid, i, j - 1);
	}
}
