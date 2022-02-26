package com.algorithm.bitManipulation;

/**
 * https://leetcode.com/problems/hamming-distance
 * 두 정수를 입력받아 몇 비트가 다른지 계산하라.
 */
public class HammingDistance {

	public int hammingDistance(int x, int y) {
		// 정수를 매개변수로 넣었을때 그 정수의 1의 개수를 반환한다
		return Integer.bitCount(x ^ y);
	}
}
