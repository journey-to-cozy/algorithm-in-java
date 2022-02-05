package src.sanga.algorithm.bitwiseoperation;

/**
 * 두 정수를 입력받아 몇 비트가 다른지 계산하라.
 * https://leetcode.com/problems/hamming-distance/
 */
class HammingDistance {

    public static void main(String[] args) {
        HammingDistance hammingDistance = new HammingDistance();
        hammingDistance.hammingDistance(1, 4); // 2
        hammingDistance.hammingDistance(1, 3); // 1
    }

    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    public int hammingDistance2(int x, int y) {
        int answer = 0;
        int result = x ^ y;
        while (result > 0) {
            if ((result & 1) == 1) answer++;
            result = result >> 1;
        }
        return answer;
    }

}