class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing( interval -> interval[0]));
        int intMin = intervals[0][0];
        int intMax = intervals[0][1];
        int deleteCount = 0;
        for(int count = 1 ; count < intervals.length ; count++) {
            if(intMax <= intervals[count][0]) {                
                intMax = intervals[count][1];
            } else {
                deleteCount++;
                intMax = Math.min(intMax, intervals[count][1]);
            }
        }
        return deleteCount;
    }
}
