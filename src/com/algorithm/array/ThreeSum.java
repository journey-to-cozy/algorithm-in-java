package com.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 배열을 입력받아 합으로 0을 만들 수 있는 3개의 엘리먼트 출력
public class ThreeSum {
	// brute force: 타임아웃으로 풀이 실패
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);

		// brute force n^3 반복
		for (int i = 0; i < nums.length - 2; i++) {
			// 중복된 값 건너뛰기
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			for (int j = i + 1; j < nums.length - 1; j++) {
				if (j > i + 1 && nums[j] == nums[j - 1]) {
					continue;
				}
				for (int k = j + 1; k < nums.length; k++) {
					if (k > j + 1 && nums[k] == nums[k - 1]) {
						continue;
					}
					if (nums[i] + nums[j] + nums[k] == 0) {
						List<Integer> list = new ArrayList<>();
						list.add(nums[i]);
						list.add(nums[j]);
						list.add(nums[k]);
						result.add(list);
					}
				}
			}
		}

		return result;
	}

	// O(n^2) 이내로 최적화: 17ms
	public List<List<Integer>> threeSumByTwoPointers(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 2; i++) {
			// 중복된 값 건너뛰기
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}

			// 간격을 좁혀가며 sum 계산
			int left = i + 1;
			int right = nums.length - 1;

			while (left < right) {
				int sum = nums[i] + nums[left] + nums[right];
				if (sum < 0) {
					left += 1;
				} else if (sum > 0) {
					right -= 1;
				} else {
					// sum = 0인 경우이므로 정답 및 스킵 처리
					List<Integer> list = new ArrayList<>();
					list.add(nums[i]);
					list.add(nums[left]);
					list.add(nums[right]);
					result.add(list);

					while (left < right && nums[left] == nums[left + 1])
						left += 1;
					while (left < right && nums[right] == nums[right - 1])
						right -= 1;
					left += 1;
					right -= 1;
				}
			}

		}

		return result;
	}

	public static void main(String[] args) {
		ThreeSum solution = new ThreeSum();

		int[] nums = {-1, 0, 1, 2, -1, -4};
		System.out.println(solution.threeSumByTwoPointers(nums));
	}
}
