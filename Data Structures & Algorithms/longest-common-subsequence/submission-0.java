class Solution {

    private int recursiveLcs(String text1, String text2, int index1, int index2, int[][] memo) {
        if(index1 == text1.length() || index2 == text2.length()) {
            return 0;
        }
        if(memo[index1][index2] != -1) {
            return memo[index1][index2];
        }
        if(text1.charAt(index1) == text2.charAt(index2)) {
            return memo[index1][index2] = 1 + recursiveLcs(text1, text2, index1 + 1, index2 + 1, memo);
        } else {
            int count1 = recursiveLcs(text1, text2, index1, index2 + 1, memo);
            int count2 = recursiveLcs(text1, text2, index1 + 1, index2, memo);
            return memo[index1][index2] = Math.max(count1, count2);
        }
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int[][] memo = new int[text1.length() + 1][text2.length() + 1];
        for(int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return recursiveLcs(text1, text2, 0, 0, memo);
    }
}
