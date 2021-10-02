package com.algorithm.shortestPath;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/problems/network-delay-time/
 */
public class NetworkDelayTime {
	public static void main(String[] args) {
		NetworkDelayTime solution = new NetworkDelayTime();
		int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
		int n = 4, k = 2;
		System.out.println("solution.networkDelayTime(times, n, k) = " + solution.networkDelayTime(times, n, k));
	}

	public int networkDelayTime(int[][] times, int n, int k) {
		Map<Integer, Map<Integer, Integer>> map = new HashMap<>();

		for (int[] time : times) {
			map.putIfAbsent(time[0], new HashMap<>());
			map.get(time[0]).put(time[1], time[2]);
		}

		// distance, node into pq
		Queue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0]) - b[0]);
		pq.add(new int[] {0, k});

		boolean[] visited = new boolean[n + 1];

		int result = 0;

		while (!pq.isEmpty()) {
			int[] current = pq.remove();
			int curNode = current[1];
			int curDist = current[0];

			if (visited[curNode])
				continue;
			visited[curNode] = true;
			result = curDist;
			n--;
			if (n == 0)
				return result;

			if (map.containsKey(curNode)) {
				for (int next : map.get(curNode).keySet())
					pq.add(new int[] {curDist + map.get(curNode).get(next), next});
			}
		}

		return -1;
	}
}
