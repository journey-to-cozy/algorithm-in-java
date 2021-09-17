package com.algorithm.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/reconstruct-itinerary/
 * [from, to]로 구성된 항공권 목록을 이용해 JFK에서 출발하는 여행 일정을 구성하라.
 * 여러 일정이 있는 경우 사전 어휘 순으로 방문한다.
 */
public class ReconstructItinerary {

	List<String> result;

	public List<String> findItinerary(List<List<String>> tickets) {
		result = new ArrayList<>();
		Map<String, List<String>> map = new HashMap<>();

		for (List<String> ticket : tickets) {
			if (!map.containsKey(ticket.get(0))) {
				map.put(ticket.get(0), new ArrayList<>());
			}
			map.get(ticket.get(0)).add(ticket.get(1));
		}

		for (Map.Entry<String, List<String>> entry : map.entrySet()) {
			Collections.sort(entry.getValue());
		}

		findItineraryFrom("JFK", map, new ArrayList<>(), tickets.size());
		result.add(0, "JFK");
		return result;
	}

	private void findItineraryFrom(String start, Map<String, List<String>> map, List<String> curRes, int numTickets) {
		if (curRes.size() == numTickets) {
			result.addAll(curRes);
			return;
		}

		if (map.get(start) == null) {
			return;
		}

		for (int i = 0; i < map.get(start).size(); i++) {
			String destination = map.get(start).get(i);
			map.get(start).remove(destination);
			curRes.add(destination);
			findItineraryFrom(destination, map, curRes, numTickets);

			if (result.size() > 0) {
				return;
			}

			map.get(start).add(i, destination);
			curRes.remove(curRes.size() - 1);
		}
	}
}
