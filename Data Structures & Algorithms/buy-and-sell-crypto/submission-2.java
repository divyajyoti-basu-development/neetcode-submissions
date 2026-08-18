class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int currentBuy = Integer.MAX_VALUE;
        for(int index = 0 ; index < prices.length ; index++) {
            if(prices[index] < currentBuy) {
                currentBuy = prices[index];
            } else {
                maxProfit = Math.max(maxProfit, prices[index] - currentBuy);
            }
        }
        return maxProfit;
    }
}
