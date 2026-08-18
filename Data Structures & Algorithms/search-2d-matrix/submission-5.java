class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length, cols = matrix[0].length;
        if(target < matrix[0][0] || target > matrix[rows - 1][cols - 1]) {
            return false;
        }
        int left = 0, right = rows - 1;
        int mid = 0;
        while(left <= right) {
            mid = (left + right) / 2;
            if(target == matrix[mid][0]) {
                return true;
            }
            if(target < matrix[mid][0]) {
                right = mid - 1;
            } else if(target > matrix[mid][0] && target <= matrix[mid][cols - 1]){
                break;
            } else {
                left = mid + 1;
            }
        }
        left = 0;
        right = cols - 1;   
        int search = mid;     
        while(left <= right) {
            mid = (left + right) / 2;
            if(target == matrix[search][mid]) {
                return true;
            }
            if(target < matrix[search][mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}