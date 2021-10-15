package com.algorithm.tree;

/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * 이진 트리의 최대 깊이를 구하라.
 */
public class MaximumDepthOfBinaryTree {
	public static void main(String[] args) {

		TreeNode childNode1 = new TreeNode(15);
		TreeNode childNode2 = new TreeNode(7);
		TreeNode right = new TreeNode(20, childNode1, childNode2);
		TreeNode left = new TreeNode(9);
		TreeNode root = new TreeNode(3, left, right);

		MaximumDepthOfBinaryTree solution = new MaximumDepthOfBinaryTree();
		System.out.println(solution.maxDepth(root));

	}

	public int maxDepth(TreeNode root) {
		if (root == null)
			return 0;

		int left = maxDepth(root.left);
		int right = maxDepth(root.right);

		int depth = Math.max(left, right) + 1;

		return depth;
	}

}