class Solution {
    List<List<String>> ans = new ArrayList();
    private boolean isSafe(int[] pos, int row, int col) {
        int n = pos.length;
        boolean safe = true;
        for (int i = 0; i < row; i++) {
            safe = safe && pos[i] != col; // columns not conflicting
            safe = safe && pos[i] + (row - i) != col; // left diagonal not conflicting
            safe = safe && pos[i] + i != row + col; // left diagonal not conflicting
        }
        return safe;
    }
    private List<String> formQueen(int[] pos) {
        int n = pos.length;
        List<String> soln = new ArrayList();
        for (int i = 0; i < n; i++) {
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < n; j++) {
                if (pos[i] == j) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            soln.add(sb.toString());
        }
        return soln;
    }
    private void compute(int[] pos, int row) {
        int n = pos.length;
        if (row == n) {
            List<String> placement = formQueen(pos);
            ans.add(placement);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isSafe(pos, row, i)) {
                pos[row] = i;
                //print(pos);
                compute(pos, row + 1);
                pos[row] = -1;
            }
        }
    }
    private void print(int[] pos) {
        for (int i = 0; i < pos.length; i++) {
            System.out.print(pos[i] + " : ");
        }
        System.out.println();
    }
    public List<List<String>> solveNQueens(int n) {
        int pos[] = new int[n];
        for (int i = 0; i < n; i++) {
            pos[i] = -1;
        }
        for (int i = 0; i < n; i++) {
            pos[0] = i;
            compute(pos, 1);
            pos[0] = -1;
        }
        return ans;
    }
}
