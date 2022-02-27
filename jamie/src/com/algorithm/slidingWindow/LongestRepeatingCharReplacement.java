package com.algorithm.slidingWindow;

/**
 * https://leetcode.com/problems/longest-repeating-character-replacement/
 * 대문자로 구성된 문자열 s가 주어졌을 때 k번만큼의 변경으로 만들 수 있는, 연속으로 반복된 문자열의 가장 긴 길이를 출력하라.
 */
public class LongestRepeatingCharReplacement {

    public static void main(String[] args) {
        LongestRepeatingCharReplacement solution = new LongestRepeatingCharReplacement();

        System.out.println("solution.characterReplacement(\"AAABBC\", 2) = " + solution.characterReplacement("AAABBC", 2));
    }

    public int characterReplacement(String s, int k) {
        int len = s.length();
        int[] count = new int[26];
        int start = 0, maxCount = 0, maxLength = 0;

        for (int end = 0; end < len; end++) {
            maxCount = Math.max(maxCount, ++count[s.charAt(end) - 'A']);

            while (end - start + 1 - maxCount > k) {
                count[s.charAt(start) - 'A']--;
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }
}
