class KthLargest {

    int k;
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int num : nums) {
            if(minHeap.size() < k) {
                minHeap.offer(num);
            } else {
                if(num > minHeap.peek()) {
                    minHeap.poll();
                    minHeap.offer(num);
                }
            }
        }

    }
    
    public int add(int val) {
        if(minHeap.size() < k) {
            minHeap.offer(val);
        }
        else if(val > minHeap.peek()) {
            minHeap.poll();
            minHeap.offer(val);            
        }
        return minHeap.peek();
    }
    
}
