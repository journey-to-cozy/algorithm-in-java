package com.algorithm.tree;

/**
 * https://leetcode.com/problems/balanced-binary-tree/
 * 이진 트리가 높이 균형(Height-Balanced)인지 판단하라.
 * 높이 균형은 모든 노드의 서브 트리 간의 높이 차이가 1 이하인 것을 말한다.
 */
public class BalancedBinaryTree {

	boolean result = true;

	public boolean isBalanced(TreeNode root) {
		maxDepth(root);

		return result;
	}

	private int maxDepth(TreeNode root) {
		if (root == null)
			return 0;

		if (!result)
			return 0;

		int left = maxDepth(root.left);
		int right = maxDepth(root.right);

		if (Math.abs(left - right) > 1)
			result = false;

		return Math.max(left, right) + 1;

	}
}
