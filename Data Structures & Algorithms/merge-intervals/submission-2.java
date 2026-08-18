class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (int1, int2) -> int1[0] - int2[0]);
        List<int[]> result = new ArrayList<>();
        int currentStart = intervals[0][0];
        int currentEnd = intervals[0][1];
        for(int index = 1 ; index < intervals.length ; index++) {
            if(currentEnd < intervals[index][0]) {
                result.add(new int[]{currentStart, currentEnd});
                currentStart = intervals[index][0];
                currentEnd = intervals[index][1];
                continue;
            }
            currentStart = Math.min(currentStart, intervals[index][0]);
            currentEnd = Math.max(currentEnd, intervals[index][1]);
        }    
        result.add(new int[] {currentStart, currentEnd});
        return result.toArray(int[][] :: new);    
    }
}
