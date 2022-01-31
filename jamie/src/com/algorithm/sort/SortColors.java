package com.algorithm.sort;

/**
 * https://leetcode.com/problems/sort-colors/
 * 빨간색을 0, 흰색을 1, 파란색을 2라 할 때 순서대로 인접하는 제자리 정렬을 수행하라.
 * https://www.educative.io/edpresso/the-dutch-national-flag-problem-in-cpp
 */
public class SortColors {

	public void sortColors(int[] nums) {
		int red = 0;
		int white = 0;
		int blue = nums.length;

		while (white < blue) {
			if (nums[white] < 1) {
				int temp = nums[white];
				nums[white] = nums[red];
				nums[red] = temp;
				white++;
				red++;
			} else if (nums[white] > 1) {
				blue--;
				int temp = nums[white];
				nums[white] = nums[blue];
				nums[blue] = temp;
			} else {
				white++;
			}
		}
	}

	public static void main(String[] args) {

		SortColors solution = new SortColors();
		int[] nums = {2, 0, 2, 1, 1, 0};
		solution.sortColors(nums);

		for (int i : nums) {
			System.out.println(i);
		}
	}
}
