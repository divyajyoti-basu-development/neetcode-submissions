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

    private class Node {
        int time;
        char type;
        public Node(int time, char type) {
            this.time = time;
            this.type = type;
        }
        public int getTime() {
            return time;
        }
        public char getType() {
            return type;
        }
    }
    public int minMeetingRooms(List<Interval> intervals) {
        List<Node> nodesList = new ArrayList<>();
        int maxRooms = 0, currentRooms = 0;
        for(Interval interval : intervals) {
            nodesList.add(new Node(interval.start, 'S'));
            nodesList.add(new Node(interval.end, 'E'));
        }
        nodesList.sort(Comparator.comparing(Node :: getTime).thenComparing(Node :: getType));
        for(Node node : nodesList) {
            if(node.type == 'S') {
                currentRooms++;
                maxRooms = Math.max(maxRooms, currentRooms);
            } else {
                currentRooms--;
            }            
        }
        return maxRooms;
    }
}
