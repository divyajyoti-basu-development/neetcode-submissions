class Solution {

    private int getIslandSize(int[][] grid, boolean[][] visited, int row, int col) {
        if(row < 0 || col < 0 || row == grid.length || col == grid[0].length
        || visited[row][col] || grid[row][col] == 0) {
            return 0;
        }
        visited[row][col] = true;
        return 1 + getIslandSize(grid, visited, row + 1, col) + getIslandSize(grid, visited, row - 1, col)
                + getIslandSize(grid, visited, row, col + 1) + getIslandSize(grid, visited, row, col - 1);
    }

    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int maxSize = 0;
        for(int row = 0 ; row < grid.length ; row++) {
            for(int col = 0 ; col < grid[0].length ; col++) {
                if(!visited[row][col] && grid[row][col] == 1) {
                    maxSize = Math.max(maxSize, getIslandSize(grid, visited, row, col));
                }
            }
        }
        return maxSize;
    }
}
