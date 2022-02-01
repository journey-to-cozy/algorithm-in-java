package com.algorithm.binarySearch;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/intersection-of-two-arrays
 * 두 배열의 교집합을 구하라.
 */
public class IntersectionOfTwoArrays {

	// 한쪽은 순서대로 탐색하고 다른 쪽은 정렬해서 이진 검색
	public int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> set = new HashSet<>();
		Arrays.sort(nums2);

		for (Integer num : nums1) {
			if (binarySearch(nums2, num)) {
				set.add(num);
			}
		}

		int i = 0;
		int[] result = new int[set.size()];

		for (Integer num : set) {
			result[i++] = num;
		}

		return result;
	}

	private boolean binarySearch(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;

		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] == target)
				return true;

			if (nums[mid] > target)
				high = mid - 1;
			else
				low = mid + 1;
		}

		return false;
	}
}
