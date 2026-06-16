class Solution {
    private void traverseIsland(char[][] grid, int x, int y, boolean visited[][]) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[x].length || visited[x][y]
            || '0' == grid[x][y]) {
            return;
        }
        visited[x][y] = true;
        traverseIsland(grid, x - 1, y, visited);
        traverseIsland(grid, x + 1, y, visited);
        traverseIsland(grid, x, y + 1, visited);
        traverseIsland(grid, x, y - 1, visited);
    }
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean visited[][] = new boolean[m][n];

        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && '1' == grid[i][j]) {
                    traverseIsland(grid, i, j, visited);
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
