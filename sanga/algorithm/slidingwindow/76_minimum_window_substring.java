package src.sanga.algorithm.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 문자열 S와 T를 입력받아 O(n)에 T의 모든 문자가 포함된 S의 최소 윈도우를 찾아라.
 * https://leetcode.com/problems/minimum-window-substring/
 */
class MinimumWindowSubstring {

    public static void main(String[] args) {
        MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();
        //String s1 = minimumWindowSubstring.minWindow("ADOBECODEBANC", "ABC");// "BANC"
        String s2 = minimumWindowSubstring.minWindow("azjskfzts", "sz");// "zjs"
    }

    public String minWindow(String searchString, String t) {
        // Creating Map for storing the frequency
        Map<Character, Integer> requirementMap = buildMappingOfCharactersToOccurrences(t);
        Map<Character, Integer> windowMap = new HashMap<>();

        int left = 0;
        int right = 0;

        int totalCharFrequenciesToMatch = requirementMap.size();
        int charFrequenciesInWindowThatMatch = 0;

        // This will store the minimum length of valid substring
        int minWindowSizeSeenSoFar = Integer.MAX_VALUE;

        // It will store the actual substring of minimum window
        String result = "";

        // Here we calculate the answer using 2 pointer's approach
        while (right < searchString.length()) {
            char rightChar = searchString.charAt(right);
            windowMap.put(rightChar, windowMap.getOrDefault(rightChar, 0) + 1);

            // right character is a requirement
            if (requirementMap.containsKey(rightChar)) {
                // requirement for character met
                if (requirementMap.get(rightChar).equals(windowMap.get(rightChar))) {
                    charFrequenciesInWindowThatMatch++;
                }
            }

            while (charFrequenciesInWindowThatMatch == totalCharFrequenciesToMatch && left <= right) {
                char leftChar = searchString.charAt(left);
                int windowSize = right - left + 1;

                // if window size is smaller than the size seen so far, update minimum window size and the result string
                if (windowSize < minWindowSizeSeenSoFar) {
                    minWindowSizeSeenSoFar = windowSize;
                    result = searchString.substring(left, right + 1);
                }

                windowMap.put(leftChar, windowMap.get(leftChar) - 1);

                // left character is a requirement
                if (requirementMap.containsKey(leftChar)) {
                    // character fails requirement
                    if (windowMap.get(leftChar) < requirementMap.get(leftChar)) {
                        charFrequenciesInWindowThatMatch--;
                    }
                }

                left++;
            }

            right++;
        }

        return result;
    }

    // Helper function for computing the character's frequency of a string
    private Map<Character, Integer> buildMappingOfCharactersToOccurrences(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        return map;
    }

}