package src.sanga.algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 겹치는 구간을 병합하라.
 * https://leetcode.com/problems/merge-intervals/
 */
class MergeIntervals {

    public static void main(String[] args) {
        MergeIntervals mergeIntervals = new MergeIntervals();
        int[][] merge1 = mergeIntervals.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}}); // [[1,6],[8,10],[15,18]]
        int[][] merge2 = mergeIntervals.merge(new int[][]{{1, 4}, {4, 5}}); // [[1,5]]
    }

    private int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        Arrays.sort(intervals, (a, b) -> (a[0] - b[0])); // 시작값에 따라 intervals 를 정렬

        // 만약, 이전 interval의 끝값이 현재 interval의 시작값보다 크다면, overlap이 있는 것이다.
        List<int[]> result = new ArrayList<>();
        for (int[] interval : intervals) {
            // list가 비었거나 overlap이 없다면 현재 interval을 더해준다.
            if (result.isEmpty() || result.get(result.size() - 1)[1] < interval[0]) {
                result.add(interval);
            } else {
                // overlap이 존재한다면 현재 interval을 이전 interval에 병합해준다.
                result.get(result.size() - 1)[1] = Math.max(result.get(result.size() - 1)[1], interval[1]);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}