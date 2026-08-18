class Solution {

    private void dfsFindPossiblePoints(int[][] heights, boolean[][] visited, int row, int col
    , Set<String> uniquePoints, int prevHeight) {
        if(row < 0 || row == heights.length || col < 0 || col == heights[0].length
        || visited[row][col] || prevHeight > heights[row][col]) {
            return;
        }
        visited[row][col] = true;
        uniquePoints.add(new StringBuilder().append(row).append("#").append(col).toString());
        dfsFindPossiblePoints(heights, visited, row + 1, col, uniquePoints, heights[row][col]);
        dfsFindPossiblePoints(heights, visited, row - 1, col, uniquePoints, heights[row][col]);
        dfsFindPossiblePoints(heights, visited, row, col + 1, uniquePoints, heights[row][col]);
        dfsFindPossiblePoints(heights, visited, row, col - 1, uniquePoints, heights[row][col]);
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean[][] visited = new boolean[heights.length][heights[0].length];
        Set<String> pacificLocations = new HashSet<>();
        Set<String> atlanticLocations = new HashSet<>();
        for(int col = 0 ; col < heights[0].length ; col++) {
            dfsFindPossiblePoints(heights, visited, 0, col, pacificLocations, heights[0][col]);
        }
        for(int row = 0 ; row < heights.length ; row++) {
            dfsFindPossiblePoints(heights, visited, row, 0, pacificLocations, heights[row][0]);
        }
        for(boolean[] row : visited) {
            Arrays.fill(row, false);
        }
        for(int col = 0 ; col < heights[0].length ; col++) {
            dfsFindPossiblePoints(heights, visited, heights.length - 1, col, atlanticLocations, heights[heights.length - 1][col]);
        }
        for(int row = 0 ; row < heights.length ; row++) {
            dfsFindPossiblePoints(heights, visited, row, heights[0].length - 1, atlanticLocations, heights[row][heights[0].length - 1]);
        }
        List<List<Integer>> result = new ArrayList<>();
        atlanticLocations.forEach(str -> {            
            if(pacificLocations.contains(str)) {
                String[] positionArr = str.split("#");
               result.add(List.of(Integer.valueOf(positionArr[0]), Integer.valueOf(positionArr[1]))); 
            }
        });
        return result;
    }
}
