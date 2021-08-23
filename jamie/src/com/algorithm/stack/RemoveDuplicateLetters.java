package com.algorithm.stack;

import java.util.Stack;

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
		int[] letters = new int[26]; // 입력값 s에서 문자가 몇 번 나타나는지 저장함
		boolean[] visited = new boolean[26]; // 문자가 현재 스택에 있는지 여부를 저장함

		for (int i = 0; i < s.length(); i++) {
			letters[s.charAt(i) - 'a']++;
		}

		StringBuilder sb = new StringBuilder();

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

	// 코코 코드
	public String removeDuplicateLetters2(String s) {
		int[] res = new int[26]; // 입력값 s에서 문자가 몇 번 나타나는지 저장
		boolean[] visited = new boolean[26]; // 문자가 현재 스택에 있는지 여부를 저장
		char[] input = s.toCharArray();

		for (char c : input) {
			res[c - 'a']++;
		}

		Stack<Character> stack = new Stack<>();
		int index;
		for (char c : input) {
			index = c - 'a';
			res[index]--;

			if (visited[index]) // 문자가 현재 스택에 있다면 다음 반복문으로 넘어감
				continue;

			// 스택의 맨 마지막 문자(stack.peek())가 현재 탐색문자(c)보다 나중에 오는 문자고
			// 입력값의 다음에 또 나타나는 문자일 때
			// 스택에서 꺼내고 방문하지 않은 것으로 처리해서 추후 스택에 더해질 수 있도록 한다.
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
