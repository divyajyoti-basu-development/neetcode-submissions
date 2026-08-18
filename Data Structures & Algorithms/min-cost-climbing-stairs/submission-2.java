class Solution {

    private int solve(int[] cost, int index, int[] memo) {
        if(index >= cost.length) {
            return 0;
        }
        if(memo[index] != -1) {
            return memo[index];
        }
        return memo[index] = cost[index] + Math.min(solve(cost, index + 1, memo)
        , solve(cost, index + 2, memo));
    }

    public int minCostClimbingStairs(int[] cost) {
        int[] memo = new int[cost.length];
        Arrays.fill(memo, -1);
        int cost1 = solve(cost, 0, memo);
        int cost2 = solve(cost, 1, memo);
        return Math.min(cost1, cost2);
    }

}
