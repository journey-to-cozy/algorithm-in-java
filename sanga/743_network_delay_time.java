package src.sanga;

import java.util.*;

/**
 * k부터 출발해 모든 노드가 신호를 받을 수 있는 시간을 계산하라. 불가능할 경우 -1을 리턴한다.
 * 입력값 (u, v, w)는 각각 출발지, 도착지, 소요 시간으로 구성되며, 전체 노드의 개수는 N으로 입력받는다.
 * https://leetcode.com/problems/network-delay-time/
 */
class NetworkDelayTime {

    public static void main(String[] args) {
        NetworkDelayTime networkDelayTime = new NetworkDelayTime();
        networkDelayTime.networkDelayTime(new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}}, 4, 2); // 2
        networkDelayTime.networkDelayTime(new int[][]{{1, 3, 1}, {1, 2, 4}, {3, 4, 1}, {4, 2, 1}}, 4, 1); // 3
        networkDelayTime.networkDelayTime(new int[][]{{1, 2, 1}}, 2, 2); // -1
        networkDelayTime.networkDelayTime(new int[][]{{3, 1, 5}, {3, 2, 2}, {2, 1, 2}, {3, 4, 1}, {4, 5, 1}, {5, 6, 1}, {6, 7, 1}, {7, 8, 1}, {8, 1, 1}}, 8, 3); // 5
    }

    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int[] time : times) {
            map.putIfAbsent(time[0], new HashMap<>());
            map.get(time[0]).put(time[1], time[2]);
        }

        Queue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));

        pq.add(new int[]{0, K});

        boolean[] visited = new boolean[N + 1];
        int res = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.remove();
            int curNode = cur[1];
            int curDist = cur[0];
            if (visited[curNode]) continue;
            visited[curNode] = true;
            res = curDist;
            N--;
            if (N == 0) return res;
            if (map.containsKey(curNode)) {
                for (int next : map.get(curNode).keySet()) {
                    pq.add(new int[]{curDist + map.get(curNode).get(next), next});
                }
            }
        }
        return -1;
    }

}