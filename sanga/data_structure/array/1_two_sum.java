package src.sanga.data_structure.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 덧셈하여 타겟을 만들 수 있는 배열의 두 숫자 인덱스를 리턴하라
 * https://leetcode.com/problems/two-sum/
 */
class TwoSum {

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        System.out.println(Arrays.toString(twoSum.twoSum(new int[]{2, 7, 11, 15}, 9))); // [0,1]
    }

    // 1. Brute-Force 방식 (배열을 두번 반복하면서 모든 조합을 더해 확인)
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[2];
    }


    // 2. 첫 번째 수를 뺀 결과 키 조회
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            Integer diff = target - nums[i];
            if (map.containsKey(diff)) {
                return new int[]{map.get(diff), i};
            }
            map.put(nums[i], i);
        }

        return new int[2];
    }

    // 3. 투 포인터 이용 -> 풀 수 없다.
    // 입력값인 nums 배열을 정렬해야 하는데, 결과값이 인덱스를 찾아내는 것이므로 잘못된 풀이이다.

}