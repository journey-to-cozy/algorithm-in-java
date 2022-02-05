package src.sanga.algorithm.bitwiseoperation;

/**
 * 두 정수 a와 b의 합을 구하라. +/- 연산자는 사용할 수 없다.
 * https://leetcode.com/problems/sum-of-two-integers/
 */
class SumOfTwoIntegers {

    public static void main(String[] args) {
        SumOfTwoIntegers sum = new SumOfTwoIntegers();
        sum.getSum(3, 5); // 8
        sum.getSum(-2, 4); // 2
    }

    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = (a & b);
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }
}