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
        if(intervals.size() == 0) {
            return true;
        }
        intervals.sort((int1, int2) -> int1.start - int2.start);
        int currentStart = intervals.get(0).start;
        int currentEnd = intervals.get(0).end;
        for(int index = 1 ; index < intervals.size() ; index++) {
            if(currentEnd > intervals.get(index).start) {
                return false;
            }
            currentEnd = intervals.get(index).end;
        }
        return true;        
    }
}
