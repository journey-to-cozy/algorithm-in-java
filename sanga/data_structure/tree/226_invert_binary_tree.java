package src.sanga.data_structure.tree;

import java.util.*;

/**
 * https://leetcode.com/problems/invert-binary-tree/
 */
class InvertBinaryTree {

    // recursive
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.right = left;
        root.left = right;

        return root;
    }

    // iterative BFS
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        return root;
    }

    // iterative DFS
    public TreeNode invertTree3(TreeNode root) {
        if (root == null) return null;

        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            if(node.left!=null) stack.push(node.left);
            if(node.right!=null) stack.push(node.right);
        }

        return root;
    }

    // iterative DFS
    public TreeNode invertTree4(TreeNode root) {
        if (root == null) return null;

        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            if(node.left!=null) stack.push(node.left);
            if(node.right!=null) stack.push(node.right);

            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
        }

        return root;
    }

}