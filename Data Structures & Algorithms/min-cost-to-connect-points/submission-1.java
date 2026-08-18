class Solution {

    private class Node {
        int distance;
        int[] point;

        int getDistance() {
            return this.distance;
        }

        int[] getPoint() {
            return this.point;
        }

        Node(int distance, int[] point) {
            this.distance = distance;
            this.point = point;
        }
    }

    public int minCostConnectPoints(int[][] points) {
        Set<String> visited = new HashSet<>();
        int result = 0;
        Queue<Node> minHeap = new PriorityQueue<>(Comparator.comparing(Node :: getDistance));
        minHeap.offer(new Node(0, points[0]));
        Node currentNode;        
        int[] currentPoint;
        while(!minHeap.isEmpty()) {
            currentNode = minHeap.poll();
            if(visited.contains(currentNode.getPoint()[0] + "#" + currentNode.getPoint()[1])) {
                continue;
            }
            visited.add(currentNode.getPoint()[0] + "#" + currentNode.getPoint()[1]);
            result += currentNode.getDistance();
            currentPoint = currentNode.getPoint();
            for(int[] point : points) {
                String neighbour = point[0] + "#" + point[1];
                if(!visited.contains(neighbour)) {
                    int dist = Math.abs(currentPoint[0] - point[0])
                    + Math.abs(currentPoint[1] - point[1]);
                    minHeap.offer(new Node(dist, point));
                }
            }            
        }
        return result;
    }
}
