class Solution {

    private class Coordinate {

        int dist;
        int x;
        int y;

        public Coordinate(int dist, int x, int y) {
            this.dist = dist;
            this.x = x;
            this.y = y;
        }

        public int getDist() {
            return dist;
        }

    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Coordinate> coordinatesQueue = new PriorityQueue<>(
            Comparator.comparing(Coordinate :: getDist).reversed());
        int currentDist;
        for(int[] point : points) {
            if(coordinatesQueue.size() < k) {
                coordinatesQueue.offer(new Coordinate(
                    (int) Math.pow(point[0], 2) + (int) Math.pow(point[1], 2), point[0], point[1]
                    ));
            } else {
                currentDist = (int) (Math.pow(point[0], 2) + Math.pow(point[1], 2));
                if(currentDist < coordinatesQueue.peek().dist) {
                    coordinatesQueue.poll();
                    coordinatesQueue.offer(new Coordinate(
                    currentDist, point[0], point[1]
                    ));
                }
            }
        }
        List<int[]> pointsList = new ArrayList<>();
        int[] currentPoint;
        Coordinate currentCoordinate;
        while(!coordinatesQueue.isEmpty()) {
            currentPoint = new int[2];
            currentCoordinate = coordinatesQueue.poll();
            currentPoint[0] = currentCoordinate.x;
            currentPoint[1] = currentCoordinate.y;
            pointsList.add(currentPoint);
        }
        return pointsList.toArray(int[][] :: new);
    }

}
