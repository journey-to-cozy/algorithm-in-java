package src.sanga.data_structure.tree;

/**
 * 이진 트리에서 두 노드 간 가장 긴 경로의 길이를 출력하라
 * https://leetcode.com/problems/diameter-of-binary-tree/
 */
class DiameterOfBinaryTree {
    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }

    // 주어진 노드에서 트리의 높이를 반환하는 함수다.
    private int maxDepth(TreeNode node) {
        if (node == null) return -1; // 노드가 없으면

        // 하위트리들의 왼쪽, 오른쪽 높이를 찾는다
        int left = maxDepth(node.left);
        int right = maxDepth(node.right);

        max = Math.max(max, left + right + 2);

        // 상태값(높이)
        return Math.max(left, right) + 1;
    }


    private int maxDepth2(TreeNode node) {
        if (node == null) return 0;

        int left = maxDepth2(node.left);
        int right = maxDepth2(node.right);

        max = Math.max(max, left + right);

        return Math.max(left, right) + 1;
    }
}