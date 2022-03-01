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

    // n의 첫째자리수와 1 AND 연산할 때 n이 1이라면 (n&1) 값이 1이 되므로 answer++가 되는 것이다.
    public int hammingWeight2(int n) {
        int answer = 0;
        while (n != 0) {
            answer += (n & 1);
            n = n >>> 1;
        }
        return answer;
    }

    // 1을 뺀 값과 AND 연산을 할 때마다 비트가 1씩 빠지게 된다.
    // 그렇다면 0이 될 때까지 이 작업을 반복하면 전체 비트에서 1의 개수가 몇 개인지 알 수 있다.
    public int hammingWeight3(int n) {
        int answer = 0;
        while (n != 0) {
            n = n & (n - 1);
            answer++;
        }
        return answer;
    }

}