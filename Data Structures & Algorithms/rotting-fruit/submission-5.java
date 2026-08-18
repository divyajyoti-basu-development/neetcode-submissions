class Solution {

    private boolean bfs(int[][] grid, boolean[][] visited, int row, int col, Queue<int[]> bfsQ) {
        if(row < 0 || col < 0 || row == grid.length || col == grid[0].length
        || visited[row][col] || grid[row][col] == 0) {
            return false;
        }
        visited[row][col] = true;
        grid[row][col] = 2;
        bfsQ.offer(new int[] {row + 1, col});
        bfsQ.offer(new int[] {row - 1, col});
        bfsQ.offer(new int[] {row, col - 1});
        bfsQ.offer(new int[] {row, col + 1});
        return true;        
    }

    public int orangesRotting(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<int[]> bfsQ = new ArrayDeque<>();
        for(int row = 0 ; row < grid.length ; row++) {
            for(int col = 0 ; col < grid[0].length ; col++) {
                if(grid[row][col] == 2) {
                    bfsQ.offer(new int[] {row, col});
                }
            }
        }
        int[] currentPoint;
        int timer = -1, currentQSize;
        boolean rotFlag;
        while(!bfsQ.isEmpty()) {
            rotFlag = false;
            currentQSize = bfsQ.size();
            for(int pos = 1 ; pos <= currentQSize ; pos++) {
                currentPoint = bfsQ.poll();
                if(bfs(grid, visited, currentPoint[0], currentPoint[1], bfsQ)) {
                        rotFlag = true;
                    }
            }
            timer = rotFlag ? timer + 1 : timer;
        }
        for(int row = 0 ; row < grid.length ; row++) {
            for(int col = 0 ; col < grid[0].length ; col++) {
                if(grid[row][col] == 1) {
                    return -1;
                }
            }
        }
        return timer == -1 ? 0 : timer;
    }

}
