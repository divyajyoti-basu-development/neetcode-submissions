class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (int1, int2) -> int1[0] - int2[0]);
        int currentMaxEnd = Integer.MIN_VALUE, count = 0;
        for(int[] interval : intervals) {
            if(interval[0] < currentMaxEnd) {
                currentMaxEnd = Math.min(currentMaxEnd, interval[1]);
                count++;
            } else {
                currentMaxEnd = interval[1];
            }
        }
        return count;
    }
}