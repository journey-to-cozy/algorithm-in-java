package com.algorithm.shortestPath;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/problems/cheapest-flights-within-k-stops/
 */
public class CheapestFlightsWithinKStops {
	public static void main(String[] args) {
		CheapestFlightsWithinKStops solution = new CheapestFlightsWithinKStops();
		int n = 3;
		int[][] flights = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
		int src = 0, dst = 2, k = 0;
		System.out.println(solution.findCheapestPrice(n, flights, src, dst, k));
	}

	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
		List<HashMap<Integer, Integer>> map = new ArrayList<>();

		for (int i = 0; i < n; i++)
			map.add(new HashMap<>());

		for (int[] f : flights)
			map.get(f[0]).put(f[1], f[2]);

		Map<Integer, Integer> visited = new HashMap<>();
		Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);

		pq.offer(new int[] {src, -1, 0});

		while (!pq.isEmpty()) {
			int[] rn = pq.poll();
			int city = rn[0];
			int stops = rn[1];
			int price = rn[2];

			if (city == dst)
				return price;

			visited.put(city, stops);

			if (stops == k)
				continue; // 경유지가 k와 같으면 pq에 offer하지 않음

			for (int val : map.get(city).keySet()) {
				if (!visited.containsKey(val) || stops < visited.get(val))
					pq.offer(new int[] {val, stops + 1, price + map.get(city).get(val)});
			}
		}

		return -1;
	}
}
