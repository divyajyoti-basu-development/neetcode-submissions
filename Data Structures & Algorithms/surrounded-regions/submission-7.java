class Solution {

    private void updateNonSurrounded(char[][] grid, int row, int col, boolean[][] visited) {
        if(row < 0 || row == grid.length || col < 0 || col == grid[0].length
        || visited[row][col] || grid[row][col] == 'X') {
            return;
        }
        visited[row][col] = true;
        grid[row][col] = 'T';
        updateNonSurrounded(grid, row + 1, col, visited);
        updateNonSurrounded(grid, row - 1, col, visited);
        updateNonSurrounded(grid, row, col + 1, visited);
        updateNonSurrounded(grid, row, col - 1, visited);
    }

    public void solve(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int col = 0 ; col < grid[0].length ; col++) {
            if(grid[0][col] == 'O') {
                updateNonSurrounded(grid, 0, col, visited);
            }
        }
        for(int col = 0 ; col < grid[0].length ; col++) {
            if(grid[grid.length - 1][col] == 'O') {
                updateNonSurrounded(grid, grid.length - 1, col, visited);
            }
        }
        for(int row = 0 ; row < grid.length ; row++) {
            if(grid[row][0] == 'O') {
                updateNonSurrounded(grid, row, 0, visited);
            }
        }
        for(int row = 0 ; row < grid.length ; row++) {
            if(grid[row][grid[0].length - 1] == 'O') {
                updateNonSurrounded(grid, row, grid[0].length - 1, visited);
            }
        }
        for(int row = 0 ; row < grid.length ; row++) {
            for(int col = 0 ; col < grid[0].length ; col++) {
                if(grid[row][col] == 'T') {
                    grid[row][col] = 'O';
                } else if(grid[row][col] == 'O') {
                    grid[row][col] = 'X';
                }
            }
        }
    }
}
