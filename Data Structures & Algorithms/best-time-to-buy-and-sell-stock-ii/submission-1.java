class Solution {
    public int maxProfit(int[] prices) {
        int i = 1;
        int profit = 0;
        while(i < prices.length) {
            if(prices[i] >= prices[i-1]) {
                profit = profit + prices[i] - prices[i-1];
            } 
            i++;
        }
        return profit;
    }
}