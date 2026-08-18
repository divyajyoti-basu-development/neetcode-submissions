class Solution {

    private int[] memo;

    private int maxMoney(int[] nums, int houseNo) {
        if(houseNo >= nums.length) {
            return 0;
        }
        if(houseNo == nums.length - 1) {
            return nums[houseNo];
        }
        if(memo[houseNo] != -1) {
            return memo[houseNo];
        }
        return memo[houseNo] = Math.max(nums[houseNo] + maxMoney(nums, houseNo + 2), maxMoney(nums, houseNo + 1));
    }
    public int rob(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return maxMoney(nums, 0);
    }
}