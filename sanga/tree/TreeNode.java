package src.sanga.tree;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode();
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(5, new TreeNode(6), new TreeNode(7)));
        treeNode.preorder(root); // 1-2-3-4-5-6-7
        treeNode.inorder(root); // 3-2-4-1-6-5-7
        treeNode.postorder(root); // 3-4-2-6-7-5-1
    }

    // 전위 순회 (NLR, 현재 노드를 먼저 순회한 다음 왼쪽과 오른쪽 서브트리를 순회)
    private void preorder(TreeNode root) {
        if (root == null) return;
        print(root.val);
        preorder(root.left);
        preorder(root.right);
    }

    // 중위 순회 (LNR, 왼쪽 서브트리를 순회한 다음 현재 노드 순회하고 오른쪽 서브트리 순회)
    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        print(root.val);
        inorder(root.right);
    }

    // 후위 순회 (LRN, 왼쪽과 오른쪽 서브트리를 순회한 다음 현재 노드 순회)
    private void postorder(TreeNode root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        print(root.val);
    }

    private void print(int val) {
        System.out.println(val);
    }

}
