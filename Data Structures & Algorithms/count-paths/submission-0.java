class Solution {
    int dp[][];
    private int compute(int x, int y, int m, int n) {
        if (x == m - 1 && y == n - 1) {
            return 1;
        } else if (x >= m || y >= n) {
            return 0;
        }
        if (dp[x][y] != -1) {
            return dp[x][y];
        }
        int p1 = compute(x + 1, y, m, n);
        int p2 = compute(x, y + 1, m, n);
        dp[x][y] = p1 + p2;
        return p1 + p2;
    }
    public int uniquePaths(int m, int n) {
        dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        return compute(0, 0, m, n);
    }
}
