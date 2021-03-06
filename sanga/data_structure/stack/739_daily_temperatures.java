package src.sanga.data_structure.stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 매일의 화씨 온도 리스트 T를 입력받아서, 더 따뜻한 날씨를 위해서는 며칠을 더 기다려야 하는치를 출력하라
 * https://leetcode.com/problems/daily-temperatures/
 */
class DailyTemperatures {
    public static void main(String[] args) {
        DailyTemperatures dailyTemperatures = new DailyTemperatures();
        int[] input = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(dailyTemperatures.dailyTemperatures(input))); // [1, 1, 4, 2, 1, 1, 0, 0]
    }

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int idx = stack.pop();
                result[idx] = i - idx;
            }
            stack.push(i);
        }

        return result;
    }

    public int[] dailyTemperatures2(int[] temperatures) {
        final int length = temperatures.length;
        final Map<Integer, Integer> next = new HashMap<>();
        final Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < length; i++) {
            while (!stack.empty() && temperatures[stack.peek()] < temperatures[i]) {
                next.put(stack.peek(), i - stack.pop());
            }

            stack.push(i);
        }

        final int[] answer = new int[length];
        for (int i = 0; i < length; i++) {
            answer[i] = next.getOrDefault(i, 0);
        }

        return answer;
    }

}