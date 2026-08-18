class Solution {

    private class CarNode {
        private int dist;
        private double time;

        public CarNode(int dist, double time) {
            this.dist = dist;
            this.time = time;
        }

        public int getDist() {
            return dist;
        }

    }


    public int carFleet(int target, int[] position, int[] speed) {
        PriorityQueue<CarNode> minHeap = new PriorityQueue<>(Comparator.comparing(CarNode :: getDist));
        for(int index = 0 ; index < position.length ; index++) {
            minHeap.offer(new CarNode(target - position[index], (double) (target - position[index]) / speed[index]));
        }
        int fleetCount = 1;
        double currentMaxTime = minHeap.poll().time;
        while(!minHeap.isEmpty()) {
            if(minHeap.peek().time <= currentMaxTime) {
                minHeap.poll();
                continue;
            } else {
                fleetCount++;
                currentMaxTime = minHeap.poll().time;
            }
        }
        return fleetCount;
    }
}
