package src.sanga.algorithm.binarysearch;

/**
 * 정렬된 nums를 입력받아 이진 검색으로 target에 해당하는 인덱스를 찾아라.
 * https://leetcode.com/problems/binary-search/
 */
class BinarySearch {

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int result = binarySearch.search(new int[]{-1, 0, 3, 5, 9, 12}, 9); // 4
    }

    public int search(int[] nums, int target) {
        int pivot, left = 0, right = nums.length - 1;

        while (left <= right) {
            pivot = left + (right - left) / 2;

            if (target == nums[pivot]) {
                return pivot;
            } else if (target > nums[pivot]) {
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }

        return -1;
    }


    public int search2(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    public int binarySearch(int[] nums, int left, int right, int target) {
        if (left <= right) {
            int pivot = left + (right - left) / 2;
            if (nums[pivot] == target) {
                return pivot;
            } else if (nums[pivot] > target) {
                return binarySearch(nums, 0, pivot - 1, target);
            } else {
                return binarySearch(nums, pivot + 1, right, target);
            }
        }
        return -1;
    }

}