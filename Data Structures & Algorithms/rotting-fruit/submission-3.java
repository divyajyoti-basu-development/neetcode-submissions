class Solution {

    private boolean bfsrott(int[][] grid, boolean[][] visited, int row, int col, Queue<int[]> bfsQ) {
        if(row < 0 || row == grid.length || col < 0 || col == grid[0].length
        || visited[row][col] || grid[row][col] == 0 || grid[row][col] == 2) {
            return false;
        }
        visited[row][col] = true;
        grid[row][col] = 2;
        bfsQ.offer(new int[] { row + 1, col});
        bfsQ.offer(new int[] { row - 1, col});
        bfsQ.offer(new int[] { row, col - 1});
        bfsQ.offer(new int[] { row, col + 1});
        return true;
    }

    public int orangesRotting(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<int[]> bfsQ = new ArrayDeque<>(grid.length * grid[0].length);
        for(int row = 0 ; row < grid.length ; row++) {
            for(int col = 0 ; col < grid[0].length ; col++) {
                if(grid[row][col] == 2) {
                    bfsQ.offer(new int[] { row + 1, col});
                    bfsQ.offer(new int[] { row - 1, col});
                    bfsQ.offer(new int[] { row, col - 1});
                    bfsQ.offer(new int[] { row, col + 1});
                }
            }
        }
        int bfsWidth, time = 0;
        int[] posArr;
        while(!bfsQ.isEmpty()) {
            bfsWidth = bfsQ.size();
            boolean didRot = false;
            while(bfsWidth > 0) {
                posArr = bfsQ.poll();
                if(bfsrott(grid, visited, posArr[0], posArr[1], bfsQ)) {
                    didRot = true;
                }
                bfsWidth--;
            }
            time = didRot ? time + 1 : time;
        }

        for(int[] row : grid) {
            for(int val : row) {
                if(val == 1) {
                    return -1;
                }
            }
        }
        return time;
    }
}
