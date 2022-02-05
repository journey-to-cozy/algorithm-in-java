package src.sanga.algorithm.bitwiseoperation;

/**
 * 부호없는 정수형(Unsinged Integer) 을 입력받아 1비트의 개수를 출력하라
 * https://leetcode.com/problems/number-of-1-bits/
 *
 * 참고 https://coding-factory.tistory.com/521
 * https://developer.mozilla.org/ko/docs/Web/JavaScript/Reference/Operators/Bitwise_AND
 */
class NumberOfOneBits {

    public static void main(String[] args) {
        NumberOfOneBits numberOfOneBits = new NumberOfOneBits();
        numberOfOneBits.hammingWeight2(0b00000000000000000000000000001011); // 3
        numberOfOneBits.hammingWeight2(0b00000000000000000000000010000000); // 1
    }

    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }

    public int hammingWeight2(int n) {
        int answer = 0;
        while (n != 0) {
            answer += (n & 1);
            n = n >>> 1;
        }
        return answer;
    }

    public int hammingWeight3(int n) {
        int answer = 0;
        while (n != 0) {
            n = n & (n - 1);
            answer++;
        }
        return answer;
    }

}