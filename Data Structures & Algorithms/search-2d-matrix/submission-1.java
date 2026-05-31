class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l = 0, h = matrix.length - 1;
        while (l < h) {
            int mid = (l + h) / 2;
            if(matrix[mid][0]<=target && matrix[mid][matrix[mid].length-1]>=target) {
                l = mid;
                break;
            } else if (matrix[mid][0]>target){
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        int row = l;
        //System.out.println(row);
        l = 0;
        h = matrix[row].length-1;
        while (l <= h) {
            int mid = (l + h) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] > target) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }
}
