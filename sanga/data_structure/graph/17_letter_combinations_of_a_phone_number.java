package src.sanga.data_structure.graph;

import java.util.*;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
class LetterCombinations {

    private String[] keypad = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static void main(String[] args) {
        LetterCombinations letterCombinations = new LetterCombinations();
        List<String> list = letterCombinations.letterCombinations("23");
        for (String s : list) {
            System.out.println(s);
        }
    }

    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()) return new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        List<String> res = new ArrayList<>();
        dfs(sb, 0, digits, res);

        return res;
    }

    private void dfs(StringBuilder sb, int index, String digits, List<String> res) {
        if (index == digits.length()) {
            res.add(sb.toString());
            return;
        }

        String options = keypad[digits.charAt(index) - '0'];
        for (char option : options.toCharArray()) {
            sb.append(option);
            dfs(sb, index + 1, digits, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}