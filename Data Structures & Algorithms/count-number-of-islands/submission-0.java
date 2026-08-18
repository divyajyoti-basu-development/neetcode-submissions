class Solution {

    private void dfs(char[][] grid, boolean[][] visited, int row, int col) {
        if(row == visited.length || row < 0 || col == visited[0].length || col < 0
            || visited[row][col] || grid[row][col] == '0') {
            return;
        }
        visited[row][col] = true;
        dfs(grid, visited, row + 1, col);
        dfs(grid, visited, row - 1, col);
        dfs(grid, visited, row, col + 1);
        dfs(grid, visited, row, col - 1);
    }

    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for(int row = 0 ; row < grid.length ; row++) {
            for(int col = 0 ; col < grid[0].length ; col++) {
                if(grid[row][col] == '1' && !visited[row][col]) {
                    dfs(grid, visited, row, col);
                    count++;
                }
            }
        }
        return count;
    }
}
