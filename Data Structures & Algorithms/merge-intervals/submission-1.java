class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing(interval -> interval[0]));
        int intMin = intervals[0][0];
        int intMax = intervals[0][1];
        List<int[]> result = new ArrayList<>();
        for(int counter = 1 ; counter < intervals.length ; counter++) {
            if(intMax < intervals[counter][0]) {
                result.add(new int[] {intMin, intMax});
                intMin = intervals[counter][0];
                intMax = intervals[counter][1];
            }
            else {
                intMin = Math.min(intMin, intervals[counter][0]);
                intMax = Math.max(intMax, intervals[counter][1]);
            }
        }
        result.add(new int[] {intMin, intMax});
        return result.toArray(new int[result.size()][2]);
    }
}
