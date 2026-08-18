class Solution {

    private int solve(int[] coins, int index, int target, Map<String, Integer> memo) {
        if(target == 0) {
            return 0;
        }
        if(target < 0 || index == coins.length) {
            return Integer.MAX_VALUE;
        }
        String key = index + "#" + target;
        if(memo.containsKey(key)) {
            return memo.get(key);
        }

        int countWith = solve(coins, index, target - coins[index], memo);     
        countWith = countWith == Integer.MAX_VALUE ? Integer.MAX_VALUE : 1 + countWith;       
        int countWithout = solve(coins, index + 1, target, memo);
        memo.put(key, Math.min(countWith, countWithout));
        return memo.get(key);
    }

    public int coinChange(int[] coins, int amount) {
        Map<String, Integer> memo = new HashMap<>();
        String initialKey = 0 + "#" + amount;
        int result = solve(coins, 0, amount, memo);
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
