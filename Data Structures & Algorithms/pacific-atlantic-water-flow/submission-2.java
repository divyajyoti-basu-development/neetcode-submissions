class Solution {

    private void dfs(Set<String> pointsSet, int[][] heights, int row, int col, boolean[][] visited, int prevHeight) {
        if(row == heights.length || row < 0 || col == heights[0].length || col < 0
        || visited[row][col] || prevHeight > heights[row][col]) {
            return;
        }
        String point = row + "#" + col;
        pointsSet.add(point);
        visited[row][col] = true;
        dfs(pointsSet, heights, row + 1, col, visited, heights[row][col]);
        dfs(pointsSet, heights, row - 1, col, visited, heights[row][col]);
        dfs(pointsSet, heights, row, col + 1, visited, heights[row][col]);
        dfs(pointsSet, heights, row, col - 1, visited, heights[row][col]);
        //visited[row][col] = false;
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[][] visited1 = new boolean[heights.length][heights[0].length];
        boolean[][] visited2 = new boolean[heights.length][heights[0].length];
        Set<String> pacificSet = new HashSet<>();
        Set<String> atlanticSet = new HashSet<>();
        for(int col = 0 ; col < heights[0].length ; col++) {
            dfs(pacificSet, heights, 0, col, visited1, Integer.MIN_VALUE);
        }
        for(int col = 0 ; col < heights[0].length ; col++) {
            dfs(atlanticSet, heights, heights.length - 1, col, visited2, Integer.MIN_VALUE);
        }

        for(int row = 0 ; row < heights.length ; row++) {
            dfs(pacificSet, heights, row, 0, visited1, Integer.MIN_VALUE);
        }
        for(int row = 0 ; row < heights.length ; row++) {
            dfs(atlanticSet, heights, row, heights[0].length - 1, visited2, Integer.MIN_VALUE);
        }
        String[] points;
        for(String point : pacificSet) {
            if(atlanticSet.contains(point)) {
                points = point.split("#");
                result.add(Arrays.asList(Integer.valueOf(points[0]), Integer.valueOf(points[1])));
            }
        }
        return result;
    }
}