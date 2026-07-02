class Solution {
    int dp[][];
    private int compute(int[] prices, int pos, int canBuy) {
        if (pos >= prices.length) {
            return 0;
        }

        if (dp[pos][canBuy] != -1) {
            return dp[pos][canBuy];
        }

        int profit = compute(prices, pos + 1, canBuy);
        if (canBuy == 1) {
            profit = Math.max(compute(prices, pos + 1, 0) - prices[pos], profit);
        } else {
            profit = Math.max(compute(prices, pos + 2, 1) + prices[pos], profit);
        }

        dp[pos][canBuy] = profit;

        return profit;
    }
    public int maxProfit(int[] prices) {
        dp = new int[prices.length][2];
        for (int i = 0; i < prices.length; i++) {
            dp[i][0] = -1;
            dp[i][1] = -1;
        }
        return compute(prices, 0, 1);
    }
}
