package src.sanga;

import java.util.Arrays;

/**
 * n개의 페어를 이용한 min(a,b)의 합으로 만들 수 있는 가장 큰 수를 출력하라.
 * https://leetcode.com/problems/array-partition-i/
 */
class ArrayPartition {

    public static void main(String[] args) {
        ArrayPartition arrayPartition = new ArrayPartition();
        System.out.println(arrayPartition.arrayPairSum(new int[]{1, 4, 3, 2})); // 4
    }

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i < nums.length; i += 2) {
            result += nums[i];
        }

        return result;
    }


}