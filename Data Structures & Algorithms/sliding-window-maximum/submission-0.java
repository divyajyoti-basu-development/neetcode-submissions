class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
        int left = 0, right = 0;
        while(right < nums.length) {
            while(!deque.isEmpty() && deque.peekLast() < nums[right]) {                    
                    deque.removeLast();
            }
            deque.addLast(nums[right]);
            if(right - left + 1 == k) {
                result.add(deque.peekFirst());
                if(deque.peekFirst() == nums[left]) {
                    deque.removeFirst();
                }
                left++;                
            } 
            right++;
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}
