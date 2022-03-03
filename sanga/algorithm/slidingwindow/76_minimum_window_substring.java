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
        String s1 = minimumWindowSubstring.minWindow("ADOBECODEBANC", "ABC"); // "BANC"
        String s2 = minimumWindowSubstring.minWindow("AZBSDFZES", "SZ"); // "zbs"
    }

    public String minWindow(String searchString, String t) {
        // Creating Map for storing the frequency
        // t mapping해서 requirementMap에 searchString은 while문에서 right 포인터 이동해 가며 탐색한다
        Map<Character, Integer> requirementMap = buildMappingOfCharactersToOccurrences(t);
        Map<Character, Integer> windowMap = new HashMap<>();

        int left = 0;
        int right = 0;

        // t의 문자열 수, 얘는 조건문 확인하기 위한 상수. 고정 값.
        // totla character frequencies to match
        int mapSize = requirementMap.size();
        // window에 t에 포함된 문자열 수 몇 번 나타나는가. 반복문 돌면서 증가됨
        // character frequencies in window that match
        int matchCountInWindow = 0;

        // This will store the minimum length of valid substring
        // 문제 조건이 최소 윈도우
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
                    matchCountInWindow++; // right = 1일 때, 3일 때 만족함
                }
            }

            // 이 조건문이 종료되는 경우는 matchCountInwindow가 감소되거나, left가 right와 같게 되었을 때
            while (matchCountInWindow == mapSize && left <= right) {
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
                        matchCountInWindow--;
                    }
                }

                left++;
            }

            // 처음 right0일 때는 위에 다 건너뛰고 증가.
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