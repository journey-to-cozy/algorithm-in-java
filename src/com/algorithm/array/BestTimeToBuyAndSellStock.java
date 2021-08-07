package com.algorithm.array;

// 주식을 사고팔기 가장 좋은 시점
// 한 번의 거래로 낼 수 있는 최대 이익을 산출하라
public class BestTimeToBuyAndSellStock {
	// 1) 브루트 포스 - timeout
	public int maxProfit(int[] prices) {
		int maxPrice = 0;

		for (int i = 0; i < prices.length; i++) {
			for (int j = i; j < prices.length; j++) {
				maxPrice = Math.max(prices[j] - prices[i], maxPrice);
			}
		}

		return maxPrice;
	}
	// 저점과 현재 값과의 차이 계산: 2ms
	public int maxProfit2(int[] prices) {
		int profit = 0;
		int minPrice = Integer.MAX_VALUE;

		// 최소값과 최대값을 계속 갱신
		for (int price : prices) {
			minPrice = Math.min(minPrice, price);
			profit = Math.max(profit, price - minPrice);
		}

		return profit;
	}

	public static void main(String[] args) {
		BestTimeToBuyAndSellStock solution = new BestTimeToBuyAndSellStock();

		int[] prices = {7, 1, 5, 3, 6, 4};

		System.out.println(solution.maxProfit2(prices));

	}
}
