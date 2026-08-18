class Solution {

    private int findMaxSteal(int[] houses, int current, int[] memo) {
        if(current >= houses.length) {
            return 0;
        }
        if(memo[current] != -1) {
            return memo[current];
        }
        int maxAmount = 0;
        for(int index = current + 2 ; index < houses.length ; index++) {
            maxAmount = Math.max(maxAmount, findMaxSteal(houses, index, memo));
        }

        return memo[current] = maxAmount + houses[current];
    }

    public int rob(int[] nums) {
        int[] memo = new int[nums.length + 1];
        Arrays.fill(memo, -1);
        int maxAmount0 = findMaxSteal(nums, 0, memo);
        Arrays.fill(memo, -1);
        int maxAmount1 = findMaxSteal(nums, 1, memo);
        return Math.max(maxAmount0, maxAmount1);
    }
}
