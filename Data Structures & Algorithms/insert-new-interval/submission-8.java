class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) { 
        if(intervals.length == 0) {
            return new int[][] {newInterval};
        }       
        int totalIntervals = intervals.length;
        int[][] result;
        if(newInterval[1] < intervals[0][0]) {
            result = new int[totalIntervals + 1][2];
            result[0] = newInterval;
            for(int index = 0 ; index < totalIntervals ; index++) {
                result[index + 1] = intervals[index];
            }
            return result;
        }
        if(newInterval[0] > intervals[totalIntervals - 1][1]) {
            result = new int[totalIntervals + 1][2];
            for(int index = 0 ; index < totalIntervals ; index++) {
                result[index] = intervals[index];
            }
            result[totalIntervals] = newInterval;
            return result;
        }
        List<int[]> intervalsList = new ArrayList<>();
        int start = newInterval[0], end = newInterval[1];
        int[] interval;
        for(int index = 0 ; index < totalIntervals ; index++) {
            interval = intervals[index];
            if(interval[1] < start) {
                intervalsList.add(interval);
                continue;
            }
            if(interval[0] > end) {
                intervalsList.add(new int[] {start, end});
                while(index < totalIntervals) {
                    intervalsList.add(intervals[index]);
                    index++;
                }
                return intervalsList.toArray(int[][] :: new);
            }
            start = Math.min(start, interval[0]);
            end = Math.max(end, interval[1]);
        }
        intervalsList.add(new int[] {start, end});
        return intervalsList.toArray(int[][] :: new);
    }
}
