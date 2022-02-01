package src.sanga.algorithm.binarysearch;

/**
 * 특정 피벗을 기준으로 회전하여 정렬된 배열에서 target 값의 인덱스를 출력하라.
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        SearchInRotatedSortedArray searchInRotatedSortedArray = new SearchInRotatedSortedArray();
        searchInRotatedSortedArray.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 1);// 5
        searchInRotatedSortedArray.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3); // -1
        searchInRotatedSortedArray.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 6); // 2
        searchInRotatedSortedArray.search(new int[]{1}, 0); // -1
    }

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (target == nums[middle]) {
                return middle;
            }

            if (nums[left] <= nums[middle]) {
                if (target > nums[middle] || target < nums[left]) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            } else {
                if (target < nums[middle] || target > nums[right]) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            }
        }

        return -1;
    }
}