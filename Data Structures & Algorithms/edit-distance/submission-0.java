class Solution {

    private int minEdits(String word1, String word2, int index1, int index2, int[][] cache) {
        if(index1 == word1.length()) {
            return word2.length() - index2;
        }
        if(index2 == word2.length()) {
            return word1.length() - index1;
        }
        if(cache[index1][index2] != -1) {
            return cache[index1][index2];
        }
        if(word1.charAt(index1) == word2.charAt(index2)) {
            return cache[index1][index2] = minEdits(word1, word2, index1 + 1, index2 + 1, cache);
        }
        int pos1 = 1 + minEdits(word1, word2, index1 + 1, index2, cache);
        int pos2 = 1 + minEdits(word1, word2, index1, index2 + 1, cache);
        int pos3 = 1 + minEdits(word1, word2, index1 + 1, index2 + 1, cache);
        return cache[index1][index2] = Math.min(pos1, Math.min(pos2, pos3));
    }
    public int minDistance(String word1, String word2) {
        int[][] cache = new int[word1.length()][word2.length()];
        for(int index1 = 0 ; index1 < word1.length() ; index1++) {
            for(int index2 = 0 ; index2 < word2.length() ; index2++) {
                cache[index1][index2] = -1;
            }
        }
        return minEdits(word1, word2, 0, 0, cache);
    }
}