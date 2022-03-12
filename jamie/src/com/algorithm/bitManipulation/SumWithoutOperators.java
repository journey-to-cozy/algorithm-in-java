package com.algorithm.bitManipulation;

/**
 * https://leetcode.com/problems/sum-of-two-integers/
 * Given two integers a and b, return the sum of the two integers without using the operators + and -.
 */
public class SumWithoutOperators {

    public static void main(String[] args) {

        SumWithoutOperators solution = new SumWithoutOperators();
        System.out.println("solution.getSum(2, 3) = " + solution.getSum(2, 3));
    }

    public int getSum(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;

        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }

        return a;
    }
}
