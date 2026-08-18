class Solution {

    private int[] memo;

    private int dp(String s, int index) {
        if(index == s.length()) {
            return 1;
        }
        if(s.charAt(index) == '0') {
            return memo[index] = 0;
        }
        if(memo[index] != -1) {
            return memo[index];
        }
        int result = dp(s, index + 1);
        if(index + 1 < s.length() && s.charAt(index) == '1'
        || index + 1 < s.length() && s.charAt(index) == '2'
        && s.charAt(index + 1) - '6' <= 0) {
            result = result + dp(s, index + 2);
        }
        return memo[index] = result;
    }
    public int numDecodings(String s) {
        memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return dp(s, 0);
    }
}