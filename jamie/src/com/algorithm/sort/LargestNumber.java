package com.algorithm.sort;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/largest-number/
 * 항목들을 조합하여 만들 수 있는 가장 큰 수를 출력하라.
 */
public class LargestNumber {

	public String largestNumber(int[] nums) {
		String result = Arrays.stream(nums)
				.mapToObj(String::valueOf)
				.sorted((a, b) -> (b + a).compareTo(a + b))
				.collect(Collectors.joining(""));

		return result.startsWith("00") ? "0" : result;
	}

	public static void main(String[] args) {

	}
}
