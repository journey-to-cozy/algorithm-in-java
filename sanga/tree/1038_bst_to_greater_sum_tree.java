package src.sanga.tree;

/**
 * BST의 각 노드를 현재값보다 더 큰 값을 가진 모든 노드의 합으로 만들어라
 * https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
 */
class BSTToGreaterSumTree {

    private int sum = 0;

    public TreeNode bstToGst(TreeNode root) {
        if (root == null) return null;
        bstToGst(root.right);
        sum += root.val;
        root.val = sum;
        bstToGst(root.left);
        return root;
    }

    public TreeNode bstToGst2(TreeNode root) {
        bstToGstHelper(root, 0);
        return root;
    }

    private int bstToGstHelper(TreeNode node, int sum) {
        if (node == null) return sum;
        node.val += bstToGstHelper(node.right, sum);
        return bstToGstHelper(node.left, node.val);
    }

}