class Solution {

    private int recursiveCheckWords(String s, Set<String> wordsSet, int index, int[] memo) {
        if(index == s.length()) {
            return 1;
        }
        if(memo[index] != -1) {
            return memo[index];
        }
        for(int position = index ; position < s.length() ; position++) {
            if(wordsSet.contains(s.substring(index, position + 1))) {
                if(recursiveCheckWords(s, wordsSet, position + 1, memo) == 1) {
                    return memo[index] = 1;
                }
            }
        }
        return memo[index] = 0;

    }
    public boolean wordBreak(String s, List<String> wordDict) {
        int[] memo = new int[s.length() + 1];
        Arrays.fill(memo, -1);
        Set<String> wordsSet = new HashSet<>();
        wordDict.forEach(wordsSet :: add);
        return recursiveCheckWords(s, wordsSet, 0, memo) == 1 ? true : false;
    }
}
