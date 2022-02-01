package com.algorithm.binarySearch;

/**
 * https://leetcode.com/problems/binary-search/
 * 정렬된 nums를 입력받아 이진 검색으로 target에 해당하는 인덱스를 찾아라.
 */
public class BinarySearch {
	public int search(int[] nums, int target) {

		if (nums == null || nums.length == 0)
			return -1;

		int left = 0;
		int right = nums.length - 1;

		while (left <= right) {
			// overflow를 피하면서 정확한 mid 값을 구한다
			// 두 수를 더하고 그 합을 반으로 나누는 대신, 두 수의 뺄셈을 해서 그 차를 반으로 나눈 후 낮은 수에 더한다
			int mid = left + (right - left) / 2;

			if (nums[mid] == target)
				return mid;
			if (nums[mid] > target)
				right = mid - 1;
			else
				left = mid + 1;
		}

		return -1;
	}
}
