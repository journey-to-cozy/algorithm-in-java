package src.sanga.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 노드 개수와 무방향 그래프를 입력받아 트리가 최소 높이가 되는 루트의 목록을 리턴하라
 * https://leetcode.com/problems/minimum-height-trees/
 */
class MinimumHeightTrees {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if (n <= 0) return res;

        if (n == 1) {
            res.add(0);
            return res;
        }

        int[] degree = new int[n];
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            degree[edge[0]]++;
            degree[edge[1]]++;
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                queue.add(i);
            }
        }

        while (n > 2) {
            int size = queue.size();
            n -= size;

            while (size-- > 0) {
                int value = queue.poll();
                for (int i : graph.get(value)) {
                    degree[i]--;
                    if (degree[i] == 1) {
                        queue.add(i);
                    }
                }
            }
        }

        res.addAll(queue);

        return res;
    }

    public List<Integer> findMinHeightTrees2(int n, int[][] edges) {
        List<Integer> leaves = new ArrayList<>();

        if (n == 0) return leaves;
        else if (n == 1) {
            leaves.add(0);
            return leaves;
        }

        List<Integer>[] lists = new ArrayList[n];
        for (int i = 0; i < n; i++) lists[i] = new ArrayList<>();

        for (int[] e : edges) {
            int v1 = e[0], v2 = e[1];
            lists[v1].add(v2);
            lists[v2].add(v1);
        }

        for (int i = 0; i < n; i++) if (lists[i].size() == 1) leaves.add(i);

        int count = n;
        while (count > 2) {
            count -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (Integer leaf : leaves) { // for all current leaves
                for (Integer toRemove : lists[leaf]) { // for all current leaves' subtree
                    lists[toRemove].remove(Integer.valueOf(leaf)); // remove leaf
                    if (lists[toRemove].size() == 1)
                        newLeaves.add(toRemove);
                }
            }
            leaves = newLeaves;
        }
        return leaves;
    }

}