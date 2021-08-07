package com.algorithm.array;

// 자신을 제외한 배열의 곱
// 배열을 입력받아 output[i]가 자신을 제외한 나머지 모든 요소의 곱셈 결과가 되도록 출력
// 주의: 나눗셈을 하지 않고 O(n)에 풀이할 것
public class ProductOfArrayExceptSelf {
	// 1ms
	public int[] productExceptSelf(int[] nums) {
		int[] result = new int[nums.length];
		for (int i = 0, j = 1; i < nums.length; i++) {
			result[i] = j;
			j *= nums[i];
		}

		for (int i = nums.length - 1, j = 1; i >= 0; i--) {
			result[i] *= j;
			j *= nums[i];
		}
		return result;
	}

	public static void main(String[] args) {
		ProductOfArrayExceptSelf solution = new ProductOfArrayExceptSelf();
		int[] nums = {1, 2, 3, 4};

		int[] result = solution.productExceptSelf(nums);

		for (int i : result) {
			System.out.println(i);
		}
	}
}
