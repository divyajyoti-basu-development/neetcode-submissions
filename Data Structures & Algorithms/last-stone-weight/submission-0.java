class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> maxHeap = new PriorityQueue<>((s1, s2) -> s2 - s1);
        for(int stone : stones) {
            maxHeap.add(stone);
        }   
        int s1, s2;  
        while(maxHeap.size() != 1) {
            s1 = maxHeap.remove();
            s2 = maxHeap.remove();
            maxHeap.add(Math.abs(s1 - s2));
        }   
        return maxHeap.remove();
    }
}