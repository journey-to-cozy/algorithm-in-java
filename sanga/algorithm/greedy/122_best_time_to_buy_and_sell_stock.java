package src.sanga.algorithm.greedy;

/**
 * 여러 번의 거래로 낼 수 있는 최대 이익을 산출하라.
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock stock = new BestTimeToBuyAndSellStock();
        stock.maxProfit(new int[]{7, 1, 5, 3, 6, 4}); // (5-1) + (6-3) = 4
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int totalProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            // 다음날 값이 오르는 경우
            if (prices[i - 1] < prices[i]) {
                totalProfit += prices[i] - prices[i - 1];
            }
        }

        return totalProfit;
    }

    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int totalProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            totalProfit += Math.max(prices[i] - prices[i - 1], 0);
        }

        return totalProfit;
    }

}