class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (int1, int2) -> int1[0] - int2[0]);
        List<int[]> result = new ArrayList<>();
        int currentEnd = intervals[0][1];
        int currentStart = intervals[0][1];
        for(int[] interval : intervals) {
            if(interval[0] <= currentEnd) {
                currentStart = Math.min(currentStart, interval[0]);
                currentEnd = Math.max(currentEnd, interval[1]);
            } else {
                result.add(new int[] {currentStart, currentEnd});
                currentStart = interval[0];
                currentEnd = interval[1];
            }
        }
        result.add(new int[] {currentStart, currentEnd});
        return result.toArray(new int[result.size()][2]);
    }
}