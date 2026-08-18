class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int number : nums) {
            if(minHeap.size() < k) {
                minHeap.offer(number);
            } else {
                if(minHeap.peek() < number) {
                    minHeap.poll();
                    minHeap.offer(number);
                }
            }
        }
        return minHeap.poll();
    }
}
