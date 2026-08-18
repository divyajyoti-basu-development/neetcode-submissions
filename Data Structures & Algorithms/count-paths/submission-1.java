class Solution {

    private int solve(int m, int n, int row, int col, int[][] memo) {
        if(row == m - 1 && col == n - 1) {
            return 1;
        }
        if(row < 0 || col < 0 || row == m || col == n) {
            return 0;
        }
        if(memo[row][col] != -1) {
            return memo[row][col];
        }
        return memo[row][col] = solve(m, n, row + 1, col, memo) + solve(m, n, row, col + 1, memo);
    }

    public int uniquePaths(int m, int n) {
        int[][] memo = new int[m][n];
        for(int[] cache : memo) {
            Arrays.fill(cache, -1);
        }
        return solve(m, n, 0, 0, memo);
    }
    
}
