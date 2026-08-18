class Solution {
    public boolean canJump(int[] nums) {
        int maxJumpIndex = 0;
        int index = 0;        
        while(index <= maxJumpIndex && maxJumpIndex < nums.length) {
            maxJumpIndex = Math.max(maxJumpIndex, index + nums[index]);
            if(maxJumpIndex >= nums.length - 1) {
                return true;
            }
            index++;
        }
        
        return false;
    }    
}
