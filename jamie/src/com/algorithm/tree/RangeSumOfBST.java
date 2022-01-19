package com.algorithm.tree;

/**
 * https://leetcode.com/problems/range-sum-of-bst/
 * 이진 탐색 트리(BST)가 주어졌을 때, L 이상 R 이하의 값을 지닌 노드의 합을 구하여라.
 */
public class RangeSumOfBST {

	public int rangeSumBST(TreeNode root, int low, int high) {
		if (root == null)
			return 0;

		if (root.val < low)
			return rangeSumBST(root.right, low, high);

		if (root.val > high)
			return rangeSumBST(root.left, low, high);

		return root.val + rangeSumBST(root.right, low, high) + rangeSumBST(root.left, low, high);
	}
}
