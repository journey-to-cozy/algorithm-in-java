package src.sanga.algorithm.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 평면상에 points 목록이 있을 때, 원점 (0, 0)에서 K번 가까운 점 목록을 순서대로 출력하라.
 * 평면상 두 점의 거리는 유클리드 거리로 한다.
 * https://leetcode.com/problems/k-closest-points-to-origin/
 */
class KClosetPointsToOrigin {

    public static void main(String[] args) {
        KClosetPointsToOrigin kClosetPointsToOrigin = new KClosetPointsToOrigin();
        kClosetPointsToOrigin.kClosest(new int[][]{{1, 3}, {-2, 2}}, 1); // [[-2, 2]]
        kClosetPointsToOrigin.kClosest(new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2); // [[-3, 3], [-2, 4]]
    }

    public int[][] kClosest(int[][] points, int k) {
        //Arrays.sort(points, (a, b) -> squaredDistance(a) - squaredDistance(b));
        Arrays.sort(points, Comparator.comparingInt(this::squaredDistance));

        return Arrays.copyOf(points, k);
    }

    public int[][] kClosest2(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> squaredDistance(p1) - squaredDistance(p2));

        for (int i = 0; i < points.length; i++) {
            pq.add(points[i]);
        }

        int[][] result = new int[k][2];

        for (int i = 0; i < k; i++) {
            result[i] = pq.poll();
        }

        return result;
    }

    private int squaredDistance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

}