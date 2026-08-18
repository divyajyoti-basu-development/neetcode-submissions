class Solution {

    private class PointNode {
        int dist;
        int[] coordinates;
        PointNode(int dist, int[] point) {
            coordinates = new int[2];
            coordinates[0] = point[0];
            coordinates[1] = point[1];
            this.dist = dist;
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        Queue<PointNode> minHeap = new PriorityQueue<>((n1, n2) -> n2.dist - n1.dist);
        int dist;
        for(int[] point : points) {
            dist = (int)Math.pow(point[0], 2) + (int)Math.pow(point[1], 2);
            if(minHeap.size() < k) {
                minHeap.add(new PointNode(dist, point));
            } else {
                if(dist < minHeap.peek().dist) {
                    minHeap.remove();
                    minHeap.add(new PointNode(dist, point));
                }
            }

        }
        int[][] result = new int[k][2];
        for(int index = 0 ; index < k ; index++) {
            result[index] = minHeap.remove().coordinates;
        }
        return result;
    }
}