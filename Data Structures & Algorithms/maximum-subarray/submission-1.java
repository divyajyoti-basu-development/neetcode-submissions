class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0], currentSum = nums[0];
        for(int index = 1 ; index < nums.length ; index++) {
            if(nums[index] > 0) {
                if(currentSum > 0) {
                    currentSum = currentSum + nums[index];
                } else {                    
                    currentSum = nums[index];
                }
            } else {                
                maxSum = Math.max(maxSum, currentSum);
                if(currentSum + nums[index] > 0) {
                    currentSum = currentSum + nums[index];
                } else {
                    currentSum = nums[index];
                }
            }
        }
        return maxSum = Math.max(maxSum, currentSum);
    }
}
