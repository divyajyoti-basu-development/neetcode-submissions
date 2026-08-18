class Solution {

    private void dfs(int[][] heights, int row, int col, boolean[][] visited, int prev, Set<String> pointSet) {
        if(row < 0 || col < 0 || row == heights.length || col == heights[0].length
        || visited[row][col] || heights[row][col] < prev) {
            return;
        }
        pointSet.add(row + "#" + col);
        visited[row][col] = true;
        dfs(heights, row + 1, col, visited, heights[row][col], pointSet);
        dfs(heights, row - 1, col, visited, heights[row][col], pointSet);
        dfs(heights, row, col + 1, visited, heights[row][col], pointSet);
        dfs(heights, row, col - 1, visited, heights[row][col], pointSet);
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean[][] visited = new boolean[heights.length][heights[0].length];
        Set<String> atlanticSet = new HashSet<>();
        Set<String> pacificSet = new HashSet<>();
        for(int col = 0 ; col < heights[0].length ; col++) {
            dfs(heights, 0, col, visited, heights[0][col], pacificSet);
        }
        for(int row = 0 ; row < heights.length ; row++) {
            dfs(heights, row, 0, visited, heights[row][0], pacificSet);
        }
        for(boolean[] visitArr : visited) {
            Arrays.fill(visitArr, false);
        }
        for(int col = 0 ; col < heights[0].length ; col++) {
            dfs(heights, heights.length - 1, col, visited, heights[heights.length - 1][col], atlanticSet);
        }
        for(int row = 0 ; row < heights.length ; row++) {
            dfs(heights, row, heights[0].length - 1, visited, heights[row][heights[0].length - 1], atlanticSet);
        }
        Set<String> commonSet = new HashSet<>();
        pacificSet.forEach(str -> {
            if(atlanticSet.contains(str)) {
                commonSet.add(str);
            }
        });
        List<List<Integer>> result = new ArrayList<>();
        commonSet.forEach(str -> {
            String[] pointsArr = str.split("#");
            result.add(List.of(Integer.valueOf(pointsArr[0]), Integer.valueOf(pointsArr[1])));
        }
        );
        return result;
    }
}
