package src.sanga.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 배열을 입력받아 합으로 0을 만들 수 있는 3개의 엘리먼트를 출력하라.
 * https://leetcode.com/problems/3sum/
 */
class ThreeSum {

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> lists = threeSum.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(lists); // [[-1, 0, 1], [-1, -1, 2]]
    }

    // 투 포인터로 합 계산
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // 중복된 값은 건너뛴다.
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // 간격을 좁혀가며 합을 계산한다.
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    // 합이 0이라면 결과배열에 값을 넣어주고 포인터 이동
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while (left < right && nums[left] == nums[left + 1]) left += 1;
                    while (left < right && nums[right] == nums[right - 1]) right -= 1;

                    left += 1;
                    right -= 1;
                } else if (sum > 0) {
                    right -= 1;
                } else {
                    left += 1;
                }
            }
        }

        return result;
    }

}