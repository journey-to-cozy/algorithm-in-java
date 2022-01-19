package com.algorithm.heap;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 * 정렬되지 않은 배열에서 k번째 큰 요소를 추출하라.
 */
public class KthLargestElementInAnArray {

	public int findKthLargest(int[] nums, int k) {
		Queue<Integer> heap = new PriorityQueue<>();

		for (int num : nums) {
			heap.offer(num);

			if (heap.size() > k) {
				heap.poll();
			}
		}
		return heap.peek();
	}
}
