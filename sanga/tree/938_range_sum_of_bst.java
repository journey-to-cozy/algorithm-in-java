package src.sanga.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 이진 탐색 트리(BST)가 주어졌을 때, low 이상, high 이하의 값을 지닌 노드의 합을 구하라.
 * https://leetcode.com/problems/range-sum-of-bst/
 */
class RangeSumOfBST {

    // 재귀 구조 DFS로 브루트 포스 탐색
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0; // base case.
        return (root.val >= low && root.val <= high ? root.val : 0) + rangeSumBST(root.right, low, high) + rangeSumBST(root.left, low, high);
    }

    public int rangeSumBST2(TreeNode root, int low, int high) {
        if (root == null) return 0;
        int n = 0;
        if (root.val >= low && root.val <= high) n = root.val;
        n += rangeSumBST2(root.left, low, high);
        n += rangeSumBST2(root.right, low, high);
        return n;
    }

    // DFS 가지치기로 필요한 노드 탐색
    public int rangeSumBST3(TreeNode root, int low, int high) {
        if (root == null) return 0;
        // 현재 노드 root가 low보다 작을 경우, 더 이상 왼쪽 가지는 탐색할 필요가 없기 때문에, 오른쪽만 탐색하도록 재귀 호출 리턴
        if (root.val < low) return rangeSumBST3(root.right, low, high);
        if (root.val > high) return rangeSumBST3(root.left, low, high);
        return root.val + rangeSumBST3(root.left, low, high) + rangeSumBST3(root.right, low, high); // 오른쪽 왼쪽의 자식들을 모두 더함
    }

    // 반복 구조 DFS로 필요한 노드 탐색
    public int rangeSumBST4(TreeNode root, int low, int high) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int sum = 0;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                // 유효한 노드만 스택에 계속 집어 넣는다.
                if (node.val > low) stack.push(node.left);
                if (node.val < high) stack.push(node.right);
                // low와 high 사이의 값인 경우 값을 더해 나간다.
                if (node.val >= low && node.val <= high) sum += node.val;
            }
        }
        return sum;
    }

    // 반복 구조 BFS로 필요한 노드 탐색
    public int rangeSumBST5(TreeNode root, int low, int high){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int sum =0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                // 유효한 노드만 스택에 계속 집어 넣는다.
                if (node.val > low) queue.offer(node.left);
                if (node.val < high) queue.offer(node.right);
                // low와 high 사이의 값인 경우 값을 더해 나간다.
                if (node.val >= low && node.val <= high) sum += node.val;
            }
        }
        return sum;
    }


}