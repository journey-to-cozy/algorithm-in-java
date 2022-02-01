package com.algorithm.sort;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/k-closest-points-to-origin
 *
 */
public class KClosestPointsToOrigin {

	public int[][] kClosest(int[][] points, int k) {
		int len = points.length;
		int left = 0;
		int right = len - 1;

		while (left <= right) {
			int mid = helper(points, left, right);

			if (mid == k)
				break;

			if (mid < k)
				left = mid + 1;
			else
				right = mid - 1;
		}

		return Arrays.copyOfRange(points, 0, k);
	}

	private int helper(int[][] a, int left, int right) {
		int[] pivot = a[left];

		while (left < right) {
			while (left < right && compare(a[right], pivot) >= 0)
				right--;
			a[left] = a[right];

			while (left < right && compare(a[left], pivot) <= 0)
				left++;
			a[right] = a[left];
		}

		a[left] = pivot;

		return left;
	}

	private int compare(int[] p1, int[] p2) {
		return p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1];
	}

	public int[][] kClosest2(int[][] points, int k) {
		PriorityQueue<int[]> pq = new PriorityQueue<>(
				(p1, p2) -> p2[0] * p2[0] + p2[1] * p2[1] - p1[0] * p1[0] - p1[1] * p1[1]);

		for (int[] p : points) {
			pq.offer(p);
			if (pq.size() > k) {
				pq.poll();
			}
		}

		int[][] result = new int[k][2];
		while (k > 0)
			result[--k] = pq.poll();

		return result;
	}

	private int squaredDistance(int[] point) {
		return point[0] * point[0] + point[1] * point[1];
	}
}
