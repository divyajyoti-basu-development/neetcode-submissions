class Solution {

    private class Node {
        int[] pointsArr;
        String point;
        int distance;

        int getDistance() {
            return distance;
        }

        Node(String point, int distance, int[] pointsArr) {
            this.pointsArr = pointsArr;
            this.point = point;
            this.distance = distance;
        }
    }

    public int minCostConnectPoints(int[][] points) {
        int totalPoints = points.length;
        Set<String> pointsSet = new HashSet<>();
        Queue<Node> maxHeap = new PriorityQueue<>(Comparator.comparing(Node :: getDistance));
        String pointString = points[0][0] + "#" + points[0][1];
        int[] currentpoint = points[0];
        pointsSet.add(pointString);
        int distance;
        for(int index = 1 ; index < points.length ; index++) {
            pointString = points[index][0] + "#" + points[index][1];
            distance = Math.abs(currentpoint[0] - points[index][0]) + Math.abs(currentpoint[1] - points[index][1]);
            maxHeap.offer(new Node(pointString, distance, points[index]));            
        }
        int result = 0;
        Node currentNode;
        while(!maxHeap.isEmpty()) {
            currentNode = maxHeap.poll();
            pointString = currentNode.point;
            if(!pointsSet.contains(pointString)) {
                pointsSet.add(pointString);
                result += currentNode.distance;
                currentpoint = currentNode.pointsArr;
                for(int[] point : points) {
                    pointString = point[0] + "#" + point[1];
                    if(!pointsSet.contains(pointString)) {
                        distance = Math.abs(currentpoint[0] - point[0]) + Math.abs(currentpoint[1] - point[1]);
            maxHeap.offer(new Node(pointString, distance, point));
                    }
                }
            }
        }
        return result;
    }
}