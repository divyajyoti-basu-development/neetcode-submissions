class Solution {    

    private int findWays(int n, int current, int[] memo) {
        if(current == n - 2) {
            return 2;
        }
        if(current == n - 1) {
            return 1;
        }
        if(memo[current] != -1) {
            return memo[current];
        }
        return memo[current] = findWays(n, current + 1, memo) + findWays(n, current + 2, memo);
    }

    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return findWays(n, 0, memo);
    }
}
