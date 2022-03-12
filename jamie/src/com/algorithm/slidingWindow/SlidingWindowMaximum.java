package com.algorithm.slidingWindow;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.com/problems/sliding-window-maximum/
 * 배열 nums가 주어졌을 때, k 크기의 슬라이딩 윈도우를 오른쪽 끝까지 이동하면서 최대 슬라이딩 윈도우를 구하라.
 */
public class SlidingWindowMaximum {

    public static void main(String[] args) {
        SlidingWindowMaximum solution = new SlidingWindowMaximum();
        int[] result = solution.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);// [3,3,5,5,6,7]

        for (int i : result) {
            System.out.println("i = " + i);
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0)
            return new int[0];

        int[] result = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();

        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            // Ensure deque's size doesn't exceed k
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }

            // remove numbers smaller then nums[i] from right(a[i-1]) to left,
            // to make the first number in the deque the largest one in the window
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // add nums[i]
            deque.offer(i);

            // starts recording when i is big enough to make the window has k elements
            if (i >= k - 1) {
                result[index++] = nums[deque.peek()];
            }
        }
        return result;
    }
}
