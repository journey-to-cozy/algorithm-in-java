package com.algorithm.stringManipulation;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/reorder-data-in-log-files/
 * 로그를 재정렬하라. 기준은 다음과 같다.
 * 1. 로그의 가장 앞 부분은 식별자다.
 * 2. 문자로 구성된 로그가 숫자 로그보다 앞에 온다.
 * 3. 식별자는 순서에 영향을 끼치지 않지만, 문자가 동일할 경우 식별자 순으로 한다.
 * 4. 숫자 로그는 입력 순서대로 한다.
 */
public class ReorderLogFiles {

	public String[] reorderLogFiles(String[] logs) {
		// 문자 로그와 숫자 로그를 구분
		List<String> letters = new ArrayList<>();
		List<String> digits = new ArrayList<>();

		for (String log : logs) {
			String[] split = log.split(" ", 2);
			if (Character.isDigit(split[1].charAt(0)))
				digits.add(log);
			else
				letters.add(log);
		}

		letters.sort((log1, log2) -> {
			String[] splitLog1 = log1.split(" ", 2);
			String[] splitLog2 = log2.split(" ", 2);

			if (splitLog1[1].equals(splitLog2[1])) {
				return splitLog1[0].compareTo(splitLog2[0]);
			} else {
				return splitLog1[1].compareTo(splitLog2[1]);
			}
		});

		letters.addAll(digits);

		return letters.toArray(new String[logs.length]);
	}
}
