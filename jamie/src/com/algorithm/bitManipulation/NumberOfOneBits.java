package com.algorithm.bitManipulation;

/**
 * https://leetcode.com/problems/number-of-1-bits/
 * Write a function that takes an unsigned integer
 * and returns the number of '1' bits it has (also known as the Hamming weight).
 */
public class NumberOfOneBits {

    public static void main(String[] args) {

    }

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }

    public int hammingWeight2(int n) {
        int count = 0;

        while (n != 0) {
            // 1을 뺀 값과 AND 연산 횟수 측정
            n &= n - 1;
            count += 1;
        }

        return count;
    }
}
