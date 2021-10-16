package com.algorithm.tree;

/**
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 * 정렬된 배열의 이진 탐색 트리 변환
 * 오름차순으로 정렬된 배열을 높이 균형의 이진 탐색 트리로 변환하라.
 */
public class ConvertSortedArrayToBST {
	public static void main(String[] args) {
		ConvertSortedArrayToBST solution = new ConvertSortedArrayToBST();
		int[] nums = {-10, -7, -3, 0, 5, 7, 9};
		solution.sortedArrayToBST(nums);
	}

	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums.length == 0)
			return null;

		TreeNode root = helper(nums, 0, nums.length - 1);

		return root;
	}

	private TreeNode helper(int[] nums, int low, int high) {
		if (low > high)
			return null;

		int mid = low + (high - low) / 2;

		TreeNode node = new TreeNode(nums[mid]);
		node.left = helper(nums, low, mid - 1);
		node.right = helper(nums, mid + 1, high);

		return node;
	}
}
