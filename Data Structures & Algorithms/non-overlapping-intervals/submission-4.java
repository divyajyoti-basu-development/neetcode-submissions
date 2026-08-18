class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (int1, int2) -> int1[0] - int2[0]);
        int deleteCount = 0, currentEnd = intervals[0][1];
        for(int index = 1 ; index < intervals.length ; index++) {
            if(currentEnd <= intervals[index][0]) {                
                currentEnd = intervals[index][1];
            } else {
                deleteCount++;                
                currentEnd = Math.min(currentEnd, intervals[index][1]);
            }
        }
        return deleteCount;
    }
}
