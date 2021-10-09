package src.sanga.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 0을 완료하기 위해서는 1을 끝내야 한다는 것을 [0,1] 쌍으로 표현하는 n 개의 코스가 있다.
 * 코스 개수 n과 이 쌍들을 입력으로 받았을 때 모든 코스가 완료 가능한지 판별하라.
 * 즉, 그래프가 순환 구조인지를 판별하는 문제
 * https://leetcode.com/problems/course-schedule/
 */
class CourseSchedule {
    public static void main(String[] args) {
        CourseSchedule courseSchedule = new CourseSchedule();
        courseSchedule.canFinish(2, new int[][]{{1, 0}}); // true
        courseSchedule.canFinish(3, new int[][]{{1, 0}, {0, 1}}); // false
        courseSchedule.canFinish(5, new int[][]{{0, 1}, {0, 2}, {1, 3}, {1, 4}, {3, 4}}); // true
        courseSchedule.canFinish(3, new int[][]{{0, 1}, {1, 2}, {2, 0}}); // false
    }

    public boolean canFinish(int num, int[][] pre) {
        List<List<Integer>> graph = new ArrayList<>(num);
        for (int i = 0; i < num; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < pre.length; i++) {
            graph.get(pre[i][0]).add(pre[i][1]);
        }

        int visited[] = new int[num];
        for (int i = 0; i < num; i++) {
            if (!dfs(graph, visited, i)) return false;
        }

        return true;
    }

    /**
     * 0 - not visited 방문하지 않음
     * 1 - being visited 방문중
     * 2 - done visited 방문완료 -> only root node without cyclic can reach this state
     */
    private boolean dfs(List<List<Integer>> graph, int visited[], int vertex) {
        visited[vertex] = 1;

        List<Integer> childNode = graph.get(vertex);
        for (int i = 0; i < childNode.size(); i++) {
            int toVisit = childNode.get(i);
            if (visited[toVisit] == 1) return false; // has been visited while visiting its children - cycle
            if (visited[toVisit] == 0) {
                if (!dfs(graph, visited, toVisit)) return false;
            }
        }

        visited[vertex] = 2;
        return true;
    }

    public boolean canFinish2(int numCourses, int[][] pres) {
        if (numCourses == 0 || pres.length == 0) return true;
        int[] inDegree = new int[numCourses];
        for (int[] pre : pres) {
            inDegree[pre[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) queue.add(i);
        }

        int count = queue.size();
        while (!queue.isEmpty()) {
            int preRequisite = queue.poll();
            for (int[] pre : pres) {
                if (pre[1] == preRequisite) {
                    inDegree[pre[0]]--;
                    if (inDegree[pre[0]] == 0) {
                        queue.add(pre[0]);
                        count++;
                    }
                }
            }
        }

        return count == numCourses;
    }

}