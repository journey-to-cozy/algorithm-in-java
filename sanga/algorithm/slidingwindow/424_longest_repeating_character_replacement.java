package src.sanga.algorithm.slidingwindow;

/**
 * 대문자로 구성된 문자열 s가 주어졌을 때 k번만큼의 변경으로 만들 수 있는, 연속으로 반복된 문자열의 가장 긴 길이를 출력하라.
 * https://leetcode.com/problems/longest-repeating-character-replacement/
 */
class LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement longestRepeatingCharacterReplacement = new LongestRepeatingCharacterReplacement();
        int result = longestRepeatingCharacterReplacement.characterReplacement("ABAB", 2); // 4
        longestRepeatingCharacterReplacement.characterReplacement("AABABBA",1); // 4
        longestRepeatingCharacterReplacement.characterReplacement("AAABBC",2); // 5
        longestRepeatingCharacterReplacement.characterReplacement("ABABBA",2); // 5
        int i = longestRepeatingCharacterReplacement.characterReplacement("ABCACBBBA", 2); // 5
        System.out.println(i);
    }

    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int start = 0, maxCount = 0, result = 0;

        // 반복문이 두 개 인데 하나는 end 즉 오른쪽 인덱스 하나씩 증가시키면서 window 크기 증가시키고
        // 중간의 while문은 k 초과시 왼쪽 포인터 증가시키면서 windowSize를 줄여줌
        for (int end = 0; end < s.length(); end++) {
            count[s.charAt(end) - 'A']++;
            maxCount = Math.max(maxCount, count[s.charAt(end) - 'A']);

            int windowSize = end - start +1;
            // k 초과시 왼쪽으로 포인터 이동한다.
            // windowsize - maxCount = k일 때, 더 이상 while문 조건을 만족하지 않으므로
            // 반복문 종료하고 k번만큼의 변경으로 만들 수 있는, 가장 긴 길이 만족하므로 result의 값을 업데이트 해준다.
            // maxCount는 그대로지만 windowSize만 줄어드는 것임
            // windowSize-maxCount >k 될때까지 이 반복문 실행 안됨.. 그냥 end 증가해서 windowSize만 커짐
            while (windowSize - maxCount > k) {
                count[s.charAt(start) - 'A']--;
                start++;
                windowSize--;
            }
            result = Math.max(result, windowSize);
        }

        return result;
    }

}