class Solution {
    int dp[][];
    private int count(int target, int n) {
        if(target == 0) {
            return 1;
        } else if (target < 0 || n*n > target) {
            return 50000;
        }
        if(dp[target][n] != -1) {
            return dp[target][n];
        }
        dp[target][n] = Math.min(count(target - n*n, n)+1, count(target, n+1));
        return dp[target][n];
    }
    public int numSquares(int n) {
        dp = new int[n+1][n+1];
        for(int i= 0 ; i <= n ; i++) {
            for(int j = 0 ; j <= n ; j++) {
                dp[i][j] = -1;
            }
        }
        return count(n, 1)-1;
    }
}