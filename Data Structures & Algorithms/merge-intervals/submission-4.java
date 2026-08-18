class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();        
        Arrays.sort(intervals, (int1, int2) -> int1[0] - int2[0]);
        int currentStart = intervals[0][0];
        int currentEnd = intervals[0][1];
        for(int index = 1 ; index < intervals.length ; index++) {
            if(intervals[index][0] > currentEnd) {
                result.add(new int[] {currentStart, currentEnd});
                currentStart = intervals[index][0];
                currentEnd = intervals[index][1];                
            } else {
                currentStart = Math.min(currentStart, intervals[index][0]);
                currentEnd = Math.max(currentEnd, intervals[index][1]);
            }
        }
        result.add(new int[]{currentStart, currentEnd});
        return result.stream().toArray(int[][] :: new);
    }
}
