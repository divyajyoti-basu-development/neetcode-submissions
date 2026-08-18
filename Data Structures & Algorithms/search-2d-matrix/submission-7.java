class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0, right = matrix.length - 1, mid;
        int matrixLength = matrix[0].length - 1;
        while(left <= right) {
            mid = (left + right) / 2;
            if(matrix[mid][0] == target) {
                return true;
            }
            if(matrix[mid][0] < target && matrix[mid][matrixLength] >= target) {
                left = 0;
                right = matrixLength;
                int mid2;
                while(left <= right) {
                    mid2 = (left + right) / 2;
                    if(matrix[mid][mid2] == target) {
                        return true;
                    } else if(matrix[mid][mid2] < target) {
                        left = mid2 + 1;
                    } else {
                        right = mid2 - 1;
                    }
                }
                return false;
            }
            else if(matrix[mid][0] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
