class Solution {
    private void processRotten(int[][] grid, int[][] time, int x, int y, int t, Queue<int[]> Q) {
        if (grid[x][y] == 1) {
            grid[x][y] = 2;
            time[x][y] = Math.min(time[x][y], t + 1);
            Q.add(new int[] {x, y, t + 1});
        }
    }

    private void print(int[][] M) {
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                System.out.print(M[i][j] + ":");
            }
            System.out.println();
        }
    }

    public int orangesRotting(int[][] grid) {
        Queue<int[]> Q = new LinkedList<int[]>();

        int time[][] = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                time[i][j] = Integer.MAX_VALUE;
                if (grid[i][j] == 2) {
                    time[i][j] = 0;
                    Q.add(new int[] {i, j, 0});
                }
            }
        }

        while (!Q.isEmpty()) {
            int[] curr = Q.remove();
            if (curr[0] - 1 >= 0) {
                processRotten(grid, time, curr[0] - 1, curr[1], curr[2], Q);
            }
            if (curr[0] + 1 < grid.length) {
                processRotten(grid, time, curr[0] + 1, curr[1], curr[2], Q);
            }
            if (curr[1] - 1 >= 0) {
                processRotten(grid, time, curr[0], curr[1] - 1, curr[2], Q);
            }
            if (curr[1] + 1 < grid[curr[0]].length) {
                processRotten(grid, time, curr[0], curr[1] + 1, curr[2], Q);
            }
            // System.out.println("GRID --> ");
            // print(grid);
            // System.out.println("TIME --> ");
            // print(time);
            // System.out.println();
            
        }

        int maxTime = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
                if (grid[i][j] == 2) {
                    maxTime = Math.max(maxTime, time[i][j]);
                }
            }
        }

        return maxTime;
    }
}
