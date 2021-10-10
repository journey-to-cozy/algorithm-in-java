package src.sanga.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 이진 트리의 최대 깊이를 구하라
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 */
class MaxiMumDepthOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        TreeNode rightTreeNode = new TreeNode(20);
        root.right = rightTreeNode;
        rightTreeNode.left = new TreeNode(15);
        rightTreeNode.right = new TreeNode(7);

        MaxiMumDepthOfBinaryTree maxiMumDepthOfBinaryTree = new MaxiMumDepthOfBinaryTree();
        System.out.println(maxiMumDepthOfBinaryTree.maxDepth(root)); // 3
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public int maxDepthUsingBFS(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            depth++;
        }

        return depth; // BFS 반복 횟수 = 깊이
    }

}