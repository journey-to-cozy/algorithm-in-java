package com.algorithm.tree;

public class LongestUnivaluePath {

	int result = 0;

	public int longestUnivaluePath(TreeNode root) {
		if (root == null)
			return 0;

		result = 0;
		dfs(root, root.val);

		return result;
	}

	public int dfs(TreeNode node, int val) {
		if (node == null)
			return 0;

		int left = dfs(node.left, node.val);
		int right = dfs(node.right, node.val);
		result = Math.max(result, left + right);

		if (val == node.val)
			return Math.max(left, right) + 1;

		return 0;
	}
}
