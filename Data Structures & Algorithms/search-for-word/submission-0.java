class Solution {
    private boolean compute(
        char[][] board, String word, int pos, int x, int y, boolean[][] visited) {
        if (pos == word.length()) {
            return true;
        }
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || visited[x][y]
            || word.charAt(pos) != board[x][y]) {
            return false;
        }
        visited[x][y] = true;
        boolean up = compute(board, word, pos + 1, x - 1, y, visited);
        boolean down = compute(board, word, pos + 1, x + 1, y, visited);
        boolean right = compute(board, word, pos + 1, x, y + 1, visited);
        boolean left = compute(board, word, pos + 1, x, y - 1, visited);
        visited[x][y] = false;
        return up || down || left || right;
    }
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean visited[][] = new boolean[board.length][board[0].length];
                    boolean ans = compute(board, word, 0, i, j, visited);
                    if (ans) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
