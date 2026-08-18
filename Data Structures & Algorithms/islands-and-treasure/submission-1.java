class Solution {

    private void bfsUpdateDist(int[][] grid, boolean[][] visited, int row, int col
        , Queue<int[]> bfsQ, int dist) {
        if(row < 0 || row == grid.length || col < 0 || col == grid[0].length
        || visited[row][col] || grid[row][col] == -1) {
            return;
        }
        visited[row][col] = true;
        grid[row][col] = dist;
        bfsQ.offer(new int[] { row + 1, col});
        bfsQ.offer(new int[] { row - 1, col});
        bfsQ.offer(new int[] { row, col + 1});
        bfsQ.offer(new int[] { row, col - 1});
    }

    public void islandsAndTreasure(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<int[]> bfsQ = new ArrayDeque<>(grid.length * grid[0].length);
        for(int row = 0 ; row < grid.length ; row++) {
            for(int col = 0 ; col < grid[0].length ; col++) {
                if(grid[row][col] == 0) {
                    bfsQ.add(new int[] { row, col});
                }
            }
        }        
        int dist = 0, bfsWidth;
        int[] posArr;
        while(!bfsQ.isEmpty()) { 
            bfsWidth = bfsQ.size();           
            while(bfsWidth > 0) {
                posArr = bfsQ.poll();
                bfsUpdateDist(grid, visited, posArr[0], posArr[1], bfsQ, dist);
                bfsWidth--;
            }
            dist++;
        }
    }
}
