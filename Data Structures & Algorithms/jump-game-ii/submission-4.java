class Solution {
    public int jump(int[] nums) {
        int jumpCount = 0;
        int maxJumpIndex = 0, prevMaxJumpIndex = maxJumpIndex;
        int index = 0;
        int temp;
        while(index < nums.length - 1) {            
            maxJumpIndex = Math.max(maxJumpIndex, index + nums[index]);
            if(prevMaxJumpIndex == index) {
                jumpCount++;
                prevMaxJumpIndex = maxJumpIndex;
            }
            index++;        
        }
        return jumpCount;
    }
}
