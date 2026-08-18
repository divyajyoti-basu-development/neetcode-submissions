class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> maxStack = new PriorityQueue<>(Comparator.reverseOrder());
        int left = 0, right = 0;              
        while(right < nums.length) {            
            if(right - left + 1 == k) {
                while(!maxStack.isEmpty() && maxStack.peek() < nums[right]) {
                    maxStack.poll();
                }
                maxStack.offer(nums[right]);
                result.add(maxStack.peek());
                if(maxStack.peek() == nums[left]) {
                    maxStack.poll();
                }
                left++;                
                right++;
            } else {
                while(!maxStack.isEmpty() && maxStack.peek() < nums[right]) {
                    maxStack.poll();
                }
                maxStack.offer(nums[right]); 
                right++; 
            }         
            
        }
        return result.stream()
        .mapToInt(Integer :: intValue)
        .toArray();
    }
}
