class Solution {
    public int maxProfit(int[] prices) {
        int max = 0, minPrice = prices[0];
        for(int index = 1 ; index < prices.length ; index++) {
            if(prices[index] < minPrice) {
                minPrice = prices[index];
            } else {
                max = Math.max(max, prices[index] - minPrice);
            }
        }
        return max;
    }
}
