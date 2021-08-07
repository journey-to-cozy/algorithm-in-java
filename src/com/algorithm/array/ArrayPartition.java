package com.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// n개의 페어를 이용한 min(a, b)의 합으로 만들 수 있는 가장 큰 수를 출력하라.
public class ArrayPartition {
	// 1) 오름차순 풀이 - 16ms
	public int arrayPairSum(int[] nums) {
		int sum = 0;
		Arrays.sort(nums);
		List<Integer> pair = new ArrayList<>();

		for (int num : nums) {
			// 앞에서부터 오름차순으로 페어를 만들어 합 계산
			pair.add(num);
			if (pair.size() == 2) {
				sum += Math.min(pair.get(0), pair.get(1));
				pair.clear();
			}
		}

		return sum;
	}

	// 2) 짝수번째 값 계산 - 11ms
	// 정렬된 상태에서는 짝수 번째에 항상 작은 값이 위치하기 때문
	public int arrayPairSumByEven(int[] nums) {
		int sum = 0;
		Arrays.sort(nums);

		for (int i = 0; i < nums.length; i++) {
			if (i % 2 == 0) {
				sum += nums[i];
			}
		}

		return sum;
	}

	public static void main(String[] args) {
		ArrayPartition solution = new ArrayPartition();
		int[] nums = {1, 4, 3, 2};

		System.out.println(solution.arrayPairSumByEven(nums));
	}
}
