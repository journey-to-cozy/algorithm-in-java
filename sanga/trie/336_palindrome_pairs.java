package src.sanga.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 단어 리스트에서 words[i] + words[k]가 팰린드롬이 되는 모든 인덱스 조합 (i, j)를 구하라
 * https://leetcode.com/problems/palindrome-pairs/
 */
class PalindromePairs {

    public static void main(String[] args) {
        PalindromePairs palindromePairs = new PalindromePairs();
        palindromePairs.palindromePairs(new String[]{"abcd", "dcba", "lls", "s", "sssll"}); // [0,1] [1,0] [3,2] [2,4]
        palindromePairs.palindromePairs(new String[]{"bat", "tab", "cat"}); // [0,1] [1,0]
        palindromePairs.palindromePairs(new String[]{"a", ""}); // [0,1] [1,0]
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();

        TrieNode2 root = new TrieNode2();
        for (int i = 0; i < words.length; i++) addWord(root, words[i], i);
        for (int i = 0; i < words.length; i++) search(words, i, root, res);

        return res;
    }

    private void addWord(TrieNode2 root, String word, int index) {
        for (int i = word.length() - 1; i >= 0; i--) {
            int j = word.charAt(i) - 'a';
            if (root.next[j] == null) root.next[j] = new TrieNode2();
            if (isPalindrome(word, 0, i)) root.list.add(index);
            root = root.next[j];
        }
        root.list.add(index);
        root.index = index;
    }

    private boolean isPalindrome(String word, int i, int j) {
        while (i < j) {
            if (word.charAt(i++) != word.charAt(j--)) return false;
        }
        return true;
    }

    private void search(String[] words, int i, TrieNode2 root, List<List<Integer>> res) {
        for (int j = 0; j < words[i].length(); j++) {
            if (root.index >= 0 && root.index != i && isPalindrome(words[i], j, words[i].length() - 1)) {
                res.add(Arrays.asList(i, root.index));
            }

            root = root.next[words[i].charAt(j) - 'a'];
            if (root == null) return;
        }

        for (int j : root.list) {
            if (i == j) continue;
            res.add(Arrays.asList(i, j));
        }
    }


    class TrieNode2 {
        TrieNode2[] next;
        int index;
        List<Integer> list;

        TrieNode2() {
            next = new TrieNode2[26];
            index = -1;
            list = new ArrayList<>();
        }
    }

}
