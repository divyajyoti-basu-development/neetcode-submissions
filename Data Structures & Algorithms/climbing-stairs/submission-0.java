class Solution {

    private int[] memo;

    private int recursiveFind(int n) {
        if(n == 0 || n < 0) {
            return 0;
        }
        if(memo[n] != 0) {
            return memo[n];
        }
        if(n == 1) {
            return 1;
        }
        if(n == 2) {
            return 2;
        }
        return memo[n] = recursiveFind(n - 2) + recursiveFind(n - 1);
    }

    public int climbStairs(int n) {
        memo = new int[n + 1];
        return recursiveFind(n);
    }
}