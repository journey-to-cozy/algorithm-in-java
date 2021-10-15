package com.algorithm.tree;

/**
 * https://leetcode.com/problems/invert-binary-tree/
 * 중앙을 기준으로 이진 트리를 반전하라.
 */
public class InvertBinaryTree {

	public TreeNode invertTree(TreeNode root) {
		if (root == null)
			return null;

		final TreeNode left = root.left;
		final TreeNode right = root.right;

		root.left = invertTree(right);
		root.right = invertTree(left);

		return root;
	}
}
