class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length, cols = matrix[0].length;
        if(target < matrix[0][0] || target > matrix[rows - 1][cols - 1]) {
            return false;
        }
        int mid, left = 0, right = rows - 1;
        while(left <= right) {
            mid = (left + right) / 2;
            if(matrix[mid][0] == target) {
                return true;
            } else if(matrix[mid][0] > target) {
                right = mid - 1;
            } else if(matrix[mid][0] < target && target > matrix[mid][cols - 1]) {
                left = mid + 1;
            } else {
                left = 0; right = cols - 1;
                int rowMid;
                while(left <= right) {
                    rowMid = (left + right) / 2;
                    if(matrix[mid][rowMid] == target) {
                        return true;
                    } else if(matrix[mid][rowMid] > target) {
                        right = rowMid - 1;
                    } else {
                        left = rowMid + 1;
                    }
                }
                return false;
            }
        }
        return false;
    }
}
