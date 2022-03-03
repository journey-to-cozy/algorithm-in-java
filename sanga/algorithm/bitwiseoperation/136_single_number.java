package src.sanga.algorithm.bitwiseoperation;

/**
 * 딱 하나를 제외하고 모든 엘리먼트는 2개씩 있다. 1개인 엘리먼트를 찾아라.
 * https://leetcode.com/problems/single-number/
 */
class SingleNumber {

    public static void main(String[] args) {
        SingleNumber singleNumber = new SingleNumber();
        singleNumber.singleNumber(new int[]{4, 1, 2, 1, 2}); // 4
        singleNumber.singleNumber(new int[]{2, 2, 1}); // 1
        System.out.println(3^5);
    }

    // a^0 = a
    // a^a = 0
    // (a^b)^a = (a^a)^b = 0^b = b
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

}