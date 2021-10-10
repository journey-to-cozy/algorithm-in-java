package src.sanga.tree;

import java.util.Stack;

/**
 * 두 노드 간 값의 차이가 가장 작은 노드의 값의 차이를 출력하라.
 * https://leetcode.com/problems/minimum-distance-between-bst-nodes/
 */
class MinimumDistanceBetweenBSTNodes {
    private TreeNode prev = null;
    private int minDiff = Integer.MAX_VALUE;

    // 재귀 구조로 중위 순회
    public int minDiffInBST(TreeNode root) {
        if (root == null) return minDiff;
        minDiffInBST(root.left);
        if (prev != null) minDiff = Math.min(minDiff, root.val - prev.val);
        prev = root;
        minDiffInBST(root.right);
        return minDiff;
    }

    // 반복 구조로 중위 순회
    public int minDiffInBST2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        int minDiff = Integer.MAX_VALUE;
        TreeNode prev = null;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (prev != null) minDiff = Math.min(minDiff, root.val - prev.val);
            prev = root;
            root = root.right;
        }

        return minDiff;
    }

}