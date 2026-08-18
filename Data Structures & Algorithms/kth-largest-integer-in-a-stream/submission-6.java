class KthLargest {

    Queue<Integer> streamQ = new PriorityQueue<>();
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int element : nums) {
            if(streamQ.size() < k) {
                streamQ.add(element);
            } else {
                if(streamQ.peek() < element) {
                    streamQ.remove();
                    streamQ.add(element);
                }
            }
        }
    }
    
    public int add(int val) {
        System.out.println("Adding: " + val);
        System.out.println("Queue Size: " + streamQ.size());
        if(streamQ.size() < k) {
            System.out.println("Executed if");
            streamQ.add(val);
        } else {
            System.out.println("Executed else");
            if(streamQ.peek() < val) {
                streamQ.remove();
                streamQ.add(val);
            }
        }
        return streamQ.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */