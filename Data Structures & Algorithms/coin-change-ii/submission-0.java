class Solution {

    private int getChangeCount(int amount, int[] coins, int index, Map<String, Integer> memo) {
        if(amount == 0) {
            return 1;
        }
        if(amount < 0 || index == coins.length) {
            return 0;
        }
        String key = new StringBuilder().append(amount).append(",").append(index).toString();
        if(memo.containsKey(key)) {
            return memo.get(key);
        }
        int withCoin = getChangeCount(amount - coins[index], coins, index, memo);
        int withoutCoin = getChangeCount(amount, coins, index + 1, memo);
        memo.put(key, withCoin + withoutCoin);
        return withCoin + withoutCoin;
    }

    public int change(int amount, int[] coins) {
        Map<String, Integer> memo = new HashMap<>();
        return getChangeCount(amount, coins, 0, memo);
    }

}
