class Solution {

    private void bfs(int[][] grid, int row, int col, boolean[][] visited, Queue<String> bfsSearch, int count) {
        if(row == grid.length || row < 0 || col == grid[0].length || col < 0
            || visited[row][col] || grid[row][col] == 0 || grid[row][col] == 2) {
                return;
            }
        visited[row][col] = true;
        grid[row][col] = 2;
        StringBuilder sb = new StringBuilder("");
        sb.append(row);
        sb.append("#");
        sb.append(col);
        sb.append("#");
        sb.append(count + 1);
        bfsSearch.add(sb.toString());        
    }

    public int orangesRotting(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<String> bfsSearch = new LinkedList<>();
        StringBuilder sb;
        for(int row = 0 ; row < grid.length ; row++) {
            for(int col = 0 ; col < grid[0].length ; col++) {
                if(grid[row][col] == 2) {
                    sb = new StringBuilder("");
                    sb.append(row);
                    sb.append("#");
                    sb.append(col);
                    sb.append("#");
                    sb.append(0);
                    bfsSearch.add(sb.toString());
                }
            }
        }
        String point;
        String[] values;
        int minTime = 0, count, row, col;
        while(!bfsSearch.isEmpty()) {
            point = bfsSearch.poll();
            values = point.split("#");
            row = Integer.valueOf(values[0]);
            col = Integer.valueOf(values[1]);
            count = Integer.valueOf(values[2]);
            minTime = Math.max(minTime, count);
            bfs(grid, row + 1, col, visited, bfsSearch, count);
            bfs(grid, row - 1, col, visited, bfsSearch, count);
            bfs(grid, row, col - 1, visited, bfsSearch, count);
            bfs(grid, row, col + 1, visited, bfsSearch, count);
        }
        for(int row1 = 0 ; row1 < grid.length ; row1++) {
            for(int col1 = 0 ; col1 < grid[0].length ; col1++) {
                if(grid[row1][col1] == 1) {
                    return -1;
                }
            }
        }
        return minTime;
    }
}