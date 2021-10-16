package com.algorithm.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/palindrome-pairs/
 * 단어 리스트에서 words[i] + words[j]가 팰린드롬이 되는 모든 인덱스 조합(i, j)를 구하라.
 */
public class PalindromePairs {

	private static class TrieNode {
		TrieNode[] next;
		int index;
		List<Integer> list;

		TrieNode() {
			next = new TrieNode[26];
			index = -1;
			list = new ArrayList<>();
		}
	}

	public List<List<Integer>> palindromePairs(String[] words) {
		List<List<Integer>> result = new ArrayList<>();

		TrieNode root = new TrieNode();

		for (int i = 0; i < words.length; i++)
			addWord(root, words[i], i);

		for (int i = 0; i < words.length; i ++)
			search(words, i, root, result);

		return result;
	}

	private void addWord(TrieNode root, String word, int index) {
		for (int i = word.length() - 1; i >= 0; i--) {
			int j = word.charAt(i) - 'a';

			if (root.next[j] == null)
				root.next[j] = new TrieNode();

			if (isPalindrome(word, 0, i))
				root.list.add(index);

			root = root.next[j];
		}

		root.list.add(index);
		root.index = index;
	}

	private void search(String[] words, int i, TrieNode root, List<List<Integer>> result) {
		for (int j = 0; j < words[i].length(); j++) {
			if (root.index >= 0 && root.index != i && isPalindrome(words[i], j, words[i].length() - 1))
				result.add(Arrays.asList(i, root.index));

			root = root.next[words[i].charAt(j) - 'a'];

			if (root == null)
				return;
		}

		for (int j : root.list) {
			if (i == j)
				continue;
			result.add(Arrays.asList(i, j));
		}
	}

	private boolean isPalindrome(String word, int i, int j) {
		while (i < j) {
			if (word.charAt(i++) != word.charAt(j--))
				return false;
		}

		return true;
	}
}
