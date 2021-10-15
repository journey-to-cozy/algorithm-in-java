package com.algorithm.tree;

public class LongestUnivaluePath {

	int result;

	public static void main(String[] args) {

		TreeNode childNode1 = new TreeNode(1);
		TreeNode childNode2 = new TreeNode(1);
		TreeNode childNode3 = new TreeNode(5);
		TreeNode left = new TreeNode(4, childNode1, childNode2);
		TreeNode right = new TreeNode(5, null, childNode3);
		TreeNode root = new TreeNode(5, left, right);

		LongestUnivaluePath solution = new LongestUnivaluePath();
		System.out.println(solution.longestUnivaluePath(root));
	}

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
