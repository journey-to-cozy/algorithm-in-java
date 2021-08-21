package com.algorithm.stack;

/**
 * 중복된 문자를 제외하고 사전식 순서(Lexicographical Order)로 나열하라.
 */
public class RemoveDuplicateLetters {
	public static void main(String[] args) {
		RemoveDuplicateLetters solution = new RemoveDuplicateLetters();
		String s = "bcabc";
		System.out.println(solution.removeDuplicateLetters(s));
	}

	public String removeDuplicateLetters(String s) {
		int[] letters = new int[26];
		for (int i = 0; i < s.length(); i++) {
			letters[s.charAt(i) - 'a'] ++;
		}

		StringBuilder sb = new StringBuilder();
		boolean[] visited = new boolean[26];

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int cKey = c - 'a', sbLength = sb.length();

			if (!visited[cKey]) {
				while (sbLength > 0) {
					char last = sb.charAt(sbLength - 1);
					int lastKey = last - 'a';
					if (last > c && letters[lastKey] > 0) {
						visited[lastKey] = false;
						sb.deleteCharAt(--sbLength);
					} else {
						break;
					}
				}
				visited[cKey] = true;
				sb.append(c);
			}

			letters[cKey]--;
		}
		return sb.toString();
	}
}
