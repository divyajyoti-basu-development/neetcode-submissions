class Solution {

    private int solve(int n, int index, int[] memo) {
        if(index == n) {
            return 1;
        }
        if(index > n) {
            return 0;
        }
        if(memo[index] != -1) {
            return memo[index];
        }
        return memo[index] = solve(n, index + 1, memo) + solve(n, index + 2, memo);
    }

    public int climbStairs(int n) {
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        return solve(n, 0, memo);
    }
}
