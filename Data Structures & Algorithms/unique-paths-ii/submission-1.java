class Solution {
    int dp[][];
    private int compute(int [][] grid, int x, int y) {
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[x].length || grid[x][y] == 1) {
            return 0;
        }
        if(x == grid.length-1 && y==grid[x].length-1) {
            return 1;
        }
        if(dp[x][y] != -1) {
            return dp[x][y];
        }
        dp[x][y] = compute(grid, x, y+1) + compute(grid, x+1, y);
        return dp[x][y];
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int i = 0 ; i < obstacleGrid.length ; i++) {
            for(int j = 0 ; j < obstacleGrid[i].length ; j++) {
                dp[i][j] = -1;
            }
        }
        return compute(obstacleGrid, 0, 0);
    }
}