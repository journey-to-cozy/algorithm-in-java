package src.sanga.algorithm.slidingwindow;

/**
 * 대문자로 구성된 문자열 s가 주어졌을 때 k번만큼의 변경으로 만들 수 있는, 연속으로 반복된 문자열의 가장 긴 길이를 출력하라.
 * https://leetcode.com/problems/longest-repeating-character-replacement/
 */
class LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement longestRepeatingCharacterReplacement = new LongestRepeatingCharacterReplacement();
        int result = longestRepeatingCharacterReplacement.characterReplacement("ABAB", 2);// 4
        longestRepeatingCharacterReplacement.characterReplacement("AABABBA",1); // 4
        longestRepeatingCharacterReplacement.characterReplacement("AAABBC",2); // 5
        longestRepeatingCharacterReplacement.characterReplacement("ABABBA",2); // 5
    }

    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int start = 0, maxCount = 0, result = 0;

        for (int end = 0; end < s.length(); end++) {
            count[s.charAt(end) - 'A']++;
            maxCount = Math.max(maxCount, count[s.charAt(end) - 'A']);
            int windowSize = end - start +1;
            while (windowSize - maxCount > k) {
                count[s.charAt(start) - 'A']--;
                start++;
                windowSize--;
            }
            result = Math.max(result, windowSize);
        }

        return result;
    }

}