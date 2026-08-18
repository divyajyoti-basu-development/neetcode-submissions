class KthLargest {

    private int k;
    private int[] nums;
    PriorityQueue<Integer> minHeap;

    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<>();        
        this.k = k;
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
    }
    
    public int add(int val) {
        int result;
        if(minHeap.size() < k) {
            minHeap.offer(val);
            return minHeap.peek();
        } else {
            if(minHeap.peek() < val) {
                minHeap.poll();
                minHeap.offer(val);                
            }
            return minHeap.peek();
        }
    }
}
