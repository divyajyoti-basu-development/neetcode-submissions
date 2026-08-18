class Solution {

    private int findMaxSteal(int[] houseMoney, int limit, int current, int[] memo) {        
        if(current > limit) {
            return 0;
        }
        if(memo[current] != -1) {
            return memo[current];
        }
        int steal = houseMoney[current] + findMaxSteal(houseMoney, limit, current + 2, memo);
        int noSteal = findMaxSteal(houseMoney, limit, current + 1, memo);
        return memo[current] = Math.max(steal, noSteal);
    }

    public int rob(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        int[] memo = new int[nums.length + 1];
        Arrays.fill(memo, -1);
        int money0 = findMaxSteal(nums, nums.length - 2, 0, memo);
        Arrays.fill(memo, -1);
        int money1 = findMaxSteal(nums, nums.length - 1, 1, memo);
        return Math.max(money0, money1);
    }

}
