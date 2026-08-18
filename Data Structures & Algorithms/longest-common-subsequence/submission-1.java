class Solution {

    private int solve(String text1, String text2, int index1, int index2, int[][] memo) {
        if(index1 == text1.length() || index2 == text2.length()) {
            return 0;
        }

        if(memo[index1][index2] != -1) {
            return memo[index1][index2];
        }

        if(text1.charAt(index1) == text2.charAt(index2)) {
            return memo[index1][index2] = 1 + solve(text1, text2, index1 + 1, index2 + 1, memo);
        }
        int lcs1 = solve(text1, text2, index1 + 1, index2, memo);
        int lcs2 = solve(text1, text2, index1, index2 + 1, memo);
        return memo[index1][index2] = Math.max(lcs1, lcs2);
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int[][] memo = new int[text1.length()][text2.length()];
        for(int[] cache : memo) {
            Arrays.fill(cache, -1);
        }
        return solve(text1, text2, 0, 0, memo);
    }

}
