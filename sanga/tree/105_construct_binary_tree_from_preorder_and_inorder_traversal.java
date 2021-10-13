package src.sanga.tree;


/**
 * 트리의 전위, 중위 순회 결과를 입력값으로 받아 이진 트리를 구축하라.
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 */
class ConstructBinaryTree {

    // 1) Preorder 배열의 첫 번째 값은 부모 노드(root)이다.
    // 2) Inorder 배열에서 Preorder 배열의 첫 번째 값과 동일한 값을 찾는다.
    // 3) Inorder 배열은 Preorder 배열의 첫 번째 값을 기준으로 왼쪽, 오른쪽으로 나눌 수 있다.

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length != inorder.length) return null;
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);

        int rootIndex = inStart; // 중위순회에서 현재 root의 인덱스
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                rootIndex = i;
            }
        }

        int leftTreeLength = rootIndex - inStart;
        root.left = helper(preorder, preStart + 1, preStart + leftTreeLength, inorder, inStart, rootIndex - 1);
        root.right = helper(preorder, preStart + leftTreeLength + 1, preEnd, inorder, rootIndex + 1, inEnd);
        return root;
    }

}