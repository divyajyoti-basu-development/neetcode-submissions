class Solution {

    private void bfs(int[][] grid, int row, int col, boolean[][] visited
    , Queue<int[]> bfsTraverse, int location) {
        if(row == grid.length || row < 0 || col == grid[0].length || col < 0
        || visited[row][col] || grid[row][col] == -1 || grid[row][col] == 0) {
            return;
        }
        grid[row][col] = location + 1;
        visited[row][col] = true;
        bfsTraverse.add(new int[] {row, col});
    }

    public void islandsAndTreasure(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<int[]> bfsTraverse = new LinkedList<>();

        for(int row = 0 ; row < grid.length ; row++) {
            for(int col = 0 ; col < grid[0].length ; col++) {
                if(grid[row][col] == 0) {
                    bfsTraverse.add(new int[] {row, col});
                }
            }
        }

        int currentSize;
        int dist = 0;
        int[] currentLocation;
        int row, col;
        while(!bfsTraverse.isEmpty()) {
            currentSize = bfsTraverse.size();
            for(int index = 0 ; index < currentSize ; index++) {
                currentLocation = bfsTraverse.poll();
                row = currentLocation[0];
                col = currentLocation[1];
                bfs(grid, row + 1, col, visited, bfsTraverse, dist);
                bfs(grid, row - 1, col, visited, bfsTraverse, dist);
                bfs(grid, row, col + 1, visited, bfsTraverse, dist);
                bfs(grid, row, col - 1, visited, bfsTraverse, dist);
            }
            dist++;
        }
    }
}
