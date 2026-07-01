class Solution {

    private static final int maxValue = 100000000;

    int dp[][];

    public int compute(int[] coins, int target, int pos){

        if(target == 0) {
            return 0;
        } else if(target < 0 || pos >= coins.length){
            return 100000000;
        }

        if(dp[pos][target] != -1){
            return dp[pos][target];
        }

        int taking = compute(coins, target-coins[pos], pos+1)+1;
        int repeating = compute(coins, target-coins[pos], pos)+1;
        int leaving = compute(coins, target, pos+1);
        dp[pos][target] = Math.min(taking, repeating);
        dp[pos][target] = Math.min(dp[pos][target], leaving);
        return dp[pos][target];
    }


    public int coinChange(int[] coins, int amount) {

        dp = new int[coins.length][amount+1];

        for(int i=0;i<dp.length;i++){
            for(int j=0;j<=amount;j++){
                dp[i][j] = -1;
            }
        }
        int min = compute(coins, amount, 0);
        return min >= maxValue ? -1 : min;
    }
}
