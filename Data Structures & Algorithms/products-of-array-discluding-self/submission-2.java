class Solution {
    public int[] productExceptSelf(int[] nums) {
        int left = 1;
        int[] result = new int[nums.length];
        for(int index = 0 ; index < nums.length ; index++) {
            result[index] = left;
            left = nums[index] * left;
        }
        left = 1;
        for(int index = nums.length - 1 ; index > -1 ; index--) {
            result[index] = result[index] * left;
            left = left * nums[index];
        }
        return result;
    }
}  
