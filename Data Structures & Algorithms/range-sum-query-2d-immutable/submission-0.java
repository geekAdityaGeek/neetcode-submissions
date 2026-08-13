class NumMatrix {

    int data[][];
    public NumMatrix(int[][] matrix) {

        data = new int[matrix.length+1][matrix[0].length+1];
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i=0; i<=m ; i++) {
            data[i][0] = 0;
        }
        for(int i=0; i<=n ; i++) {
            data[0][i] = 0;
        }
        for(int i = 1 ; i<= m ;i++) {
            for(int j = 1 ; j<=n ; j++) {
                data[i][j] = data[i-1][j] + data[i][j-1] + matrix[i-1][j-1] - data[i-1][j-1];
            }
        }

        // for(int i=0;i<=m;i++) {
        //     for(int j = 0 ; j<=n ; j++) {
        //         System.out.print(data[i][j]+" : ");
        //     }
        //     System.out.println();
        // }
        
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return data[row2+1][col2+1] + data[row1][col1] - data[row2+1][col1] - data[row1][col2+1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */