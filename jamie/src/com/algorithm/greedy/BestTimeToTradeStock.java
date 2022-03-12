package com.algorithm.greedy;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 * 여러 번의 거래로 낼 수 있는 최대 이익을 산출하라.
 */
public class BestTimeToTradeStock {

    public int maxProfit(int[] prices) {

        int result = 0;

        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i]) {
                result += prices[i + 1] - prices[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {

        BestTimeToTradeStock solution = new BestTimeToTradeStock();
        int[] prices = {7, 1, 5, 3, 6, 4};

        System.out.println("solution.maxProfit(prices) = " + solution.maxProfit(prices));
    }
}
