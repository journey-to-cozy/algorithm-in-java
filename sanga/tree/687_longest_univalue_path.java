package src.sanga.tree;

/**
 * 동일한 값을 지닌 가장 긴 경로를 찾아라
 * https://leetcode.com/problems/longest-univalue-path/
 */
class LongestUniValuePath {
    int max = 0;

    public int longestUnivaluePath(TreeNode root) {
        arrowLength(root);
        return max;
    }

    private int arrowLength(TreeNode node) {
        if (node == null) return 0;

        int left = arrowLength(node.left);
        int right = arrowLength(node.right);
        int arrowLeft = 0;
        int arrowRight = 0;

        if (node.left != null && node.left.val == node.val) arrowLeft += left + 1;
        if (node.right != null && node.right.val == node.val) arrowRight += right + 1;

        max = Math.max(max, arrowLeft + arrowRight);

        return Math.max(arrowLeft, arrowRight);
    }

    private int arrowLength2(TreeNode node) {
        if (node == null) return 0;

        int left = arrowLength2(node.left);
        int right = arrowLength2(node.right);

        if (node.left != null && node.left.val == node.val) {
            left += 1;
        } else {
            left = 0;
        }

        if (node.right != null && node.right.val == node.val) {
            right += 1;
        } else {
            right = 0;
        }

        max = Math.max(max, left + right);

        return Math.max(left, right);
    }


    int result = 0;

    public int longestUnivaluePath2(TreeNode root) {
        if (root == null)
            return 0;

        result = 0;
        dfs(root, root.val);

        return result;
    }

    public int dfs(TreeNode node, int val) {
        if (node == null)
            return 0;

        int left = dfs(node.left, node.val);
        int right = dfs(node.right, node.val);
        result = Math.max(result, left + right);

        if (val == node.val)
            return Math.max(left, right) + 1;

        return 0;
    }

}