package com.algorithm.tree;

/**
 * https://leetcode.com/problems/diameter-of-binary-tree/
 * 이진 트리에서 두 노드 간 가장 긴 경로의 길이를 출력하라.
 */
public class DiameterOfBinaryTree {
	int max = 0;

	public static void main(String[] args) {
	}

	public int diameterOfBinaryTree(TreeNode root) {
		maxDepth(root);

		return max;
	}

	private int maxDepth(TreeNode root) {
		if (root == null)
			return 0;

		int left = maxDepth(root.left);
		int right = maxDepth(root.right);

		max = Math.max(max, left + right);

		return Math.max(left, right) + 1;
	}

}
