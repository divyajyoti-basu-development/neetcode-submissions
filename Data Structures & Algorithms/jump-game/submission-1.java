class Solution {
    public boolean canJump(int[] nums) {
        int goal = nums.length - 1;
        for(int index = nums.length - 2 ; index >= 0 ; index--) {
            if(nums[index] + index >= goal) {
                goal = index;
            }
        }
        return goal == 0 ? true : false;
    }
}