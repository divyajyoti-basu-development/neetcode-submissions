class Solution {
    public int[] productExceptSelf(int[] nums) {
        int left = 1, right = 1;
        int[] result = new int[nums.length];
        for(int index = 0 ; index < nums.length ; index++) {
            result[index] = left;
            left = left * nums[index];
        }
        for(int index = nums.length - 1 ; index >= 0 ; index--) {
            result[index] = result[index] * right;
            right = right * nums[index];
        }
        return result;
    }
}  
