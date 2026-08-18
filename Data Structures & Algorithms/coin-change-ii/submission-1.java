class Solution {

    private int solve(int[] coins, int index, int amount, Map<String, Integer> memo) {
        if(amount == 0) {
            return 1;
        }
        if(index == coins.length || amount < 0) {
            return 0;
        }
        String key = index + "#" + amount;
        if(memo.containsKey(key)) {
            return memo.get(key);
        }
        int countWith = solve(coins, index, amount - coins[index], memo);
        int countWithout = solve(coins, index + 1, amount, memo);
        memo.put(key, countWith + countWithout);
        return countWith + countWithout;
    }
    public int change(int amount, int[] coins) {
        Map<String, Integer> memo = new HashMap<>();
        return solve(coins, 0, amount, memo);
    }

}
