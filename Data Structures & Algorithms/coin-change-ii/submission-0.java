class Solution {
    private int dp[][];
    private int compute(int[] coins, int pos, int amount) {
        if(pos >= coins.length || amount < 0) {
            return 0;
        }
        if(amount == 0) {
            return 1;
        }
        if(dp[pos][amount] != -1) {
            return dp[pos][amount];
        }
        dp[pos][amount] = compute(coins, pos, amount-coins[pos]) + compute(coins, pos+1, amount);
        return dp[pos][amount];
    }
    public int change(int amount, int[] coins) {
        dp = new int[coins.length][amount+1];
        for(int i=0;i<coins.length;i++) {
            for(int j=0;j<=amount;j++) {
                dp[i][j] = -1;
            }
        }
        return compute(coins, 0, amount);
    }
}
