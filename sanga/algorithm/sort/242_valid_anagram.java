package src.sanga.algorithm.sort;

import java.util.Arrays;

/**
 * t가 s의 애너그램인지 판별하라
 * https://leetcode.com/problems/valid-anagram/
 */
class ValidAnagram {

    public static void main(String[] args) {
        ValidAnagram validAnagram = new ValidAnagram();
        boolean result1 = validAnagram.isAnagram("anagram", "nagaram"); // true
        boolean result2 = validAnagram.isAnagram("rat", "car"); // false
    }

    private boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] charFrequency = new int['z' - 'a' + 1];

        for (int i = 0; i < s.length(); i++) {
            charFrequency[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            if (charFrequency[t.charAt(i) - 'a']-- == 0) {
                return false;
            }
        }

        return true;
    }

    private boolean isAnagramBySort(String s, String t) {
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        Arrays.sort(sChar);
        Arrays.sort(tChar);

        String sString = new String(sChar);
        String tString = new String(tChar);

        return sString.equals(tString);
    }

}