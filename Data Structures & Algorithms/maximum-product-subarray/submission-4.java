class Solution {

    private int[] memo ;
    private int result = Integer.MIN_VALUE;

    private void dp(int[] nums, int index, int current) {
        if(index == nums.length) {
            result = Math.max(result, current);
            return;
        }
        // if(memo[index] != -1) {
        //     return memo[index];
        // }
        result = Math.max(Math.max(nums[index], current * nums[index]), result);
        dp(nums, index + 1, current * nums[index]);
        dp(nums, index + 1, nums[index]);
        //dp(nums, index + 1, 1);
        //return Math.max(Math.max(product1, product2), product3);
    }
    public int maxProduct(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        dp(nums, 1, nums[0]);
        return result;
    }
}