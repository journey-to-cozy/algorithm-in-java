package com.algorithm.tree;

/**
 * https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
 * BST의 각 노드를 현재 값보다 더 큰 값을 가진 모든 노드의 합으로 만들어라.
 */
public class BSTtoGreaterSumTree {

	int pre = 0;

	public static void main(String[] args) {

	}

	public TreeNode bstToGst(TreeNode root) {
		if (root.right != null)
			bstToGst(root.right);

		root.val = pre + root.val;
		pre = root.val;

		if (root.left != null)
			bstToGst(root.left);

		return root;
	}
}
