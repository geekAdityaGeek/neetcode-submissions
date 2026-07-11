class Solution {
    private int dfs(int[][] grid, int x, int y, int color, int[][] visited) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[x].length || grid[x][y] == 0) {
            return 0;
        }
        if (visited[x][y] != 0) {
            return 0;
        }
        visited[x][y] = color;
        return 1 + dfs(grid, x - 1, y, color, visited) + dfs(grid, x + 1, y, color, visited)
            + dfs(grid, x, y - 1, color, visited) + dfs(grid, x, y + 1, color, visited);
    }
    public int maxAreaOfIsland(int[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];
        int color = 1;
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (visited[i][j] == 0 && grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfs(grid, i, j, color, visited));
                    color++;
                }
            }
        }
        return maxArea;
    }
}
