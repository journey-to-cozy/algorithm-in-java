package com.algorithm.binarySearch;

/**
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 * 정렬된 배열을 받아 덧셈하여 타겟을 만들 수 있는 배열의 두 숫자 인덱스를 리턴하라.
 */
public class TwoSum2 {

	public static void main(String[] args) {
		TwoSum2 twoSumInputArrayIsSorted = new TwoSum2();
		twoSumInputArrayIsSorted.twoSum(new int[]{2, 7, 11, 15}, 9); // [1, 2]
	}

	// 현재 값을 기준으로 나머지 값이 맞는지 확인하는 형태의 이진 검색 풀이
	public int[] twoSum(int[] numbers, int target) {
		int start = 0;
		int end = numbers.length - 1;

		while (start + 1 < end) {
			int mid = start + (end - start) / 2;

			if (numbers[start] == (target - numbers[end]))
				return new int[]{start + 1, end + 1};

			else if (numbers[start] < (target - numbers[end]))
				start = (numbers[mid] < (target - numbers[end])) ? mid : start + 1;

			else
				end = (numbers[mid] > (target - numbers[start])) ? mid : end - 1;
		}

		return new int[]{-1, -1};
	}

	public int[] twoSum2(int[] numbers, int target) {
		int start = 0;
		int end = numbers.length - 1;

		while (start < end) {
			int mid = start + (end - start) / 2;
			int sum = numbers[start] + numbers[end];

			if (sum == target)
				return new int[]{start + 1, end + 1};

			else if (sum < target)
				start = (numbers[mid] < (target - numbers[end])) ? mid : start + 1;

			else
				end = (numbers[mid] > (target - numbers[start])) ? mid : end - 1;
		}

		return new int[]{-1, -1};
	}
}
