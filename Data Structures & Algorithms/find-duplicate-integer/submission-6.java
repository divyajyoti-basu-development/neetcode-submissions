class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0], fast = nums[0];
        while(true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            System.out.println("Fast: " + fast);
            System.out.println("Slow: " + slow);
            if(slow == fast) {
                break;
            }
        }
        slow = nums[0];
        System.out.println("Cycle at Fast: " + fast);
        while(true) {
            if(slow == fast) {
                return slow;
            }
            slow = nums[slow];
            fast = nums[fast];
        }
        //return -1;
    }
}