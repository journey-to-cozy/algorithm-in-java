package src.sanga.data_structure.graph;

import java.util.*;

/**
 * 시작점에서 도착점까지의 가장 저렴한 가격을 계산하되, K개의 경유지 이내에 도착하는 가격을 리턴하라.
 * 경로가 존재하지 않을 경우 -1을 리턴한다.
 * https://leetcode.com/problems/cheapest-flights-within-k-stops/
 */
class CheapestFlightsWithinKStops {

    public static void main(String[] args) {
        CheapestFlightsWithinKStops cheapestFlightsWithinKStops = new CheapestFlightsWithinKStops();
        System.out.println(cheapestFlightsWithinKStops.findCheapestPrice(3, new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}}, 0, 2, 0)); // 500
        System.out.println(cheapestFlightsWithinKStops.findCheapestPrice(3, new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}}, 0, 2, 1)); // 200
        System.out.println(cheapestFlightsWithinKStops.findCheapestPrice(3, new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}}, 2, 0, 0)); // -1
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<HashMap<Integer, Integer>> map = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            map.add(new HashMap<>());
        }

        for (int[] flight : flights) {
            map.get(flight[0]).put(flight[1], flight[2]);
        }

        Map<Integer, Integer> visited = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        pq.offer(new int[]{src, -1, 0});

        while (!pq.isEmpty()) {
            int[] rn = pq.poll();
            int city = rn[0];
            int stops = rn[1];
            int price = rn[2];

            if (city == dst) return price;

            visited.put(city, stops);

            if (stops == k) continue;

            for (int val : map.get(city).keySet()) {
                if (!visited.containsKey(val) || stops < visited.get(val)) {
                    pq.offer(new int[]{val, stops + 1, price + map.get(city).get(val)});
                }
            }
        }

        return -1;
    }
}