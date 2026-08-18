class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length == 0) {
            return new int[][] {newInterval};
        }
        if(newInterval[1] < intervals[0][0]) {
            int[][] result = new int[intervals.length + 1][2];
            result[0] = newInterval;
            int counter = 0;
            while(counter < intervals.length) {
                result[counter + 1] = intervals[counter];
                counter++;                
            }
            return result;
        }
        if(newInterval[0] > intervals[intervals.length - 1][1]) {
            int[][] result = new int[intervals.length + 1][2];            
            int counter = 0;
            while(counter < intervals.length) {
                result[counter] = intervals[counter];
                counter++;                
            }
            result[result.length - 1] = newInterval;
            return result;
        }
        int intStart = newInterval[0], intEnd = newInterval[1];
        List<int[]> result = new ArrayList<>();
        for(int count = 0 ; count < intervals.length ; count++) {
            if(intervals[count][1] < newInterval[0]) {
                result.add(intervals[count]);                
            }
            else if(intervals[count][0] > newInterval[1]) {
                result.add(new int[] {intStart, intEnd});
                for( ; count < intervals.length ; count++) {
                    result.add(intervals[count]);
                }
                return result.toArray(new int[result.size()][2]);
            }
            else {
                intStart = Math.min(intStart, intervals[count][0]);
                intEnd = Math.max(intEnd, intervals[count][1]);
            }
        }
        result.add(new int[] {intStart, intEnd});
        return result.toArray(new int[result.size()][2]);
    }
}
