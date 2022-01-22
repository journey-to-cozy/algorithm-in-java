package src.sanga.data_structure.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 노드 개수와 무방향 그래프를 입력받아 트리가 최소 높이가 되는 루트의 목록을 리턴하라
 * https://leetcode.com/problems/minimum-height-trees/
 */
class MinimumHeightTrees {

    public static void main(String[] args) {
        MinimumHeightTrees minimumHeightTrees = new MinimumHeightTrees();
        //minimumHeightTrees.findMinHeightTrees(4, new int[][]{{1, 0}, {1, 2}, {1, 3}});
        //minimumHeightTrees.findMinHeightTrees(6, new int[][]{{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}});
        minimumHeightTrees.findMinHeightTrees2(10, new int[][]{{0, 2}, {1, 2}, {2, 3}, {2, 4}, {3, 5}, {5, 9}, {4, 6}, {4, 7}, {7, 8}});
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if (n <= 0) return res;

        if (n == 1) {
            res.add(0);
            return res;
        }

        int[] degree = new int[n+1];
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
        if (n == 1) {
            leaves.add(0);
            return leaves;
        }

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        for (int i = 0; i < n; i++) {
            if (graph.get(i).size() == 1){
                leaves.add(i);
            }
        }

        int count = n;
        while (count > 2) {
            count -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (Integer leaf : leaves) { // for all current leaves
                for (Integer toRemove : graph.get(leaf)) { // for all current leaves' subtree
                    graph.get(toRemove).remove(Integer.valueOf(leaf)); // remove leaf
                    if (graph.get(toRemove).size() == 1)
                        newLeaves.add(toRemove);
                }
            }
            leaves = newLeaves;
        }

        return leaves;
    }

}