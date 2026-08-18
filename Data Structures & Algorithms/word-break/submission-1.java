class Solution {

    private boolean solve(String s, int index, Set<String> wordsSet, Map<Integer, Boolean> memo) {
        if(index == s.length()) {
            return true;
        }
        if(memo.containsKey(index)) {
            return memo.get(index);
        }
        StringBuilder sb = new StringBuilder();        
        for(int pos = index ; pos < s.length() ; pos++) {
            sb.append(s.charAt(pos));
            if(wordsSet.contains(sb.toString()) && solve(s, pos + 1, wordsSet, memo)) {
                memo.put(index, Boolean.TRUE);
                return true;
            }
        }
        memo.put(index, Boolean.FALSE);
        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Map<Integer, Boolean> memo = new HashMap<>();
        Set<String> wordsSet = new HashSet<>();
        wordDict.forEach(str -> wordsSet.add(str));
        return solve(s, 0, wordsSet, memo);
    }
}
