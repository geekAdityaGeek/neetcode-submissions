class Solution {
    int[][] visited;
    private int compute(int M[][], int x, int y) {
        if (visited[x][y] != Integer.MIN_VALUE) {
            return visited[x][y];
        }

        int up = x - 1 >= 0 && M[x - 1][y] > M[x][y] ? compute(M, x - 1, y) : 0;
        int down = x + 1 < M.length && M[x + 1][y] > M[x][y] ? compute(M, x + 1, y) : 0;
        int left = y - 1 >= 0 && M[x][y - 1] > M[x][y] ? compute(M, x, y - 1) : 0;
        int right = y + 1 < M[x].length && M[x][y + 1] > M[x][y] ? compute(M, x, y + 1) : 0;

        int maxHori = Math.max(left, right);
        int maxVer = Math.max(up, down);
        visited[x][y] = Math.max(maxHori, maxVer) + 1;

        return visited[x][y];
    }
    public int longestIncreasingPath(int[][] matrix) {
        visited = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                visited[i][j] = Integer.MIN_VALUE;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                compute(matrix, i, j);
            }
        }

        int ans = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                ans = Math.max(ans, visited[i][j]);
            }
        }

        return ans;
    }
}
