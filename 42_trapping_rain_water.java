package src;


import java.util.Stack;

/**
 * 높이를 입력받아 비 온 후 얼마나 많은 물이 쌓일 수 있는지 계산
 * https://leetcode.com/problems/trapping-rain-water/
 */
class TrappingRainWater {

    public static void main(String[] args) {
        TrappingRainWater trappingRainWater = new TrappingRainWater();
        //int result = trappingRainWater.trap2(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        int result = trappingRainWater.trap2(new int[]{4, 2, 0, 3, 2, 5});
        System.out.println(result); // 6
    }


    // Brute-force 풀이법 O(n^2)
    public int trap(int[] height) {
        int totalWater = 0;
        int left = 0, right = 0;

        for (int i = 0; i < height.length; i++) {
            left = findTallest(0, i - 1, height);
            right = findTallest(i + 1, height.length - 1, height);
            int vol = Math.min(left, right) - height[i];
            if (vol >= 0) {
                totalWater += vol;
            }
        }

        return totalWater;
    }

    private int findTallest(int start, int end, int[] height) {
        int tallest = 0;
        for (int i = start; i <= end; i++) {
            if (tallest < height[i]) {
                tallest = height[i];
            }
        }
        return tallest;
    }

    public int trap2(int[] height) {
        Stack<Integer> st = new Stack<>();
        int curr = 0, volume = 0;
        while (curr < height.length) {
            // 현재 포인터의 높이가 이전 높이보다 높을 때, 즉 변곡점일 때
            while (!st.isEmpty() && height[curr] > height[st.peek()]) {
                int top = st.pop();  // 스택에서 꺼낸다.
                if (st.isEmpty()) break;
                int distance = curr - st.peek() - 1; // 이전과의 차이만큼의 가로 높이
                int water = Math.min(height[curr], height[st.peek()]) - height[top]; // 최소높이만큼 물이 채워질 수 있다.
                volume += distance * water;
            }
            st.push(curr++);
        }
        return volume;
    }


}