package com.algorithm.hashmap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/top-k-frequent-elements
 * 상위 k번 이상 등장하는 요소를 추출하라.
 * input) nums = [1, 1, 1, 2, 2, 3], k = 2
 * output) [1, 2]
 */
public class TopKFrequentElements {
	public static void main(String[] args) {
		TopKFrequentElements solution = new TopKFrequentElements();
		int[] nums = {1, 1, 1, 2, 2, 3};
		int k = 2;

		int[] result = solution.topKFrequent(nums, k);

		for (int i : result) {
			System.out.println(i);
		}
	}

	public int[] topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));

		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		}

		int count = 0;
		for (int num : map.keySet()) {
			if (count < k) {
				count++;
				minHeap.add(num);
			} else if (map.get(minHeap.peek()) < map.get(num)) {
				minHeap.poll();
				minHeap.add(num);
			}
		}

		int[] result = new int[k];
		for (int num : minHeap) {
			result[k - 1] = num;
			k--;
		}

		return result;
	}
}