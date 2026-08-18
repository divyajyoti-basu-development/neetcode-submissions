/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        int currentEnd = -1;
        intervals.sort((int1, int2) -> int1.start - int2.start);
        for(Interval interval : intervals) {
            if(currentEnd > interval.start) {
                return false;
            }
            currentEnd = interval.end;
        }
        return true;
    }
}
