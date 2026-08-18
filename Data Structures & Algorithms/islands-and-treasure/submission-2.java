class Solution {

    private void bfs(int[][] grid, boolean[][] visited, int row, int col, int dist, Queue<int[]> bfsQ) {
        if(row < 0 || col < 0 || row == grid.length || col == grid[0].length
        || visited[row][col] || grid[row][col] == -1) {
            return ;
        }
        visited[row][col] = true;
        grid[row][col] = dist;
        bfsQ.offer(new int[] {row + 1, col});
        bfsQ.offer(new int[] {row - 1, col});
        bfsQ.offer(new int[] {row, col + 1});
        bfsQ.offer(new int[] {row, col - 1});
    }

    public void islandsAndTreasure(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<int[]> bfsQ = new ArrayDeque<>();
        for(int row = 0 ; row < grid.length ; row++) {
            for(int col = 0 ; col < grid[0].length ; col++) {
                if(grid[row][col] == 0) {
                   bfsQ.offer(new int[] {row, col}); 
                }
            }
        }
        int dist = 0;
        int currentQSize;
        int[] currentPos;
        while(!bfsQ.isEmpty()) {
            currentQSize = bfsQ.size();
            for(int index = 1 ; index <= currentQSize ; index++) {
                currentPos = bfsQ.poll();
                bfs(grid, visited, currentPos[0], currentPos[1], dist, bfsQ);
            }
            dist++;
        }
    }

}
