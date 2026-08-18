class Solution {

    private int[][] memo;

    private int dp(int[] coins, int index, int amount) {
        if(amount == 0) {
            return 0;
        }
        if(amount < 0 || index == coins.length) {
            return Integer.MAX_VALUE;
        }
        if(memo[amount][index] != -1) {
            return memo[amount][index];
        }
        int result1 = dp(coins, index + 1, amount);
        int result2 = dp(coins, index, amount - coins[index]);
        result2 = result2 == Integer.MAX_VALUE ? Integer.MAX_VALUE : 1 + result2;
        return memo[amount][index] = Math.min(result1, result2);
    }
    public int coinChange(int[] coins, int amount) {
        memo = new int[amount + 1][coins.length];
        for(int row = 0 ; row < memo.length ; row++) {
            for(int col = 0 ; col < memo[0].length ; col++) {
                memo[row][col] = -1;
            }
        }
        int result = dp(coins, 0, amount);
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}