package src.sanga;

import java.util.Stack;

/**
 * 중복된 문자를 제외하고 사전식 순서로 나열하라
 * https://leetcode.com/problems/remove-duplicate-letters/
 */
class RemoveDuplicateLetters {
    public static void main(String[] args) {
        RemoveDuplicateLetters removeDuplicateLetters = new RemoveDuplicateLetters();
        System.out.println(removeDuplicateLetters.removeDuplicateLetters("bcabc")); // // abc
        System.out.println(removeDuplicateLetters.removeDuplicateLetters("cbacdcbc")); // acdb
        System.out.println(removeDuplicateLetters.removeDuplicateLetters("ebcabc")); // eabc
    }

    public String removeDuplicateLetters(String s) {
        int[] res = new int[26];
        boolean[] visited = new boolean[26];
        char[] input = s.toCharArray();
        for (char c : input) {
            res[c - 'a']++;
        }

        Stack<Character> stack = new Stack<>();
        int index;
        for (char c : input) {
            index = c - 'a';
            res[index]--;
            if (visited[index])
                continue;
            while (!stack.isEmpty() && c < stack.peek() && res[stack.peek() - 'a'] != 0) {
                visited[stack.pop() - 'a'] = false;
            }
            stack.push(c);
            visited[index] = true;
        }

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }
}