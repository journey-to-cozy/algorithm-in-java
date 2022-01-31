package src.sanga.algorithm.sort;

/**
 * 빨간색을 0, 흰색을 1, 파란색을 2라 할 때 순서대로 인접하는 제자리 정렬을 수행하라.
 * https://leetcode.com/problems/sort-colors/
 */
class SortColors {

    public static void main(String[] args) {
        SortColors sortColors = new SortColors();
        sortColors.sortColors(new int[]{2, 0, 2, 1, 1, 0}); // [0, 0, 1, 1, 2, 2]
        sortColors.sortColors(new int[]{0, 1, 2, 1, 0, 2}); // [0, 0, 1, 1, 2, 2]
    }


    public void sortColors(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int i = 0;

        while (i <= end) {
            if (nums[i] == 0) {
                swap(nums, start, i);
                start++;
                i++;
            } else if (nums[i] == 2) {
                swap(nums, end, i);
                end--;
                // edge 케이스가 있기 때문에 i 포인터를 증가시키지 않는다.
            } else {
                i++;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}