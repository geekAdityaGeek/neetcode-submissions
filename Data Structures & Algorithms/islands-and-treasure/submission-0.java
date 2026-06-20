class Solution {
    private int dfs(int[][] grid, int x, int y, boolean[][] visited) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[x].length || grid[x][y] == -1) {
            return Integer.MAX_VALUE;
        }
        if (grid[x][y] == 0) {
            return 0;
        }
        if (visited[x][y]) {
            return grid[x][y];
        }

        visited[x][y] = true;

        int up = dfs(grid, x - 1, y, visited);
        int down = dfs(grid, x + 1, y, visited);
        int left = dfs(grid, x, y - 1, visited);
        int right = dfs(grid, x, y + 1, visited);
        int horizontal = Math.min(left, right);
        int vertical = Math.min(up, down);
        int val = Math.min(horizontal, vertical);
        // System.out.println(x + " : " + y + " : " + up + " : " + down + " : " + left + " : " +
        // val);
        if (val != Integer.MAX_VALUE) {
            grid[x][y] = val + 1;
        }
        return grid[x][y];
    }
    public void islandsAndTreasure(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != -1 && grid[i][j] != 0) {
                    boolean[][] visited = new boolean[grid.length][grid[0].length];
                    dfs(grid, i, j, visited);
                }
            }
        }
    }
}
