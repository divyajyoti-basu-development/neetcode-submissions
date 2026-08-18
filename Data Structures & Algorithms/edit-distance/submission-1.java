class Solution {

    private int solve(String word1, String word2, int index1, int index2, int[][] memo) {
        if(index1 == word1.length()) {
            return word2.length() - index2;
        }
        if(index2 == word2.length()) {
            return word1.length() - index1;
        }
        if(memo[index1][index2] != -1) {
            return memo[index1][index2];
        }
        if(word1.charAt(index1) == word2.charAt(index2)) {
            return memo[index1][index2] = solve(word1, word2, index1 + 1, index2 + 1, memo);
        }
        int deleteCharOpr = 1 + solve(word1, word2, index1 + 1, index2, memo);
        int insertCharOpr = 1 + solve(word1, word2, index1, index2 + 1, memo);
        int replaceCharOpr = 1 + solve(word1, word2, index1 + 1, index2 + 1, memo);
        memo[index1][index2] = Math.min(deleteCharOpr, Math.min(insertCharOpr, replaceCharOpr));
        return memo[index1][index2];
    }

    public int minDistance(String word1, String word2) {
        int[][] memo = new int[word1.length()][word2.length()];
        for(int[] cache : memo) {
            Arrays.fill(cache, -1);
        }
        return solve(word1, word2, 0, 0, memo);
    }
}
