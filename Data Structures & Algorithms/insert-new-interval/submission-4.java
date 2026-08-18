class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {        
        List<int[]> result = new ArrayList<>();
        if(intervals.length >= 1 && intervals[0][0] > newInterval[1]) {
            result.add(newInterval);
            for(int interval[] : intervals) {
                result.add(interval);
            }
            return result.toArray(new int[result.size()][2]);
        }
        if(intervals.length >= 1 && intervals[intervals.length - 1][1] < newInterval[0]) {            
            for(int[] interval : intervals) {
                result.add(interval);
            }
            result.add(newInterval);
            return result.toArray(new int[result.size()][2]);
        }
        boolean mergedFlag = false;
        int currentStart = newInterval[0], currentEnd = newInterval[1];
        for(int[] interval : intervals) {
            if(mergedFlag) {
                result.add(interval);
                continue;
            }
            if(interval[0] <= currentEnd && currentStart <= interval[0]
             || currentEnd >= interval[1] && currentStart <= interval[1]
             || currentStart < interval[0] && currentEnd > interval[1]
             || currentStart > interval[0] && currentEnd < interval[1]) {
                currentStart = Math.min(currentStart, interval[0]);
                currentEnd = Math.max(currentEnd, interval[1]);
                continue;
            }
            if(interval[0] > currentEnd) {
                mergedFlag = true;
                result.add(new int[] {currentStart, currentEnd});                
            }
            result.add(interval);
        }
        return mergedFlag == true ? result.toArray(new int[result.size()][2]) : new int[][]{new int[] {currentStart, currentEnd}};
    }
}