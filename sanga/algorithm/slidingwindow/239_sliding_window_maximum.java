package src.sanga.algorithm.slidingwindow;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 배열 nums가 주어졌을 때 k 크기의 슬라이딩 윈도우를 오른쪽 끝까지 이동하면서 최대 슬라이딩 윈도우를 구하라.
 * https://leetcode.com/problems/sliding-window-maximum/
 */
class SlidingWindowMaximum {
    public static void main(String[] args) {
        SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();
        int[] result = slidingWindowMaximum.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3); // [3,3,5,5,6,7]
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if ( nums.length == 0 || k == 0) {
            return new int[0];
        }

        int[] result = new int[nums.length - k + 1]; // number of windows
        Deque<Integer> window = new ArrayDeque<>(); // stores indices

        for (int i = 0; i < nums.length; i++) {
            // remove indices that are out of range k
            while (!window.isEmpty() && window.peek() < i - k + 1) {
                window.poll();
            }
            // remove indices whose corresponding values are less than nums[i] in k range as they are uselss
            while (!window.isEmpty() && nums[window.peekLast()] < nums[i]) {
                window.pollLast();
            }
            // add nums[i]
            window.offerLast(i);
            // add to result
            if (i - k + 1 >= 0) {
                result[i - k + 1] = nums[window.peek()];
            }
        }
        return result;
    }

}