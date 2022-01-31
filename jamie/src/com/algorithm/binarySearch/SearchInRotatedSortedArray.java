package com.algorithm.binarySearch;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array
 * 특정 피벗을 기준으로 회전하여 정렬된 배열에서 target 값의 인덱스를 출력하라.
 */
public class SearchInRotatedSortedArray {

	public int search(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return -1;

		// 최소값을 찾아 피벗 설정
		int left = 0;
		int right = nums.length - 1;

		while (left < right) {
			int mid = left + (right - left) / 2;

			if (nums[mid] > nums[right])
				left = mid + 1;
			else
				right = mid;
		}

		int pivot = left;

		// 피벗 기준 이진 검색
		left = 0;
		right = nums.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;
			int midPivot = (mid + pivot) % nums.length;

			if (nums[midPivot] < target)
				left = mid + 1;

			else if (nums[midPivot] > target)
				right = mid - 1;

			else
				return midPivot;
		}

		return -1;
	}
}
