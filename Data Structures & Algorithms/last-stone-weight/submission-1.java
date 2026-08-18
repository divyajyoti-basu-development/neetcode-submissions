class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for(int stone : stones) {
            maxHeap.offer(stone);
        }
        int stone1, stone2;
        while(maxHeap.size() > 1) {
            stone1 = maxHeap.poll();
            stone2 = maxHeap.poll();
            if(stone1 - stone2 > 0) {
                maxHeap.offer(stone1 - stone2);
            }
        }
        return maxHeap.size() == 1 ? maxHeap.poll() : 0;
    }
}
