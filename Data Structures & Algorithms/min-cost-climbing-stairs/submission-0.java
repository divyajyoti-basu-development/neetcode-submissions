class Solution {

    private int[] memo;
    private int totalStairs_minus_1;

    private int recurvsiveFindMinCost(int[] cost, int n) {
        if(n > totalStairs_minus_1) {
            return 0;
        }
        if(n == totalStairs_minus_1) {
            return cost[n];
        }
        if(memo[n] != -1) {
            return memo[n];
        }
        if(n == totalStairs_minus_1 - 1) {
            return cost[n];
        }
        return memo[n] = cost[n] + (int)Math.min(recurvsiveFindMinCost(cost, n + 1), recurvsiveFindMinCost(cost, n + 2));
    }

    public int minCostClimbingStairs(int[] cost) {
        memo = new int[cost.length];
        totalStairs_minus_1 = cost.length - 1;
        Arrays.fill(memo, -1);
        return (int)Math.min(recurvsiveFindMinCost(cost, 0),recurvsiveFindMinCost(cost, 1));
    }
}