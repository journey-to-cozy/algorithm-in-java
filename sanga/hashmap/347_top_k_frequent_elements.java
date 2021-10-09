package src.sanga.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 * https://leetcode.com/problems/top-k-frequent-elements/
 */
class TopKFrequentElements {
    public static void main(String[] args) {
        TopKFrequentElements topKFrequentElements = new TopKFrequentElements();
        topKFrequentElements.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2); // [1,2]
        topKFrequentElements.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 3); // [1,2,3]
        int[] result = topKFrequentElements.topKFrequent(new int[]{1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 4, 4, 5, 5, 6, 7}, 4); // [1,2,3,5]
        for (int i : result) {
            System.out.println(i);
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        if (k == nums.length) return nums;

        Map<Integer, Integer> count = new HashMap();
        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        Queue<Integer> heap = new PriorityQueue<>((n1, n2) -> count.get(n1) - count.get(n2));

        for (int n : count.keySet()) {
            heap.add(n);
            if (heap.size() > k) heap.poll();
        }

        int[] top = new int[k];
        for (int i = k - 1; i >= 0; --i) {
            top[i] = heap.poll();
        }
        return top;
    }
}