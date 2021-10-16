package src.sanga.tree;

/**
 * 이진 트리가 높이 균형인지(모든 노드의 서브 트리 간의 높이 차이가 1 이하인 것) 판단하라
 * https://leetcode.com/problems/balanced-binary-tree/
 */
class BalancedBinaryTree {

    private boolean result = true;

    public boolean isBalanced(TreeNode root) {
        maxDepth(root);
        return result;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if (Math.abs(left - right) > 1) {
            result = false;
            return 0; // 재귀 종료
        }
        return 1 + Math.max(left, right);
    }

}