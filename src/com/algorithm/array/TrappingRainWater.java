package com.algorithm.array;

// 높이를 입력받아 비 온 후 얼마나 많은 물이 쌓일 수 있는지 계산
public class TrappingRainWater {
	// two pointer, 1ms
	public int trap(int[] height) {
		if (height == null) {
			return 0;
		}

		int volume = 0;
		int left = 0;
		int right = height.length - 1;

		int leftMax = height[left];
		int rightMax = height[right];

		while (left < right) {
			leftMax = Math.max(height[left], leftMax);
			rightMax = Math.max(height[right], rightMax);
			// 더 높은 쪽을 향해 투 포인터 이동
			if (leftMax <= rightMax) {
				volume += leftMax - height[left];
				left += 1;
			} else {
				volume += rightMax - height[right];
				right -= 1;
			}
		}

		return volume;
	}

	public static void main(String[] args) {
		TrappingRainWater solution = new TrappingRainWater();
		int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

		System.out.println(solution.trap(height));
	}
}
