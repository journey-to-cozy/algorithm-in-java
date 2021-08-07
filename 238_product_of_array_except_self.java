package src;

import java.util.Arrays;

/**
 * 배열을 입력받아 output[i]가 자신을 제외한 나머지 모든 요소의 곱셈 결과가 되도록 출력하라.
 * 단, 미리 전체 곱셈 값을 구해놓고 각 항목별로 자기 자신을 나누어서 풀이하면 안된다.
 * https://leetcode.com/problems/product-of-array-except-self/
 */
class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        ProductOfArrayExceptSelf productOfArrayExceptSelf = new ProductOfArrayExceptSelf();
        int[] result = productOfArrayExceptSelf.productExceptSelf(new int[]{1, 2, 3, 4});
        System.out.println(Arrays.toString(result)); // [24,12,8,6]
    }


    // 왼쪽 곱셈 결과에 오른쪽 값을 차례대로 곱셈
    public int[] productExceptSelf(int[] nums) {
        // 왼쪽부터 곱셈 결과
        // left[i] = nums[0] * .... * nums[i-1]  * nums[i]
        // i.e. nums = [1,2,3,4,5,6,7,8,9,10] 일 때, left =  [1,1,2,6,24,120,...]
        int[] left = new int[nums.length];
        left[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }


        // 오른쪽부터 곱셈한 결과
        // right[i] = nums[i] * nums[i+1]  * .... * nums[len(nums)]
        int[] right = new int[nums.length];
        right[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        int[] result = new int[nums.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = left[i] * right[i];
        }

        return result;
    }


}