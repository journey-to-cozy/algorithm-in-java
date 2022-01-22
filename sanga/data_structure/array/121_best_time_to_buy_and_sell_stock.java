package src.sanga.data_structure.array;

/**
 * 한 번의 거래로 낼 수 있는 최대 이익을 산출하라
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
class BestTimeToTradeStock {

    public static void main(String[] args) {
        BestTimeToTradeStock bestTimeToTradeStock = new BestTimeToTradeStock();
        int result = bestTimeToTradeStock.maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println(result); // 1일 때 사서 6일 때 팔면 5의 이익을 얻는다.
    }

    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int maxProfit = 0; // 최댓값의 초기값은 시스템 최솟값 (여기서는 정수이므로 0)
        int minPrice = Integer.MAX_VALUE; // 최솟값의 초기값은 시스템 최댓값

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] > minPrice) {
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            } else {
                minPrice = prices[i];
            }
        }

        return maxProfit;
    }

    public int maxProfit2(int[] prices) {
        int min = Integer.MAX_VALUE, max = 0;
        for (int price : prices) {
            min = Math.min(min, price);
            max = Math.max(max, price - min);
        }
        return max;
    }

}