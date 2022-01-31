package src.sanga.algorithm.binarysearch;

/**
 * 정렬된 배열을 받아 덧셈하여 타겟을 만들 수 있는 배열의 두 숫자 인덱스를 리턴하라.
 * 단, 이 문제에서 배열은 0이 아닌 1부터 시작하는 것으로 한다.
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 */
class TwoSumInputArrayIsSorted {

    public static void main(String[] args) {
        TwoSumInputArrayIsSorted twoSumInputArrayIsSorted = new TwoSumInputArrayIsSorted();
        twoSumInputArrayIsSorted.twoSum(new int[]{2, 7, 11, 15}, 9); // [1, 2]
    }

    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum < target) {
                left += 1;
            } else if (sum > target) {
                right -= 1;
            } else {
                break;
            }
        }
        return new int[]{left + 1, right + 1};
    }

}