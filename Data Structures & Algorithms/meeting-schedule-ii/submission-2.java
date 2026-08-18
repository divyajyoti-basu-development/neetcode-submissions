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
    public int minMeetingRooms(List<Interval> intervals) {
        if(intervals.size() == 0) {
            return 0;
        }
        int[] startArr = new int[intervals.size()];
        int[] endArr = new int[intervals.size()];        
        for(int index = 0 ; index < intervals.size() ; index++) {
            startArr[index] = intervals.get(index).start;
            endArr[index] = intervals.get(index).end;
        }
        Arrays.sort(startArr);
        Arrays.sort(endArr);
        int startPointer = 0;
        int endPointer = 0;
        int meetingRooms = 0;
        int currentMeetings = 0;
        while(startPointer < intervals.size() && endPointer < intervals.size()) {
            if(startArr[startPointer] < endArr[endPointer]) {
                currentMeetings++;
                meetingRooms = Math.max(currentMeetings, meetingRooms); 
                startPointer++;               
            } else{
                currentMeetings--;
                endPointer++;
            }
        }
        return meetingRooms;
    }
}
