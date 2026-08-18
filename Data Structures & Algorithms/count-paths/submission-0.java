class Solution {

    private int getPaths(int m, int n, int row, int col, int[][] memo) {
        if(row == m || col == n) {
            return 0;
        }        

        if(row == m - 1 && col == n - 1) {
            return 1;
        }

        if(memo[row][col] != -1) {
            return memo[row][col];
        }
        
        return memo[row][col] = getPaths(m, n, row + 1, col, memo) + getPaths(m, n, row, col + 1, memo);
    }

    public int uniquePaths(int m, int n) {
        int[][] memo = new int[m + 1][n + 1];
        for(int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return getPaths(m, n, 0, 0, memo);
    }
}
