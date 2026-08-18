class Solution {

    private class CarNode {
        double time;
        int finishDist;

        public int getFinishDist() {
            return finishDist;
        }

        CarNode(double time, int finishDist) {
            this.time = time;
            this.finishDist = finishDist;
        }

    }

    public int carFleet(int target, int[] position, int[] speed) {        
        PriorityQueue<CarNode> carsQueue = new PriorityQueue<>(Comparator.comparing(CarNode :: getFinishDist));
        for(int index = 0 ; index < position.length ; index++) {
            double time = ((double)target - position[index]) / speed[index];
            carsQueue.offer(new CarNode(time, target - position[index]));
        }
        int fleetCount = 1;
        double currentMaxTime = carsQueue.poll().time;
        while(!carsQueue.isEmpty()) {
            if(carsQueue.peek().time > currentMaxTime) {                
                fleetCount++;
                currentMaxTime = carsQueue.peek().time;
            } 
            carsQueue.poll();
        }
        return fleetCount;
    }

}
