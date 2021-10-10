package com.algorithm.stringManipulation;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/most-common-word/
 * 금지된 단어를 제외한 가장 흔하게 등장하는 단어를 출력하라.
 * 대소문자 구분을 하지 않으며, 구두점 또한 무시한다.
 */
public class MostCommonWord {
	public static void main(String[] args) {
		MostCommonWord solution = new MostCommonWord();

		String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
		String[] banned = { "hit" };

		System.out.println(solution.mostCommonWord(paragraph, banned));
	}

	public String mostCommonWord(String paragraph, String[] banned) {
		String[] words = paragraph.toLowerCase().split("[ !?',;.]+");

		Map<String, Integer> wordsMap = new HashMap<>();

		for (String word : words) {
			wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1);
		}

		for (String bannedWord : banned) {
			if (wordsMap.containsKey(bannedWord))
				wordsMap.remove(bannedWord);
		}

		String result = null;

		for (String word : wordsMap.keySet()) {
			if (result == null || wordsMap.get(word) > wordsMap.get(result))
				result = word;
		}

		return result;
	}
}
