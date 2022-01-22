package src.sanga.data_structure.heap;

import java.util.PriorityQueue;

/**
 * 정렬되지 않은 배열에서 k번째 큰 요소를 추출하라
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 */
class KthLargestElement {
    public static void main(String[] args) {
        KthLargestElement kthLargestElement = new KthLargestElement();
        kthLargestElement.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4); // 4
        kthLargestElement.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2); // 5
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> largeK = new PriorityQueue<>();
        for (int element : nums) {
            largeK.add(element);
            if (largeK.size() > k) {
                largeK.poll();
            }
        }

        return largeK.peek();
    }
}