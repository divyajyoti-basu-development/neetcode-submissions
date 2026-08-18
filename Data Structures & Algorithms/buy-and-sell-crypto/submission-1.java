class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0, buyPrice = prices[0];
        for(int index = 1 ; index < prices.length ; index++) {
            if(prices[index] > buyPrice) {
                maxProfit = Math.max(maxProfit, prices[index] - buyPrice);
            } else {
                buyPrice = prices[index];
            }
        }
        return maxProfit;
    }
}
