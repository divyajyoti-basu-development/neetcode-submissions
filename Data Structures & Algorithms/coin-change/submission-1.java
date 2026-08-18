class Solution {    

    private int getMinChange(int[] coins, int amount, int[] memo) {
        if(amount == 0) {
            return 0;
        }
        if(amount < 0) {
            return -1;
        }
        if(memo[amount] != -2) {
            return memo[amount];
        }
        int minCount = Integer.MAX_VALUE;
        int currentCount = -1;
        for(int index = 0 ; index < coins.length ; index++) {
            currentCount = getMinChange(coins, amount - coins[index] , memo);
            if(currentCount != -1) {
                minCount = Math.min(minCount, 1 + currentCount);
            }
        }
        minCount = minCount == Integer.MAX_VALUE ? -1 : minCount;
        return memo[amount] = minCount;
    }

    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, -2);
        return getMinChange(coins, amount, memo);
    }
}
