package src;


/**
 * 높이를 입력받아 비 온 후 얼마나 많은 물이 쌓일 수 있는지 계산
 * https://leetcode.com/problems/trapping-rain-water/
 */
class TrappingRainWater {

    public static void main(String[] args) {
        TrappingRainWater trappingRainWater = new TrappingRainWater();
        int result = trappingRainWater.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
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

}