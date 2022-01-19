package com.algorithm.tree;

/**
 * https://leetcode.com/problems/minimum-distance-between-bst-nodes/
 * 두 노드 간 값의 차이가 가장 작은 노드의 값의 차이를 출력하라.
 */
public class MinimumDistanceBetweenBSTNodes {

	Integer res = Integer.MAX_VALUE;
	Integer pre = null;

	public static void main(String[] args) {

	}

	public int minDiffInBST(TreeNode root) {
		if (root.left != null)
			minDiffInBST(root.left);

		if (pre != null)
			res = Math.min(res, root.val - pre);
		pre = root.val;

		if (root.right != null)
			minDiffInBST(root.right);

		return res;
	}
}
