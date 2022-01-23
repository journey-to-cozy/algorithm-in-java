package com.algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/merge-intervals/
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
 * and return an array of the non-overlapping intervals that cover all the intervals in the input.
 */
public class MergeIntervals {

	public int[][] merge(int[][] intervals) {
		if (intervals.length <= 1) {
			return intervals;
		}

		Arrays.sort(intervals, (i, j) -> Integer.compare(i[0], j[0]));

		List<int[]> result = new ArrayList<>();
		int[] newIntervals = intervals[0];
		result.add(newIntervals);

		for (int[] interval : intervals) {
			if (newIntervals[1] >= interval[0])
				newIntervals[1] = Math.max(newIntervals[1], interval[1]);
			else {
				newIntervals = interval;
				result.add(newIntervals);
			}
		}

		return result.toArray(new int[result.size()][]);
	}

	public static void main(String[] args) {

		MergeIntervals solution = new MergeIntervals();

		int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
		System.out.println(Arrays.deepToString(solution.merge(intervals)));
	}
}
