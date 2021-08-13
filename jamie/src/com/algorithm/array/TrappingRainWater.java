package com.algorithm.array;

// 높이를 입력받아 비 온 후 얼마나 많은 물이 쌓일 수 있는지 계산
public class TrappingRainWater {
	// two pointer, 1ms
	public int trap(int[] height) {
		int volume = 0;
		int left = 0;
		int right = height.length - 1;

		int leftMax = height[left];
		int rightMax = height[right];

		while (left < right) {
			leftMax = Math.max(height[left], leftMax);
			rightMax = Math.max(height[right], rightMax);
			// 더 높은 쪽을 향해 투 포인터 이동
			if (leftMax < rightMax) {
				volume += leftMax - height[left];
				left += 1;
			} else {
				volume += rightMax - height[right];
				right -= 1;
			}
		}

		return volume;
	}

	public int trapByTwoPointer(int[] height) {
		int volume = 0;
		int left = 0;
		int right = height.length - 1;

		int leftMax = height[left];
		int rightMax = height[right];

		while (left <= right) {
			if (leftMax <= rightMax) {
				leftMax = Math.max(height[left], leftMax);
				volume += leftMax - height[left];
				left += 1;
			} else {
				rightMax = Math.max(height[right], rightMax);
				volume += rightMax - height[right];
				right -= 1;
			}
		}

		return volume;
	}

	// 브루트 포스(코코 풀이)
	public int trapByCoco(int[] height) {
		int totalWater = 0;
		int left = 0;
		int right = 0;

		for (int i = 0; i < height.length; i++) {
			left = findTallest(0, i - 1, height);
			right = findTallest(i + 1, height.length - 1, height);

			int vol = Math.min(left, right) - height[i];
			if (vol >= 0) {
				totalWater += vol;
			}
		}

		return totalWater;
	}

	private int findTallest(int start, int end, int[] height) {
		int tallest = 0;

		for (int i = start; i <= end; i++) {
			if (tallest < height[i]) {
				tallest = height[i];
			}
		}

		return tallest;
	}

	public int trapByArray(int[] height) {
		int n = height.length;
		int[] leftMax = new int[n];
		int[] rightMax = new int[n];
		int water = 0;

		for (int i = 0; i < n; i++) {
			if (i == 0) {
				leftMax[0] = height[0];
				rightMax[n - 1] = height[n - 1];
			} else {
				leftMax[i] = Math.max(height[i], leftMax[i - 1]);
				rightMax[n - i - 1]  = Math.max(height[n - i - 1], rightMax[n - i]);
			}
		}

		for (int i = 0; i < n; i++) {
			water += Math.min(leftMax[i], rightMax[i]) - height[i];
		}

		return water;
	}

	public static void main(String[] args) {
		TrappingRainWater solution = new TrappingRainWater();
		int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

		System.out.println(solution.trap(height));
	}
}
