class Solution {
    private void compute(char[][] board, int x, int y, boolean[][] visited) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[x].length || board[x][y] == 'X') {
            return;
        }
        if (visited[x][y]) {
            return;
        }
        visited[x][y] = true;
        compute(board, x - 1, y, visited);
        compute(board, x + 1, y, visited);
        compute(board, x, y - 1, visited);
        compute(board, x, y + 1, visited);
    }
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean visited[][] = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            if (!visited[i][0] && board[i][0] == 'O') {
                compute(board, i, 0, visited);
            }
            if (!visited[i][n - 1] && board[i][n - 1] == 'O') {
                compute(board, i, n - 1, visited);
            }
        }

        for (int i = 0; i < n; i++) {
            if (!visited[0][i] && board[0][i] == 'O') {
                compute(board, 0, i, visited);
            }
            if (!visited[m - 1][i] && board[m - 1][i] == 'O') {
                compute(board, m - 1, i, visited);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
