class Solution {    

    private int getMaxProfit(int[] prices, int index, boolean isBought, Map<String, Integer> memo) {
        if(index >= prices.length) {
            return 0;
        }
        String key = index + "#" + isBought;
        if(memo.containsKey(key)) {
            return memo.get(key);
        }
        if(isBought) {
            int sellProfit = prices[index] + getMaxProfit(prices, index + 2, false, memo);
            int coolDownProfit = getMaxProfit(prices, index + 1, true, memo);
            memo.put(key, Math.max(sellProfit, coolDownProfit));
            return Math.max(sellProfit, coolDownProfit);
        } else {
            int buyProfit = -prices[index] + getMaxProfit(prices, index + 1, true, memo);
            int coolDownProfit = getMaxProfit(prices, index + 1, false, memo);
            memo.put(key, Math.max(buyProfit, coolDownProfit));
            return Math.max(buyProfit, coolDownProfit);
        }        
    }
    public int maxProfit(int[] prices) {
        Map<String, Integer> memo = new HashMap<>();
        return getMaxProfit(prices, 0, false, memo);
    }
}
