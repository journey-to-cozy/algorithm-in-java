package com.algorithm.tree;

/**
 * https://leetcode.com/problems/diameter-of-binary-tree/
 * 이진 트리에서 두 노드 간 가장 긴 경로의 길이를 출력하라.
 */
public class DiameterOfBinaryTree {
	int max = 0;

	public static void main(String[] args) {

		TreeNode childNode1 = new TreeNode(15);
		TreeNode childNode2 = new TreeNode(7);
		TreeNode right = new TreeNode(20, childNode1, childNode2);
		TreeNode left = new TreeNode(9);
		TreeNode root = new TreeNode(3, left, right);

		DiameterOfBinaryTree solution = new DiameterOfBinaryTree();
		System.out.println(solution.diameterOfBinaryTree(root));
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
