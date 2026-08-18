class Solution {

    private void dfs(char[][] grid, boolean[][] visited, int row, int col) {
        if(row < 0 || col < 0 || row == grid.length || col == grid[0].length
        || visited[row][col] || grid[row][col] == '0') {
            return;
        }
        visited[row][col] = true;
        dfs(grid, visited, row + 1, col);
        dfs(grid, visited, row - 1, col);
        dfs(grid, visited, row, col - 1);
        dfs(grid, visited, row, col + 1);
    }
    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for(int row = 0 ; row < grid.length ; row++) {
            for(int col = 0 ; col < grid[0].length ; col++) {
                if(!visited[row][col] && grid[row][col] == '1') {
                    dfs(grid, visited, row, col);
                    count++;
                }
            }
        }
        return count;
    }
}
