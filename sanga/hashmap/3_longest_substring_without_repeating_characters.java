package src.sanga.hashmap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
class LongestSubstring {
    public static void main(String[] args) {
        LongestSubstring longestSubstring = new LongestSubstring();

        int result1 = longestSubstring.lengthOfLongestSubstring("abcabcbb"); // "abc" 3
        System.out.println(result1);

        int result2 = longestSubstring.lengthOfLongestSubstring2("pwwkew"); // "wke" 3
        System.out.println(result2);
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;

        // 입력값 S의 각 문자를 key, 가장 긴 부분 문자열을 결정할 key의 인덱스를 value로 저장
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }

    public int lengthOfLongestSubstring2(String s) {
        int i = 0, j = 0, max = 0;
        Set<Character> set = new HashSet<>();

        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(i++));
            }
        }

        return max;
    }


}