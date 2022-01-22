package src.sanga.data_structure.tree;

/**
 * 오름차순으로 정렬된 배열을 높이 균형 이진 탐색 트리로 변환하라
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 */
class ConvertSortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int l, int r) {
        if (l > r) return null;
        int mid = l + (r - l) / 2; // avoid integer overflow
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums, l, mid - 1);
        node.right = helper(nums, mid + 1, r);
        return node;
    }
}