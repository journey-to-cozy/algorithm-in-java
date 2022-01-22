package src.sanga.algorithm.sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 항목들을 조합하여 만들 수 있는 가장 큰 수를 출력하라.
 * https://leetcode.com/problems/largest-number/
 */
class LargestNumber {

    public static void main(String[] args) {
        LargestNumber largestNumber = new LargestNumber();
        String result1 = largestNumber.largestNumber(new int[]{10, 2}); // 210
        String result2 = largestNumber.largestNumber(new int[]{3, 30, 34, 5, 9}); // 9534303
        String result3 = largestNumber.largestNumber(new int[]{0, 0}); // 0
        String result4 = largestNumber.largestNumber(new int[]{10, 2}); // 210
    }

    private String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }

        StringBuilder result = new StringBuilder();

        String[] numArray = new String[nums.length];
        for (int i = 0; i < numArray.length; i++) {
            numArray[i] = Integer.toString(nums[i]);
        }

        Arrays.sort(numArray, new StringComparator());

        for (String s : numArray) {
            result.append(s);
        }

        if (result.length() > 0 && result.charAt(0) == '0'){
            return "0";
        }

        return result.toString();
    }

    private class StringComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return (o2 + o1).compareTo(o1 + o2);
        }
    }

}

