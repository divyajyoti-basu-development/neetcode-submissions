class Solution {
    
    int[] memo;

    private int findMinCost(int total, int current, int[] memo, int[] cost) {
        if(current >= total) {
            return 0;
        }
        if(memo[current] != -1) {
            return memo[current];
        }
        return memo[current] = cost[current] + Math.min(findMinCost(total, current + 1, memo, cost)
        , findMinCost(total, current + 2, memo, cost));
    }
    public int minCostClimbingStairs(int[] cost) {
        int total = cost.length;
        int[] memo = new int[total + 1];
        Arrays.fill(memo, -1);
        int cost0 = findMinCost(total, 0, memo, cost);
        Arrays.fill(memo, -1);
        int cost1 = findMinCost(total, 1, memo, cost);
        return Math.min(cost0, cost1);
    }
}
