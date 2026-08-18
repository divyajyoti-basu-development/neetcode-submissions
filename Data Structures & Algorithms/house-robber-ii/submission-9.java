class Solution {

    private int solve(int[] nums, int index, int maxIndex, int[] memo) {
        if(index > maxIndex) {
            return 0;
        }
        if(memo[index] != -1) {
            return memo[index];
        }
        int robHouse = nums[index] + solve(nums, index + 2, maxIndex, memo);
        int dontRobHouse = solve(nums, index + 1, maxIndex, memo);
        return memo[index] = Math.max(robHouse, dontRobHouse);
    }

    public int rob(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        int rob1 = solve(nums, 0, nums.length - 2, memo);
        Arrays.fill(memo, -1);
        int rob2 = solve(nums, 1, nums.length - 1, memo);
        return Math.max(rob1, rob2);
    }

}
