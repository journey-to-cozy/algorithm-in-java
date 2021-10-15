package com.algorithm.tree;

/**
 * https://leetcode.com/problems/merge-two-binary-trees/
 * 두 이진 트리를 병합하라. 중복되는 노드는 값을 합산한다.
 */
public class MergeTwoBinaryTrees {

	public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null)
			return null;

		int val = (root1 == null ? 0 : root1.val) + (root2 == null ? 0 : root2.val);
		TreeNode newNode = new TreeNode(val);

		newNode.left = mergeTrees(root1 == null ? null : root1.left, root2 == null ? null : root2.left);
		newNode.right = mergeTrees(root1 == null ? null : root1.right, root2 == null ? null : root2.right);

		return newNode;
	}
}
